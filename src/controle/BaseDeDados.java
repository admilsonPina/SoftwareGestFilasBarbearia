package controle;
import java.sql.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import modelo.Agendamento;
import modelo.Barbeiro;
import modelo.Cliente;
import modelo.Cortes;
import modelo.Sistema;
import modelo.Utilizador;

public class BaseDeDados {
    private static final String URL = "jdbc:mysql://localhost:3306/TraCabelo";
    private static final String USUARIO = "root";
    private static final String SENHA = "";
    private Connection conecao ;
    
    public void conectar() {
        try {
            conecao = DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Conecao falhada");
        }
    }
    public void desconectar() {
        try {
            if (conecao != null) {
                conecao.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(" Nao desconectado ");
        }
    }


    public void inserirSistema(Sistema sistema) {
        try {
            conectar();

            String query = "INSERT INTO sistema (id, username, password) VALUES (?, ?, ?)";
            PreparedStatement statement = conecao.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, sistema.getId());
            statement.setString(2, sistema.getUsername());
            statement.setString(3, sistema.getPassword());

            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int id = generatedKeys.getInt(1);
                sistema.setId(id); // Definir o ID gerado para o sistema
            }

            desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void atualizarSistema(Sistema sistema) {
        try {
            conectar();

            String query = "UPDATE sistema SET username = ?, password = ? WHERE id = ?";
            PreparedStatement statement = conecao.prepareStatement(query);
            statement.setString(1, sistema.getUsername());
            statement.setString(2, sistema.getPassword());
            statement.setInt(3, sistema.getId());

            statement.executeUpdate();

            desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean autenticarSistema(String username, String password) {
        try {
            conectar();

            String query = "SELECT * FROM sistema WHERE username = ? AND password = ?";
            PreparedStatement statement = conecao.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();
            boolean autenticado = resultSet.next();

            resultSet.close();
            desconectar();

            return autenticado;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    
    public static int inserirUtilizador(Utilizador utilizador) {
        int id = -1;
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "INSERT INTO utilizadores (nome, telefone, tipoUtilizador) VALUES (?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, utilizador.getNome());
            statement.setString(2, utilizador.getTelefone());
            statement.setString(3, utilizador.getTipoUtilizador());

            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                id = generatedKeys.getInt(1);
                utilizador.setId(id); // Definir o ID gerado para o utilizador
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public static void inserirCliente(Cliente cliente) {
        inserirUtilizador(cliente); // Inserir utilizador na tabela utilizadores

        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "INSERT INTO cliente (id, tipocliente) VALUES (?, ?)";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, cliente.getId()); // Usar o ID do utilizador inserido
            statement.setString(2, cliente.getTipoCliente());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void inserirBarbeiro(Barbeiro barbeiro) {
        Utilizador utilizador = new Utilizador(barbeiro.getNome(), barbeiro.getTelefone(), "barbeiro");
        int idUtilizador = inserirUtilizador(utilizador); // Inserir utilizador na tabela utilizadores

        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "INSERT INTO Barbeiro (id, MoradaBarber, CNIBarber, Especialidade) VALUES (?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idUtilizador); // Usar o ID do utilizador inserido
            statement.setString(2, barbeiro.getMoradaBarber());
            statement.setString(3, barbeiro.getCNIBarber());
            statement.setString(4, barbeiro.getEspecialidade());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void atualizar(Utilizador utilizador) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "UPDATE utilizadores SET nome = ?, telefone = ?, tipoUtilizador = ? WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, utilizador.getNome());
            statement.setString(2, utilizador.getTelefone());
            statement.setString(3, utilizador.getTipoUtilizador());
            statement.setInt(4, utilizador.getId());

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Utilizador atualizado com sucesso.");
            } else {
                System.out.println("Nenhum utilizador encontrado com o ID fornecido.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Lidar com a exceção de atualização do utilizador na base de dados
        }
    }
    public static void atualizarCliente(Cliente cliente) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "UPDATE cliente SET tipocliente = ? WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, cliente.getTipoCliente());
            statement.setInt(2, cliente.getId());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Cliente atualizado com sucesso.");
            } else {
                System.out.println("Nenhum cliente foi atualizado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void atualizarBarbeiro(Barbeiro barbeiro) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "UPDATE barbeiro SET especialidade = ? WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, barbeiro.getEspecialidade());
            statement.setInt(2, barbeiro.getId());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Barbeiro atualizado com sucesso.");
            } else {
                System.out.println("Nenhum barbeiro foi atualizado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void removerCliente(int idCliente) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            // Excluir o registro do cliente da tabela cliente
            String queryCliente = "DELETE FROM cliente WHERE id = ?";

            PreparedStatement statementCliente = connection.prepareStatement(queryCliente);
            statementCliente.setInt(1, idCliente);

            int rowsDeletedCliente = statementCliente.executeUpdate();
            if (rowsDeletedCliente > 0) {
                System.out.println("Cliente removido com sucesso.");
            } else {
                System.out.println("Nenhum cliente foi removido.");
            }

            // Excluir o registro do utilizador da tabela utilizadores
            String queryUtilizador = "DELETE FROM utilizadores WHERE id = ?";

            PreparedStatement statementUtilizador = connection.prepareStatement(queryUtilizador);
            statementUtilizador.setInt(1, idCliente);

            int rowsDeletedUtilizador = statementUtilizador.executeUpdate();
            if (rowsDeletedUtilizador > 0) {
                System.out.println("Utilizador removido com sucesso.");
            } else {
                System.out.println("Nenhum utilizador foi removido.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void removerBarbeiro(int idBarbeiro) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            // Excluir o registro do barbeiro da tabela barbeiro
            String queryBarbeiro = "DELETE FROM barbeiro WHERE id = ?";

            PreparedStatement statementBarbeiro = connection.prepareStatement(queryBarbeiro);
            statementBarbeiro.setInt(1, idBarbeiro);

            int rowsDeletedBarbeiro = statementBarbeiro.executeUpdate();
            if (rowsDeletedBarbeiro > 0) {
                System.out.println("Barbeiro removido com sucesso.");
            } else {
                System.out.println("Nenhum barbeiro foi removido.");
            }

            // Excluir o registro do utilizador da tabela utilizadores
            String queryUtilizador = "DELETE FROM utilizadores WHERE id = ?";

            PreparedStatement statementUtilizador = connection.prepareStatement(queryUtilizador);
            statementUtilizador.setInt(1, idBarbeiro);

            int rowsDeletedUtilizador = statementUtilizador.executeUpdate();
            if (rowsDeletedUtilizador > 0) {
                System.out.println("Utilizador removido com sucesso.");
            } else {
                System.out.println("Nenhum utilizador foi removido.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static List<Barbeiro> listarBarbeiros() {
        List<Barbeiro> barbeiros = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "SELECT utilizadores.nome, utilizadores.telefone, barbeiro.especialidade FROM utilizadores " +
                    "JOIN barbeiro ON utilizadores.id = barbeiro.id";

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String telefone = resultSet.getString("telefone");
                String especialidade = resultSet.getString("especialidade");

                Barbeiro barbeiro = new Barbeiro(nome, telefone, especialidade);
                barbeiros.add(barbeiro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return barbeiros;
    }
    public static List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "SELECT utilizadores.id, utilizadores.nome, utilizadores.telefone, cliente.tipocliente " +
                           "FROM utilizadores " +
                           "JOIN cliente ON utilizadores.id = cliente.id";

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String telefone = resultSet.getString("telefone");
                String tipoCliente = resultSet.getString("tipocliente");

                Cliente cliente = new Cliente(nome, telefone, tipoCliente);
                cliente.setId(id);

                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clientes;
    }


    public static Utilizador pesquisarPorId(int id) {
        Utilizador utilizador = null;

        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "SELECT * FROM utilizadores WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String telefone = resultSet.getString("telefone");
                String tipoUtilizador = resultSet.getString("tipoUtilizador");

                utilizador = new Utilizador(nome, telefone, tipoUtilizador);
                utilizador.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return utilizador;
    }
    public static List<Utilizador> pesquisarPorNome(String nome) {
        List<Utilizador> utilizadores = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "SELECT * FROM utilizadores WHERE nome LIKE ?";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "%" + nome + "%");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String telefone = resultSet.getString("telefone");
                String tipoUtilizador = resultSet.getString("tipoUtilizador");

                Utilizador utilizador = new Utilizador(nome, telefone, tipoUtilizador);
                utilizador.setId(id);

                utilizadores.add(utilizador);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return utilizadores;
    }
    public static List<Cliente> pesquisarClientePorNome(String nome) {
        List<Cliente> clientes = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "SELECT utilizadores.id, utilizadores.nome, utilizadores.telefone, cliente.tipocliente " +
                           "FROM utilizadores " +
                           "JOIN cliente ON utilizadores.id = cliente.id " +
                           "WHERE utilizadores.nome LIKE ?";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "%" + nome + "%");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String telefone = resultSet.getString("telefone");
                String tipoCliente = resultSet.getString("tipocliente");

                Cliente cliente = new Cliente(nome, telefone, tipoCliente);
                cliente.setId(id);

                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clientes;
    }
    public static List<Barbeiro> pesquisarBarbeiroPorNome(String nome) {
        List<Barbeiro> barbeiros = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "SELECT utilizadores.nome, utilizadores.telefone, barbeiro.especialidade " +
                           "FROM utilizadores " +
                           "JOIN barbeiro ON utilizadores.id = barbeiro.id " +
                           "WHERE utilizadores.nome LIKE ?";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "%" + nome + "%");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String barbeiroNome = resultSet.getString("nome");
                String telefone = resultSet.getString("telefone");
                String especialidade = resultSet.getString("especialidade");

                Barbeiro barbeiro = new Barbeiro(barbeiroNome, telefone, especialidade);
                barbeiros.add(barbeiro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return barbeiros;
    }

    
    public static void adicionarCorte(Cortes corte) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "INSERT INTO cortes (tipocorte, duracao, custo) VALUES (?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, corte.getTipoCorte());
            int duracaoEmMinutos = (int) corte.getDuracao().toMinutes();
            statement.setInt(2, duracaoEmMinutos);
            statement.setDouble(3, corte.getCusto());

            statement.executeUpdate();
            System.out.println("Corte adicionado com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static List<Cortes> listarCortes() {
        List<Cortes> listaCortes = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "SELECT id, tipocorte, duracao, custo FROM cortes";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String tipoCorte = resultSet.getString("tipocorte");
                int duracaoEmMinutos = resultSet.getInt("duracao");
                Duration duracao = Duration.ofMinutes(duracaoEmMinutos);
                double custo = resultSet.getDouble("custo");

                Cortes corte = new Cortes(id,tipoCorte, duracao, custo);
                listaCortes.add(corte);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaCortes;
    }
    public static Cortes pesquisarCortePorNome(String nomeCorte) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "SELECT id, tipocorte, duracao, custo FROM cortes WHERE tipocorte = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, nomeCorte);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String tipoCorte = resultSet.getString("tipocorte");
                int duracaoEmMinutos = resultSet.getInt("duracao");
                Duration duracao = Duration.ofMinutes(duracaoEmMinutos);
                double custo = resultSet.getDouble("custo");

                Cortes corte = new Cortes(id, tipoCorte, duracao, custo);
                return corte;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    
    public static int getClienteId(Cliente cliente) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "SELECT cliente.id " +
                    "FROM cliente " +
                    "JOIN utilizadores ON cliente.id = utilizadores.id " +
                    "WHERE utilizadores.nome = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, cliente.getNome());

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Retorna -1 se o cliente não for encontrado
    }

    public static int getCorteId(Cortes corte) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "SELECT id FROM cortes WHERE tipocorte = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, corte.getTipoCorte());

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Retorna -1 se o corte não for encontrado
    }

    public static int getBarbeiroId(Barbeiro barbeiro) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "SELECT barbeiro.id " +
                    "FROM barbeiro " +
                    "JOIN utilizadores ON barbeiro.id = utilizadores.id " +
                    "WHERE utilizadores.nome = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, barbeiro.getNome());

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Retorna -1 se o barbeiro não for encontrado
    }

    
    public static void inserirAgendamento(Agendamento agendamento) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            int clienteId;
            if (agendamento.getCliente().getNome().isEmpty()) {
                clienteId = 7; // ID do cliente como 7 quando o nome for vazio
            } else {
                clienteId = getClienteId(agendamento.getCliente());
            }
            
            int corteId = getCorteId(agendamento.getCorte());
            int barbeiroId = getBarbeiroId(agendamento.getBarbeiro());

            if (clienteId != -1 && corteId != -1 && barbeiroId != -1) {
                String query = "INSERT INTO agendamento (cliente_id, data_hora, corte_id, barbeiro_id, status, senha) " +
                        "VALUES (?, ?, ?, ?, ?, ?)";

                PreparedStatement statement = connection.prepareStatement(query);
                statement.setInt(1, clienteId);
                statement.setTimestamp(2, Timestamp.valueOf(agendamento.getDataHora()));
                statement.setInt(3, corteId);
                statement.setInt(4, barbeiroId);
                statement.setString(5, agendamento.getStatus());
                statement.setString(6, agendamento.getSenha());

                statement.executeUpdate();

            } else {
                System.out.println("Erro ao inserir agendamento. Verifique os dados do cliente, corte e barbeiro.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Agendamento> consultarAgendamentosPorData(LocalDate data) {
        List<Agendamento> agendamentos = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "SELECT c.nome AS nomeCliente, " +
                    "u.nome AS nomeBarbeiro, cor.tipocorte, cor.custo, a.data_hora, a.status, a.senha " +
                    "FROM agendamento a " +
                    "JOIN utilizadores u ON a.barbeiro_id = u.id " +
                    "JOIN cortes cor ON a.corte_id = cor.id " +
                    "JOIN utilizadores c ON a.cliente_id = c.id " +
                    "WHERE DATE(a.data_hora) = ?"; // Filtra pela data específica

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setDate(1, Date.valueOf(data));
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
            	
            	String nomeBarbeiro = resultSet.getString("nomeBarbeiro");
                String nomeCliente = resultSet.getString("nomeCliente");
                String tipoCorte = resultSet.getString("tipocorte");
                double custoCorte = resultSet.getDouble("custo");
                LocalDateTime dataHora = resultSet.getTimestamp("data_hora").toLocalDateTime();
                String status = resultSet.getString("status");
                String senha = resultSet.getString("senha");

                Cliente cliente = new Cliente(nomeCliente);
                Barbeiro barbeiro = new Barbeiro (nomeBarbeiro);
                Cortes corte = new Cortes(0, tipoCorte, Duration.ZERO, custoCorte);
                Agendamento agendamento = new Agendamento(cliente, dataHora, corte, barbeiro, status, senha);
                agendamentos.add(agendamento);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return agendamentos;
    }
    public static Map<String, Double> consultarAgendamentosFinalizadosPorBarbeiro(LocalDate data) {
        Map<String, Double> totalPorBarbeiro = new HashMap<>();

        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "SELECT u.nome AS nomeBarbeiro, SUM(cor.custo) AS total " +
                    "FROM agendamento a " +
                    "JOIN utilizadores u ON a.barbeiro_id = u.id " +
                    "JOIN cortes cor ON a.corte_id = cor.id " +
                    "WHERE DATE(a.data_hora) = ? AND a.status = 'finalizado' " +
                    "GROUP BY u.nome";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setDate(1, Date.valueOf(data));
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String nomeBarbeiro = resultSet.getString("nomeBarbeiro");
                double total = resultSet.getDouble("total");

                totalPorBarbeiro.put(nomeBarbeiro, total);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalPorBarbeiro;
    }
    public static void atualizarStatusAgendamento(int idAgendamento, String novoStatus) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "UPDATE agendamento SET status = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, novoStatus);
            statement.setInt(2, idAgendamento);
            statement.executeUpdate();
            System.out.println("Status do agendamento atualizado com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static int getIdAgendamento(Agendamento agendamento) {
        int idAgendamento = 0;

        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "SELECT id FROM agendamento WHERE cliente_id = (SELECT id FROM utilizadores WHERE nome = ?) AND data_hora = ? AND corte_id = ? AND barbeiro_id = (SELECT id FROM utilizadores WHERE nome = ?) AND senha = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, agendamento.getCliente().getNome());
            statement.setTimestamp(2, Timestamp.valueOf(agendamento.getDataHora()));
            statement.setInt(3, agendamento.getCorte().getId());
            statement.setString(4, agendamento.getBarbeiro().getNome());
            statement.setString(5, agendamento.getSenha());
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                idAgendamento = resultSet.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao executar a consulta SQL: " + e.getMessage());
        }

        return idAgendamento;
    }


}
