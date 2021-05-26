package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Setor  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private int setor;
	private String nome;
	private String ministro;
	
	@OneToMany(mappedBy = "setor")
	private List<Area> area = new ArrayList<>();
	
	@OneToMany(mappedBy = "setor")
	private List<Coordenacao> coordenacao = new ArrayList<>();
	
	public Setor() {
	}
	
	public Setor(Integer id, String nome, String ministro, int setor) {
		super();
		this.id = id;
		this.setor = setor;
		this.nome = nome;
		this.ministro = ministro;
	}
	
	
	public List<Coordenacao> getCoordenacao() {
		return coordenacao;
	}


	public void setCoordenacao(List<Coordenacao> coordenacao) {
		this.coordenacao = coordenacao;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getSetor() {
		return setor;
	}


	public void setSetor(int setor) {
		this.setor = setor;
	}


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMinistro() {
		return ministro;
	}
	public void setMinistro(String ministro) {
		this.ministro = ministro;
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
		Setor other = (Setor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}
