package br.ufrn.imd.reservas.controller;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import br.ufrn.imd.reservas.dominio.Reserva;
import br.ufrn.imd.reservas.repositorios.ReservaRepositorio;

@Named
@SessionScoped
public class ReservaMBean {
	private Reserva reserva;
	private DataModel<Reserva> reservasModel;
	@Inject
	private UsuarioMBean usuarioMBean;
	
	@Inject
	private ReservaRepositorio reservaRepositorio;
	
	public ReservaMBean() {
		reserva = new Reserva();
	}
	
	public String novoReserva() {
		reserva = new Reserva();
		return "/pages/reserva/form.jsf";
	}
	
	public String listarReservas() {
		reservasModel = new ListDataModel<Reserva>(reservaRepositorio.listReserva());
		return "/pages/reserva/list.jsf";
	}
	
	public String cadastrarReserva() {
		reserva.setUsuarioCadastro(usuarioMBean.getUsuarioLogado());
		reservaRepositorio.adicionar(reserva);
		reserva = new Reserva();
		return "/pages/reserva/form.jsf";
	}
	
	public String removerReserva() {
		Reserva reservaRemovido = reservasModel.getRowData();
		reservaRepositorio.remover(reservaRemovido);
		reservasModel = new ListDataModel<Reserva>(reservaRepositorio.listReserva());
		return "/pages/reserva/list.jsf";
	}
	
	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public DataModel<Reserva> getReservasModel() {
		return reservasModel;
	}

	public void setReservasModel(DataModel<Reserva> reservasModel) {
		this.reservasModel = reservasModel;
	}

	public UsuarioMBean getUsuarioMBean() {
		return usuarioMBean;
	}

	public void setUsuarioMBean(UsuarioMBean usuarioMBean) {
		this.usuarioMBean = usuarioMBean;
	}

}
