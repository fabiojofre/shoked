package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import enuns.EnumStatusMovimento;

@Entity
public class Trabalho implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String observacao;
	private Integer status;

	private Date data;
	
	@ManyToOne
	@JoinColumn(name = "tipoTrabalho_id")
	private TipoTrabalho tipoTrabalho;
	
	@ManyToOne
	@JoinColumn(name = "congregacao_id")
	private Congregacao congregacao;
	
	private Area area;
	private Setor setor;
	
	@OneToMany(mappedBy = "id.trabalho")
	private List<FrequenciaTrabalho> frequenciaT = new ArrayList<>();;
	
	
	public Trabalho() {
	}

	public Trabalho(Integer id, String observacao, EnumStatusMovimento status, Date data, 
			TipoTrabalho tipoTrabalho,Congregacao congregacao, Setor setor, Area area) {
		super();
		this.id = id;
		this.observacao = observacao;
		this.status = status.getCod();
		this.data = data;
		this.tipoTrabalho = tipoTrabalho;
		this.congregacao = congregacao;
		this.setor = setor;
		this.area = area;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public EnumStatusMovimento getStatus() {
		return EnumStatusMovimento.toEnum(status);
	}

	public void setStatus(EnumStatusMovimento status) {
		this.status = status.getCod();
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	
	public TipoTrabalho getTipoTrabalho() {
		return tipoTrabalho;
	}

	public void setTipoTrabalho(TipoTrabalho tipoTrabalho) {
		this.tipoTrabalho = tipoTrabalho;
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

	public List<FrequenciaTrabalho> getFrequenciaT() {
		return frequenciaT;
	}

	public void setFrequenciaT(List<FrequenciaTrabalho> frequenciaT) {
		this.frequenciaT = frequenciaT;
	}

	public Congregacao getCongregacao() {
		return congregacao;
	}
	public void setCongregacao(Congregacao congregacao) {
		this.congregacao = congregacao;
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
		Trabalho other = (Trabalho) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
