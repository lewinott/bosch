package DTO;
import DAO.EstadoDAO;

public class Estado extends EstadoDAO {
    private String sigla;
    private String descricao;

    public String getSigla(){
        return sigla;
    }

    public void setSigla(String sigla){
        this.sigla = sigla;
    }

    public String getDescricao(){
        return descricao;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
}
