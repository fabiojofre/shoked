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
public class FrequenciaEncontro implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "encontro_id")
	private Encontro encontro;
	
	private Integer frequencia;
	
	private Congregacao congragacao;
	
	private Area area;
	
	public FrequenciaEncontro() {
	}

	public FrequenciaEncontro(Integer id, Encontro encontro, EnumFrequencia frequencia, 
			Congregacao congregacao,Area area) {
		super();
		this.id = id;
		this.encontro = encontro;
		this.frequencia = frequencia.getCod();
		this.congragacao = congregacao;
		this.area = area;
	}

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Encontro getEncontro() {
		return encontro;
	}

	public void setEncontro(Encontro encontro) {
		this.encontro = encontro;
	}

	public EnumFrequencia getFrequencia() {
		return EnumFrequencia.toEnum(frequencia);
	}

	public void setFrequencia(EnumFrequencia frequencia) {
		this.frequencia = frequencia.getCod();
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Congregacao getCongragacao() {
		return congragacao;
	}

	public void setCongragacao(Congregacao congragacao) {
		this.congragacao = congragacao;
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
		FrequenciaEncontro other = (FrequenciaEncontro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
