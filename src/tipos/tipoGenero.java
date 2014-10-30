package tipos;

public enum tipoGenero {
    MASC("Masculino", "M"),
    FEM("Feminino", "F");
    
    private final String descricao;
    private final String tipo;
    
    //construtor enum
    private tipoGenero(String descricao, String tipo){
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
