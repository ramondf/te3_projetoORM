package tipos;
public enum tipoEspecie {
    GATO("Gato", "G"),
    CACHORRO("Cachorro", "C"),
    AVE("Aves e Pássaros","A"),
    PEIXE("Peixes","P");
    
    private final String descricao;
    private final String tipo;
    
    //construtor enum
    private tipoEspecie(String descricao, String tipo){
        this.descricao=descricao;
        this.tipo=tipo;
    }
    
    public String getDescricao(){
        return this.descricao;
    }
    
    public String getTipo(){
        return this.tipo;
    }
    
    public String toString(){
        return (this.getDescricao());
    }
}
