package DAO;
import DTO.Estado;
import Connection.ConexaoDB;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class EstadoDAO {

        public boolean adicionarEstado(Estado estado){
            String sql = "INSERT INTO tbestado (sigla, descricao) VALUES (?, ?)";

            try(Connection connection = ConexaoDB.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)){

                stmt.setString(1, estado.getSigla());
                stmt.setString(2, estado.getDescricao());

                stmt.executeUpdate();
                stmt.close();
                return true;
            }catch(SQLException e){
                System.out.println("Erro ao adicionar o estado"+ e.getMessage());
                return false;
            }
        }

        public List<Estado> listarEstados(){
            List<Estado> estados = new ArrayList<>();
            String sql = "Select * from tbestado";

            try{
                Connection connection = ConexaoDB.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()){
                    Estado estado = new Estado();
                    estado.setSigla(rs.getString("sigla"));
                    estado.setDescricao(rs.getString("descricao"));
                    estados.add(estado);
                }
            }catch (SQLException e){
                System.out.println("Erro ao adicionar estado: "+e.getMessage());
                return null;
            }
            return estados;
        }

        public boolean atualizaEstado(Estado estado){
            String sql = "UPDATE tbestado SET descricao = ? where sigla = ?";

            try{
                Connection connection = ConexaoDB.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setString(1, estado.getDescricao());
                stmt.setString(2, estado.getSigla());
                stmt.executeUpdate();
                System.out.println("");

                connection.close();
                stmt.close();
                return true;
            }catch (SQLException e){
                System.out.println("Erro ao atualizar estado: "+ e.getMessage());
            }

            return false;
        }

        public void deletarEstado(String sigla){
            String sql = "DELETE FROM tbestado WHERE sigla = ?";

            try{
                Connection connection = ConexaoDB.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);

                stmt.setString(1, sigla);
                stmt.executeUpdate();
                connection.close();
                stmt.close();
                System.out.println("Estado deletado com sucesso!");
            }catch (SQLException e){
                System.out.println("Erro ao deletar estado: "+ e.getMessage());
            }
        }
}
