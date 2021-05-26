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
public class Evento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String observacao;
	private Integer status;
	
	
	private Date data;
	
	@ManyToOne
	@JoinColumn(name = "tipoEvento_id")
	private TipoEvento tipoEvento;
	
	@ManyToOne
	@JoinColumn(name = "Area_id")
	private Area area;
	private Setor setor;
	
	@OneToMany(mappedBy = "id.encontro")
	private List<FrequenciaEvento> frequenciaE = new ArrayList<>();;;
	
	
	public Evento() {
	}

	public Evento(Integer id, String observacao, EnumStatusMovimento status, 
			Date data, TipoEvento tipoEvento,Setor setor, Area area) {
		super();
		this.id = id;
		this.observacao = observacao;
		this.status = status.getCod();
		this.data = data;
		this.tipoEvento = tipoEvento;
		this.area = area;
		this.setor =setor;
	}
	public List<FrequenciaEvento> getFrequenciaE() {
		return frequenciaE;
	}

	public void setFrequenciaS(List<FrequenciaEvento> frequenciaE) {
		this.frequenciaE = frequenciaE;
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

	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}
	
	public Setor getSetor() {
		return setor;
	}
	public void setSetor(Setor setor) {
		this.setor = setor;
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
		Evento other = (Evento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
