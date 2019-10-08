package br.ufrn.imd.reservas.dominio;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Reserva {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_RESERVA")
	@SequenceGenerator(name="SEQ_RESERVA", sequenceName="id_seq_reserva", allocationSize=1)
	private int id;
	private String descricao;
	
	//Para Datas
	@Temporal(TemporalType.DATE)
	private Date dataReserva;
	
	//Para chave estrangeira
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuarioCadastro;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(Date dataReserva) {
		this.dataReserva = dataReserva;
	}

	public Usuario getUsuarioCadastro() {
		return usuarioCadastro;
	}

	public void setUsuarioCadastro(Usuario usuarioCadastro) {
		this.usuarioCadastro = usuarioCadastro;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
