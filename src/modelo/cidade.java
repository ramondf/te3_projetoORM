package modelo;
public class cidade implements java.io.Serializable{
    private  int codigo;
    private String nome;
    private String sigla;

    public cidade() {
    }

    public cidade(int codigo, String nome, String sigla) {
        this.codigo = codigo;
        this.setNome(nome);
        this.setSigla(sigla);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome.toUpperCase();
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla.toUpperCase();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.codigo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final cidade other = (cidade) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }
     public String toString(){
         return (this.getCodigo()+"-"+this.getNome()+"-"+this.getSigla());
     }   
}
