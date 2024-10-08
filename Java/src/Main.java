import DAO.ClienteDAO;
import DAO.ClienteDAO;
import DTO.Cliente;
import DAO.EstadoDAO;
import DTO.Estado;


public class Main{
    public static void main(String[] args){
        System.out.println("Olá mundo");

        EstadoDAO daoEst = new Estado();
        ClienteDAO daoCli = new Cliente();

        //adicionar novo estado
        Estado novoEstado = new Estado();
        novoEstado.setSigla("SP");
        novoEstado.setDescricao("São Paulo");
        daoEst.adicionarEstado(novoEstado);

        //listar estados
        for(Estado estado : daoEst.listarEstados()){
            System.out.println(estado.getSigla()+ " - "+estado.getDescricao());
        }

        //alterar estado
        novoEstado.setDescricao("São Paulo - Atualizado");
        daoEst.atualizaEstado(novoEstado);

        //deletar estado
        daoEst.deletarEstado(novoEstado.getSigla());


        //adicionar cliente
        Cliente novoCliente = new Cliente();
        novoCliente.setCpf("00000000034");
        novoCliente.setNome("Alfredo");
        novoCliente.setEndereco1("Rua Moisés");
        novoCliente.setEndereco2("Botas de Judas");
        novoCliente.setBairro("Paranaguamirim");
        novoCliente.setCidade("Joinville");
        novoCliente.setEstado("SC");
        novoCliente.setCep("019348");
        novoCliente.setIdade(22);
        novoCliente.setPrimeira_compra(Boolean.TRUE);
        daoCli.adicionarCliente(novoCliente);

        //listar clientes
        for(Cliente cliente : daoCli.listarClientes()){
            System.out.println(cliente.getCpf()+ " - "
                    +cliente.getNome()+ " - "
                    +cliente.getBairro()+ " - "
                    +cliente.getCidade()+ " - "
                    +cliente.getCidade()+ " - "
                    +cliente.getCep()+ " - "
                    +cliente.getIdade()+ " - "
                    +cliente.getPrimeira_compra());
        }

        //alterar cliente
        novoCliente.setNome("Kageyama");
        daoCli.atualizarCliente(novoCliente);

        //deletar cliente
        daoCli.deletarCliente(novoCliente.getCpf());
    }
}