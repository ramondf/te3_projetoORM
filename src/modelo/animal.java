package modelo;

import java.sql.Date;
import tipos.tipoGenero;

public class animal implements java.io.Serializable{
    private int codigo;
    private String nome;
    private Date dataNascimento;
    private String proprietario;
    private tipoGenero genero;
    private raca Raca;

    public animal() {
    }

    public animal(int codigo, String nome, Date dataNascimento, String proprietario, tipoGenero genero, raca Raca) {
        this.codigo = codigo;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.proprietario = proprietario;
        this.genero = genero;
        this.Raca = Raca;
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario.toUpperCase();
    }

    public tipoGenero getGenero() {
        return genero;
    }

    public void setGenero(tipoGenero genero) {
        this.genero = genero;
    }

    public raca getRaca() {
        return Raca;
    }

    public void setRaca(raca Raca) {
        this.Raca = Raca;
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
        final animal other = (animal) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return (this.getCodigo()+"-"+this.getNome());
    }
 
}
