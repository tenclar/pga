package br.gov.ac.seap.pga.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIForm;
import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.gov.ac.seap.pga.enumerator.EnumActionState;
import br.gov.ac.seap.pga.model.OrganizacaoSocial;
import br.gov.ac.seap.pga.service.OrganizacaoSocialService;
import br.gov.ac.seap.pga.util.FacesUtils;

@Controller
@ManagedBean
@Scope("view")
public class OrganizacaoSocialController extends BaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private OrganizacaoSocialService organizacaosocialService;

	private OrganizacaoSocial organizacaosocial;

	private List<OrganizacaoSocial> list = null;

	

	private EnumActionState actionstate = EnumActionState.PESQUISA;

	private UIForm form;

	

	private String argumento;

	private String tipopesquisa = "nome";

	

	public OrganizacaoSocialController() {

	}

	

	

	public void actsalvar() {
		
		try {
			
			this.organizacaosocialService.save(organizacaosocial);

			FacesUtils.info(FacesUtils.mensages("message.save.success"));

			this.actlimpa();

		} catch (Exception e) {
			FacesUtils.erro(FacesUtils.mensages("message.save.error") + e.getMessage());
			System.out.println(e.getMessage());
		}

	}
	
	public List<SelectItem> getSelectItems() {
		List<SelectItem> retorno = null;
		try {
			 retorno = new ArrayList<SelectItem>();
			for (OrganizacaoSocial p : this.organizacaosocialService.findAll()) {
				retorno.add(new SelectItem(p, p.getNome()));
			}
			return retorno;
		} catch (Exception e) {
			return retorno;	
		}
		
		
	}
	
	public void actnovo() {
		this.organizacaosocial = new OrganizacaoSocial();		
		this.organizacaosocial.setUser(super.getUserLogin());		
		this.setActionstate(EnumActionState.FORM);
	}

	public void acteditar() {
		organizacaosocial = this.organizacaosocialService.findById(organizacaosocial.getId());
		this.setActionstate(EnumActionState.FORM);
	}

	public void actlista() {
		list = this.organizacaosocialService.findAll();
		this.setActionstate(EnumActionState.PESQUISA);
	}

	public void actlimpa() {
		this.organizacaosocial = null;
		this.list = null;
	}
	public void actlimpa2() {
		
		this.organizacaosocial = new OrganizacaoSocial();
		this.argumento = new String();
		this.list = null;

	}

	public void actvolta() {
		actlimpa();
		actlista();
	
	}

	


	public void actpesquisa() {
		
		actlimpa();
		try {

			if ("nome".equals(this.tipopesquisa)) {
				this.list = this.organizacaosocialService.findListByNomeLike(argumento);
			}
			

			if (list.isEmpty()) {
				throw new Exception();
			}
		} catch (Exception e) {
			FacesUtils.aviso(FacesUtils.mensages("search.not.found") + e.getMessage());
		}finally{
			
		}

	}

	

	public String getTipopesquisa() {
		return tipopesquisa;
	}

	public void setTipopesquisa(String tipopesquisa) {
		this.tipopesquisa = tipopesquisa;
	}

	public boolean isPesquisando() {
		return EnumActionState.PESQUISA.equals(actionstate);
	}

	public boolean isAddEdit() {
		return EnumActionState.FORM.equals(actionstate);
	}

	public OrganizacaoSocial getOrganizacaoSocial() {
		return organizacaosocial;
	}

	public void setOrganizacaoSocial(OrganizacaoSocial organizacaosocial) {
		this.organizacaosocial = organizacaosocial;
	}

	public List<OrganizacaoSocial> getList() {
		return list;

	}

	public void setActionstate(EnumActionState actionstate) {
		this.actionstate = actionstate;
	}

	public UIForm getForm() {
		return form;
	}

	public void setForm(UIForm form) {
		this.form = form;
	}

	public String getArgumento() {
		return argumento;
	}

	public void setArgumento(String argumento) {
		this.argumento = argumento;
	}

}
