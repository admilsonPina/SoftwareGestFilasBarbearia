package modoConsola;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import controle.Barbearia;
import controle.BaseDeDados;
import modelo.Agendamento;
import modelo.Barbeiro;
import modelo.Cliente;
import modelo.Cortes;

public class TesteBarbearia {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Barbearia barbearia = new Barbearia();
        List<Barbeiro> barbeiros = BaseDeDados.listarBarbeiros();

        if (barbeiros.isEmpty()) {
            System.out.println("Nenhum barbeiro disponivel.");
            ler.close();
            return;
        }

        while (true) {
            // Obter nome do cliente
            System.out.println("Digite o nome do cliente:");
            String nomeCliente = ler.nextLine();

            // Pesquisar cliente pelo nome
            List<Cliente> clientes = BaseDeDados.pesquisarClientePorNome(nomeCliente);
            Cliente cliente = null;

            if (!clientes.isEmpty()) {
                if (clientes.size() == 1) {
                    cliente = clientes.get(0);
                    System.out.println("Cliente encontrado: " + cliente.getNome());
                } else {
                    System.out.println("Varios clientes encontrados com o mesmo nome:");
                    for (int i = 0; i < clientes.size(); i++) {
                        cliente = clientes.get(i);
                        System.out.println((i + 1) + ". Nome: " + cliente.getNome() + " Tel: " + cliente.getTelefone()
                                + " Descricao: " + cliente.getTipoUtilizador());
                    }

                    System.out.println("Digite o numero do cliente desejado:");
                    int numeroCliente = ler.nextInt();
                    ler.nextLine(); // Limpar o buffer do scanner

                    if (numeroCliente >= 1 && numeroCliente <= clientes.size()) {
                        cliente = clientes.get(numeroCliente - 1);
                        System.out.println("Cliente selecionado: " + cliente.getNome());
                    } else {
                        System.out.println("Numero de cliente invalido.");
                        continue;
                    }
                }
            } else {
                System.out.println("Cliente nao registrado");
                System.out.println("");
                System.out.println("Registrando o cliente " + nomeCliente);
                // Registrar novo cliente se não existir
                System.out.print("Digite o numero do cliente: ");
                String numeroCliente = ler.nextLine();

                // Solicitar o tipo do cliente
                System.out.print("Digite o tipo do cliente (Adulto ou Criança): ");
                String tipoCliente = ler.nextLine();

                // Criar um novo objeto Cliente com os dados fornecidos
                cliente = new Cliente(nomeCliente, numeroCliente, tipoCliente);
                System.out.println("Novo cliente registrado: " + cliente.getNome());
            }

            // Listar cortes disponíveis
            List<Cortes> listaCortes = BaseDeDados.listarCortes();

            if (!listaCortes.isEmpty()) {
                System.out.println("\nCortes disponiveis:");
                for (int i = 0; i < listaCortes.size(); i++) {
                    Cortes corte = listaCortes.get(i);
                    System.out.println((i + 1) + ". Tipo de Corte: " + corte.getTipoCorte());
                    System.out.println("   Custo: " + corte.getCusto() + "$00");
                    System.out.println("   Duracao: " + corte.getDuracao().toMinutes() + " minutos");
                    System.out.println();
                }

                // Selecionar um corte
                System.out.println("Selecione o numero do corte desejado:");
                int numeroCorte = ler.nextInt();
                ler.nextLine(); // Limpar o buffer do scanner

                if (numeroCorte >= 1 && numeroCorte <= listaCortes.size()) {
                    Cortes corteSelecionado = listaCortes.get(numeroCorte - 1);

                    System.out.println("Barbeiros disponiveis:");
                    for (int i = 0; i < barbeiros.size(); i++) {
                        Barbeiro barbeiro = barbeiros.get(i);
                        System.out.println("Numero: " + (i + 1));
                        System.out.println("Nome: " + barbeiro.getNome());
                        System.out.println("Especialidade: " + barbeiro.getEspecialidade());
                        System.out.println();
                    }

                    // Selecionar um barbeiro
                    System.out.println("Selecione o numero do barbeiro desejado:");
                    int numeroBarbeiro = ler.nextInt();
                    ler.nextLine(); // Limpar o buffer do scanner

                    if (numeroBarbeiro >= 1 && numeroBarbeiro <= barbeiros.size()) {
                        Barbeiro barbeiroSelecionado = barbeiros.get(numeroBarbeiro - 1);

                        // Agendar o corte com o cliente, data/hora, corte selecionado e barbeiro selecionado
                        // Usando data/hora atual como exemplo
                        LocalDateTime horarioProximoAgendamento;
                        LocalDateTime dataHora;
                        LocalDateTime dataHoraMarcacao = LocalDateTime.now();

                        dataHora = LocalDateTime.now();
                        if (barbearia.getTamanho(barbeiroSelecionado) == 0) {
                            // Para o primeiro agendamento, o próximo horário é o horário atual + duração do corte
                            horarioProximoAgendamento = dataHora.plus(corteSelecionado.getDuracao());
                            barbearia.agendarCliente(cliente, dataHora, corteSelecionado, barbeiroSelecionado,"","");
                        } else {
                            // Para os próximos agendamentos, o próximo horário é o horário do último agendamento + duração do corte
                            Agendamento ultimoAgendamento = barbearia.getUltimoAgendamento(barbeiroSelecionado);
                            dataHora = ultimoAgendamento.getDataHora().plus(ultimoAgendamento.getCorte().getDuracao());
                            horarioProximoAgendamento = dataHora.plus(corteSelecionado.getDuracao());
                            barbearia.agendarCliente(cliente, dataHora, corteSelecionado, barbeiroSelecionado,"","");
                        }

                        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");
                        System.out.println("-----------------------------------------");
                        System.out.println("          TICKET DE MARCACAO            ");
                        System.out.println("-----------------------------------------");
                        System.out.println("Cliente: " + cliente.getNome());
                        System.out.println("Data/Hora Marcacao: " + dataHoraMarcacao);
                        System.out.println("Tipo de Corte: " + corteSelecionado.getTipoCorte());
                        System.out.println("Barbeiro: " + barbeiroSelecionado.getNome());
                        System.out.println("Custo: " + corteSelecionado.getCusto() + "$00");
                        System.out.println("Hora Marcada para o Corte: " + dataHora.format(formato));
                        System.out.println("Tamanho da Fila: " + barbearia.getTamanho(barbeiroSelecionado));
                        System.out.println("-----------------------------------------");
                        System.out.println("                                         ");
                        System.out.println("Estou livre apartir de : " + horarioProximoAgendamento.format(formato));
                        // Exibir fila de atendimento
                        System.out.println("\nFila de Atendimento:");
                        barbearia.atualizarTamanhoFila(barbeiroSelecionado);
                        barbearia.exibirFila(barbeiroSelecionado);
                    } else {
                        System.out.println("Número de barbeiro inválido.");
                    }
                } else {
                    System.out.println("Número de corte inválido.");
                }
            } else {
                System.out.println("Nenhum corte disponível.");
            }

            System.out.println("\nDeseja realizar outro agendamento? (S/N)");
            String opcao = ler.nextLine();

            if (!opcao.equalsIgnoreCase("S")) {
                break;
            }
        }

        ler.close();
    }
}
