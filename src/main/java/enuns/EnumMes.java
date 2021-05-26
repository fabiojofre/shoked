package enuns;

public enum EnumMes {
	
	JANEIRO(1,"Janeiro"),
	FEVEREIRO(2,"Fevereiro"),
	MARCO(3,"Marco"),
	ABRIL(4,"Abril"),
	MAIO(5,"Maio"),
	JUNHO(6,"Junho"),
	JULHO(7,"Julho"),
	AGOSTO(8,"Agosto"),
	SETEMBRO(9,"Setembro"),
	OUTUBRO(10,"Outubro"),
	NOVEMBRO(11,"Novembro"),
	DEZEMBRO(12,"Dezembro");
	
	private int cod;
	private String descricao;
	
	private EnumMes() {
	}
	
	private EnumMes(int cod,String descricao) {
		this.cod =cod;
		this.descricao =descricao;
	}
	public int getCod() {
		return cod;
	}
	public String getDescricao() {
		return descricao;
	}
	public static EnumMes toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		for(EnumMes x: EnumMes.values()) {
			if(cod ==(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido: "+ cod);
	}
}
