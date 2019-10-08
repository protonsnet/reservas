package br.ufrn.imd.reservas.controller;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import br.ufrn.imd.reservas.dominio.Sala;
import br.ufrn.imd.reservas.repositorios.SalaRepositorio;

@Named
@SessionScoped
public class SalaMBean {
	private Sala sala;
	private DataModel<Sala> salasModel;
	@Inject
	private ReservaMBean reservaMBean;
	@Inject
	private SalaRepositorio salaRepositorio;
	
	public SalaMBean() {
		sala = new Sala();
	}
	
	public String novoSala() {
		sala = new Sala();
		return "/pages/sala/form.jsf";
	}
	
	public String listarSalas() {
		salasModel = new ListDataModel<Sala>(salaRepositorio.listSala());
		return "/pages/sala/list.jsf";
	}
	
	public String cadastrarSala() {
		sala.setReservaCadastro(reservaMBean.getReserva()); 
		salaRepositorio.adicionar(sala);
		sala = new Sala();
		return "/pages/sala/form.jsf";
	}
	
	public String removerSala() {
		Sala salaRemovido = salasModel.getRowData();
		salaRepositorio.remover(salaRemovido);
		salasModel = new ListDataModel<Sala>(salaRepositorio.listSala());
		return "/pages/sala/list.jsf";
	}
	
	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public DataModel<Sala> getSalasModel() {
		return salasModel;
	}

	public void setSalasModel(DataModel<Sala> salasModel) {
		this.salasModel = salasModel;
	}

	public ReservaMBean getReservaMBean() {
		return reservaMBean;
	}

	public void setReservaMBean(ReservaMBean reservaMBean) {
		this.reservaMBean = reservaMBean;
	}
}
