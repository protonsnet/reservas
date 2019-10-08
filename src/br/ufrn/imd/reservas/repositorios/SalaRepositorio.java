package br.ufrn.imd.reservas.repositorios;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.ufrn.imd.reservas.dominio.Sala;

@Stateless
public class SalaRepositorio {
	
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Metodo adicionar
	 * @param sala
	 */
	public Sala adicionar(Sala sala) {
		if(sala.getId()==0) {
			em.persist(sala);
		} else {
			em.merge(sala);
		}
		return sala;
	}
	/**
	 * Metodo Remover
	 * @param sala
	 */
	public void remover(Sala sala) {
		sala = em.find(Sala.class, sala.getId());
		em.remove(sala);
	}
	/**
	 * Metodo Listar
	 * @param sala
	 */
	@SuppressWarnings("unchecked")
	public List<Sala> listSala(){
		return (List<Sala>) em.createQuery("select m from Sala m").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Sala> buscarSalaPorReserva(int idReserva){
		String jpaql = "select m from Sala m where m.reservaCadastro.idReserva = :idReserva";
		
		Query q = em.createQuery(jpaql);
		q.setParameter("id", idReserva);
		return q.getResultList();
	}
	
	public Sala buscarSala(int id) {
		String jpaql = "select m from Sala m where m.id = :id";
		Query q = em.createQuery(jpaql);
		try {
			return (Sala) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
		
	}
}
