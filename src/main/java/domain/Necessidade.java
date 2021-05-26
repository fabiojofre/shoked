package domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import enuns.EnumStatusCadastro;
@Entity
public class Necessidade implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "congregacao_id")
	private Congregacao congregacao;
	private Integer status;
	@ManyToOne
	@JoinColumn(name = "area_id")
	private Area area;
	@ManyToOne
	@JoinColumn(name = "setor_id")
	private Setor setor;
	private String necessidade;
	private String observacao;
	private Date data;
	
	public Necessidade() {
	}

	public Necessidade(Integer id, Congregacao congregacao, EnumStatusCadastro status, Area area, 
			Setor setor, String necessidade, String observacao, Date data) {
		super();
		this.id = id;
		this.congregacao = congregacao;
		this.status = status.getCod();
		this.area = area;
		this.setor = setor;
		this.necessidade = necessidade;
		this.observacao = observacao;
		this.data = data;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Congregacao getCongregacao() {
		return congregacao;
	}

	public void setCongregacao(Congregacao congregacao) {
		this.congregacao = congregacao;
	}

	public EnumStatusCadastro getStatus() {
		return EnumStatusCadastro.toEnum(status);
	}

	public void setStatus(EnumStatusCadastro status) {
		this.status = status.getCod();
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public String getNecessidade() {
		return necessidade;
	}

	public void setNecessidade(String necessidade) {
		this.necessidade = necessidade;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Necessidade other = (Necessidade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	


}
