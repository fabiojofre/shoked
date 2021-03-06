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


@Entity
public class Congregacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String responsavel;

	@OneToMany(mappedBy = "congregacao")
	private List<Pessoa> pessoa = new ArrayList<>();
	
	@OneToMany(mappedBy = "congregacao")
	private List<Orgao> orgao = new ArrayList<>();
	
	@OneToMany(mappedBy = "congregacao")
	private List<Trabalho> trabalhos = new ArrayList<>();
	
	@OneToMany(mappedBy = "congregacao")
	private List<Necessidade> necessidade =new ArrayList<>();

	public List<Necessidade> getNecessidade() {
		return necessidade;
	}

	public void setNecessidade(List<Necessidade> necessidade) {
		this.necessidade = necessidade;
	}

	@ManyToOne
	@JoinColumn(name = "area_id")
	private Area area;
	
	private Setor setor;

	public Congregacao() {
	}

	public Congregacao(Integer id, String nome, String responsavel, Area area, Setor setor) {
		super();
		this.id = id;
		this.nome = nome;
		this.responsavel = responsavel;
		this.area = area;
		this.setor = setor;
	}


	public List<Orgao> getOrgao() {
		return orgao;
	}

	public void setOrgao(List<Orgao> orgao) {
		this.orgao = orgao;
	}

	public List<Trabalho> getTrabalhos() {
		return trabalhos;
	}

	public void setTrabalhos(List<Trabalho> trabalhos) {
		this.trabalhos = trabalhos;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public List<Pessoa> getPessoa() {
		return pessoa;
	}

	public void setPessoa(List<Pessoa> pessoa) {
		this.pessoa = pessoa;
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
		Congregacao other = (Congregacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
