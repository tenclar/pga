//package br.gov.ac.seap.pga.model;
//
//import java.io.Serializable;
//import java.math.BigDecimal;
//import java.util.Calendar;
//import java.util.Date;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//import javax.validation.constraints.NotNull;
//
//
//@Entity
//@Table(name="colheita")
//public class Colheita implements Serializable {
//	private static final long serialVersionUID = 1L;
//	
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private Long id;
//	
//	@NotNull
//	@Temporal(TemporalType.TIMESTAMP)
//	private Calendar datacad = Calendar.getInstance();
//	
//	
//	@ManyToOne
//	@JoinColumn(name="user_id")
//	private User user;
//	
//	
//	@NotNull
//	@Temporal(TemporalType.DATE)
//	private Date data_info;
//	
//	@ManyToOne
//	@JoinColumn(name="producao_id")
//	private Producao producao;
//	
//		
//	@NotNull	 
//	private String cultura;
//
//	@NotNull	 
//	private String ciclo;
//	
//	@NotNull	 
//	private String epoca;
//	
//	@NotNull	 
//	private String estagio;
//	
//	@NotNull	 
//	private String umidade;
//	
//	@NotNull	 
//	private String destino;
//	
//	@NotNull
//	@Column(name = "area", precision = 10, scale = 2) 
//	private BigDecimal area;
//	
//	@NotNull
//	@Column(name = "valor", precision = 10, scale = 2) 
//	private BigDecimal valor;
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public Calendar getDatacad() {
//		return datacad;
//	}
//
//	public void setDatacad(Calendar datacad) {
//		this.datacad = datacad;
//	}
//
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//	public Date getData_info() {
//		return data_info;
//	}
//
//	public void setData_info(Date data_info) {
//		this.data_info = data_info;
//	}
//
//	public Producao getProducao() {
//		return producao;
//	}
//
//	public void setProducao(Producao producao) {
//		this.producao = producao;
//	}
//
//
//
//
//	public BigDecimal getArea() {
//		return area;
//	}
//
//	public void setArea(BigDecimal area) {
//		this.area = area;
//	}
//
//	public BigDecimal getValor() {
//		return valor;
//	}
//
//	public void setValor(BigDecimal valor) {
//		this.valor = valor;
//	}
//
//	public String getCultura() {
//		return cultura;
//	}
//
//	public void setCultura(String cultura) {
//		this.cultura = cultura;
//	}
//
//	
//	public String getEpoca() {
//		return epoca;
//	}
//
//	public void setEpoca(String epoca) {
//		this.epoca = epoca;
//	}
//
//	public String getCiclo() {
//		return ciclo;
//	}
//
//	public void setCiclo(String ciclo) {
//		this.ciclo = ciclo;
//	}
//
//	
//	
//	
//	public String getEstagio() {
//		return estagio;
//	}
//
//	public void setEstagio(String estagio) {
//		this.estagio = estagio;
//	}
//
//	public String getUmidade() {
//		return umidade;
//	}
//
//	public void setUmidade(String umidade) {
//		this.umidade = umidade;
//	}
//
//	public String getDestino() {
//		return destino;
//	}
//
//	public void setDestino(String destino) {
//		this.destino = destino;
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((id == null) ? 0 : id.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Colheita other = (Colheita) obj;
//		if (id == null) {
//			if (other.id != null)
//				return false;
//		} else if (!id.equals(other.id))
//			return false;
//		return true;
//	}
//	
//	
//	
//	
//	
//	
//	
//
//
//}
