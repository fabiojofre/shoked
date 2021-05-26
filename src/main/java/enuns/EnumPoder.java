package enuns;

public enum EnumPoder {
	MASTER(1, "Master"),
	PASTOR(2,"Pastor"),
	SUPERVISOR(3,"Supervisor"),
	COORDENADOR(4, "Coordenador"),
	LIDER(5,"Lider"),
	DIRECAO(6,"Direcao"),
	SECRETARIA(7, "Secretaria"),
	LIDERADO(8, "Liderado"),
	ESCALADO(9, "Escalado"),
	CURIOSO(10, "Curioso");
	
	
	private int cod;
	private String descricao;
	
	private EnumPoder() {
	}
	
	private EnumPoder(int cod,String descricao) {
		this.cod =cod;
		this.descricao =descricao;
	}
	public int getCod() {
		return cod;
	}
	public String getDescricao() {
		return descricao;
	}
	public static EnumPoder toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		for(EnumPoder x: EnumPoder.values()) {
			if(cod ==(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido: "+ cod);
	}

}
