package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import enuns.EnumFrequencia;

@Entity
public class FrequenciaTrabalho implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "trabalho_id")
	private Trabalho trabalho;
	
	@OneToMany(mappedBy = "frequenciaTrabalho")
	private List<Pessoa> pessoa = new ArrayList<>();
	
	private Integer frequencia;
	
	private Congregacao congragacao;
	
	private Area area;
	
	private Setor setor;
	
	public FrequenciaTrabalho() {
	}

	public FrequenciaTrabalho(Integer id, Trabalho trabalho, EnumFrequencia frequencia, 
			Congregacao congregacao,Area area, Setor setor) {
		super();
		this.id = id;
		this.trabalho = trabalho;
		this.frequencia = frequencia.getCod();
		this.congragacao = congregacao;
		this.area = area;
		this.setor = setor;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Trabalho getTrabalho() {
		return trabalho;
	}

	public void setTrabalho(Trabalho trabalho) {
		this.trabalho = trabalho;
	}

	public List<Pessoa> getPessoa() {
		return pessoa;
	}

	public void setPessoa(List<Pessoa> pessoa) {
		this.pessoa = pessoa;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public void setFrequencia(Integer frequencia) {
		this.frequencia = frequencia;
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
		FrequenciaTrabalho other = (FrequenciaTrabalho) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
