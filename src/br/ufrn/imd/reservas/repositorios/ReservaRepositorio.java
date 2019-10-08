package br.ufrn.imd.reservas.repositorios;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.ufrn.imd.reservas.dominio.Reserva;

@Stateless
public class ReservaRepositorio {
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Metodo adicionar
	 * @param Reserva
	 */
	public Reserva adicionar(Reserva reserva) {
		if(reserva.getId()==0) {
			em.persist(reserva);
		} else {
			em.merge(reserva);
		}
		
		return reserva;
	}
	/**
	 * Metodo Remover
	 * @param Reserva
	 */
	public void remover(Reserva reserva) {
		reserva = em.find(Reserva.class, reserva.getId());
		em.remove(reserva);
	}
	/**
	 * Metodo Listar
	 * @param sala
	 */
	@SuppressWarnings("unchecked")
	public List<Reserva> listReserva(){
		return (List<Reserva>) em.createQuery("select m from Reserva m").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Reserva> buscarReservaPorUsuario(String login){
		String jpaql = "select m from Reserva m where m.usuarioCadastro.login = :login";
		
		Query q = em.createQuery(jpaql);
		q.setParameter("login", login);
		return q.getResultList();
	}
	
	public Reserva buscarReserva(int id) {
		String jpaql = "select m from Reserva m where m.id = :id";
		Query q = em.createQuery(jpaql);
		try {
			return (Reserva) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
		
	}

}
