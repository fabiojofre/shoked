package enuns;

public enum EnumStatusCadastro {
	ATIVO(1,"Ativo"),
	INATIVO(2,"Inativo");
	
	private int cod;
	private String descricao;
	
	private EnumStatusCadastro() {
	}
	
	private EnumStatusCadastro(int cod,String descricao) {
		this.cod =cod;
		this.descricao =descricao;
	}
	public int getCod() {
		return cod;
	}
	public String getDescricao() {
		return descricao;
	}
	public static EnumStatusCadastro toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		for(EnumStatusCadastro x: EnumStatusCadastro.values()) {
			if(cod ==(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido: "+ cod);
	}
}
