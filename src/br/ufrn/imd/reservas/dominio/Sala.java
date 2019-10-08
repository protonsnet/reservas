package br.ufrn.imd.reservas.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Sala {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_SALA")
	@SequenceGenerator(name="SEQ_SALA", sequenceName="id_seq_sala", allocationSize=1)
	private int id;
	private String descricao;
	private String status;
	
	//Para chave estrangeira
	@ManyToOne
	@JoinColumn(name = "id_reserva")
	private Reserva reservaCadastro;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Reserva getReservaCadastro() {
		return reservaCadastro;
	}
	public void setReservaCadastro(Reserva reservaCadastro) {
		this.reservaCadastro = reservaCadastro;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		descricao = descricao;
	}
	

}
