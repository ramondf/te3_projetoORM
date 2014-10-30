package modelo;

import tipos.tipoEspecie;

public class raca implements java.io.Serializable{
    private int codigo;
    private String nome;
    private tipoEspecie especie;

    public raca() {
    }

    public raca(int codigo, String nome, tipoEspecie especie) {
        this.codigo = codigo;
        this.nome = nome;
        this.especie = especie;
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

    public tipoEspecie getEspecie() {
        return especie;
    }

    public void setEspecie(tipoEspecie especie) {
        this.especie = especie;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.codigo;
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
        final raca other = (raca) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return (this.getCodigo()+"-"+this.getNome()+"-"+this.getEspecie());
    }
    
}
