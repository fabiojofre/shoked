package domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import enuns.EnumFrequencia;

@Entity
public class FrequenciaAcademico implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private int frequenciaA;
	@ManyToOne
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;
	@ManyToOne
	@JoinColumn(name = "academico_id")
	private Academico academico;
	@ManyToOne
	@JoinColumn(name = "coordenacao_id")
	private Coordenacao coordenacao;
	
	
	
	public FrequenciaAcademico() {
	}

	public FrequenciaAcademico(Integer id,Academico academico, Pessoa pessoa, EnumFrequencia frequenciaA) {
		super();
		this.id = id;
		this.academico = academico;
		this.pessoa = pessoa;
		this.frequenciaA = frequenciaA.getCod();
	}


	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Academico getAcademico() {
		return academico;
	}

	public void setAcademico(Academico academico) {
		this.academico = academico;
	}

	public Coordenacao getCoordenacao() {
		return coordenacao;
	}

	public void setCoordenacao(Coordenacao coordenacao) {
		this.coordenacao = coordenacao;
	}

	public EnumFrequencia getFrequenciaA() {
		return EnumFrequencia.toEnum(frequenciaA);
	}


	public void setFrequenciaA(EnumFrequencia frequenciaA) {
		this.frequenciaA = frequenciaA.getCod();
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
		FrequenciaAcademico other = (FrequenciaAcademico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
