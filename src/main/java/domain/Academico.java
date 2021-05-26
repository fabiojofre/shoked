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
public class Academico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String observacao;
	private Integer status;
	private Date dataInicio;
	private Date dataFim;
	
	@ManyToOne
	@JoinColumn(name = "tipoAcademico_id")
	private TipoAcademico tipoAcademico;

	@OneToMany(mappedBy = "id.academico")
	private List<FrequenciaAcademico> frequenciaA = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "setor_id")
	private Setor setor;
	@ManyToOne
	@JoinColumn(name = "coordenacao_id")
	Coordenacao coordenacao;
	public Academico() {
	}

	public Academico(Integer id, String observacao, EnumStatusMovimento status, 
			Date dataInicio,Date dataFim, TipoAcademico tipoAcademico, Setor setor, Coordenacao coordenacao) {
		super();
		this.id = id;
		this.observacao = observacao;
		this.status = status.getCod();
		this.dataInicio = dataInicio;
		this.tipoAcademico = tipoAcademico;
		this.dataFim = dataFim;
		this.setor = setor;
		this.coordenacao = coordenacao;
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

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public TipoAcademico getTipoAcademico() {
		return tipoAcademico;
	}

	public void setTipoAcademico(TipoAcademico tipoAcademico) {
		this.tipoAcademico = tipoAcademico;
	}


	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	

	public List<FrequenciaAcademico> getFrequenciaA() {
		return frequenciaA;
	}

	public void setFrequenciaA(List<FrequenciaAcademico> frequenciaA) {
		this.frequenciaA = frequenciaA;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}
	

	public Coordenacao getCoordenacao() {
		return coordenacao;
	}

	public void setCoordenacao(Coordenacao coordenacao) {
		this.coordenacao = coordenacao;
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
		Academico other = (Academico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
