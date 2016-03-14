package br.gov.ac.seap.pga.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIForm;
import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.gov.ac.seap.pga.enumerator.EnumActionState;
import br.gov.ac.seap.pga.model.TipoAdubo;
import br.gov.ac.seap.pga.service.TipoAduboService;
import br.gov.ac.seap.pga.util.FacesUtils;

@Controller
@ManagedBean
@Scope("view")
public class TipoAduboController extends BaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private TipoAduboService tipoAduboService;

	private TipoAdubo tipoAdubo;

	private List<TipoAdubo> list = null;

	private FacesUtils facesUtils;

	private EnumActionState actionstate = EnumActionState.PESQUISA;

	private UIForm form;

	

	private String argumento;

	private String tipopesquisa = "nome";

	

	public TipoAduboController() {

	}

	

	

	public void actsalvar() {
		facesUtils = new FacesUtils();
		try {
			
			this.tipoAduboService.save(tipoAdubo);

			facesUtils.info(facesUtils.mensages("message.save.success"));

			this.actlimpa();

		} catch (Exception e) {
			facesUtils.erro(facesUtils.mensages("message.save.error") + e.getMessage());
			System.out.println(e.getMessage());
		}

	}
	
	public List<SelectItem> getSelectItems() {
		List<SelectItem> retorno = new ArrayList<SelectItem>();

		for (TipoAdubo p : this.tipoAduboService.findAll()) {
			retorno.add(new SelectItem(p, p.getName()));

		}
		return retorno;
	}
	
	public void actnovo() {
		this.tipoAdubo = new TipoAdubo();
		
		this.tipoAdubo.setUser(super.getUserLogin());

		
		this.setActionstate(EnumActionState.FORM);
	}

	public void acteditar() {
		tipoAdubo = this.tipoAduboService.findById(tipoAdubo.getId());
		this.setActionstate(EnumActionState.FORM);
	}

	public void actlista() {
		list = this.tipoAduboService.findAll();
		this.setActionstate(EnumActionState.PESQUISA);
	}

	public void actlimpa() {
		facesUtils = new FacesUtils();
		this.tipoAdubo = new TipoAdubo();
		//this.argumento = new String();
		this.list = null;

		// facesUtils.cleanSubmittedValues(form);
	}

	public void actvolta() {
		actlimpa();
		actlista();
		// this.setActionstate(EnumActionState.PESQUISA);
	}

	


	public void actpesquisa() {
		facesUtils = new FacesUtils();
		actlimpa();
		try {

			if ("nome".equals(this.tipopesquisa)) {
				this.list = this.tipoAduboService.findListByNomeLike(argumento);
			}
			if ("description".equals(this.tipopesquisa)) {
				this.list = this.tipoAduboService.findListByDescriptionLike(argumento);
			}

			if (list.isEmpty()) {
				throw new Exception();
			}
		} catch (Exception e) {
			facesUtils.aviso(facesUtils.mensages("search.not.found") + e.getMessage());
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

	public TipoAdubo getTipoAdubo() {
		return tipoAdubo;
	}

	public void setTipoAdubo(TipoAdubo tipoAdubo) {
		this.tipoAdubo = tipoAdubo;
	}

	public List<TipoAdubo> getList() {
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