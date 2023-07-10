package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.UIManager;

import com.jtattoo.plaf.texture.TextureLookAndFeel;

import controle.Barbearia;
import controle.BaseDeDados;
import controle.FilaAtendimento;
import modelo.Agendamento;
import modelo.Barbeiro;
import modelo.Cliente;
import modelo.Cortes;

public class TelasBarbearia extends javax.swing.JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<Cortes> listaCortes = BaseDeDados.listarCortes();
 	List<Barbeiro> barbeiros = BaseDeDados.listarBarbeiros();
 	Barbearia barbearia = new Barbearia();
 	DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
    DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
 	
    public TelasBarbearia() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        
     // Atualiza o ComboBox de corte
        DefaultComboBoxModel<String> modeloCortes = new DefaultComboBoxModel<>();
        modeloCortes.addElement(""); // Adiciona um elemento vazio no início
        for (Cortes corte : listaCortes) {
            modeloCortes.addElement(corte.getTipoCorte());
        }
        comboBoxListaCorte.setModel(modeloCortes);

        // Atualiza o ComboBox de barbeiro
        DefaultComboBoxModel<String> modeloBarbeiros = new DefaultComboBoxModel<>();
        modeloBarbeiros.addElement("Sem Preferência"); // Adiciona a opção "Sem Preferência"
        for (Barbeiro barbeiro : barbeiros) {
            modeloBarbeiros.addElement(barbeiro.getNome());
        }
        comboBoxListaBarbeiro.setModel(modeloBarbeiros);

               
    }

                          
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jtfNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        comboBoxListaCorte = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        comboBoxListaBarbeiro = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        buttonAgenda = new javax.swing.JButton();
        jdpPrincipal2 = new javax.swing.JDesktopPane();
        jLabel31 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jlData2 = new javax.swing.JLabel();
        jlHora2 = new javax.swing.JLabel();
        jlbarbeiro6 = new javax.swing.JLabel();
        jlStatus4 = new javax.swing.JLabel();
        jlfila4 = new javax.swing.JLabel();
        jlsenha4 = new javax.swing.JLabel();
        jlbarbeiro1 = new javax.swing.JLabel();
        jlStatus5 = new javax.swing.JLabel();
        jlfila5 = new javax.swing.JLabel();
        jlsenha5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jbchamar3 = new javax.swing.JButton();
        jbausente3 = new javax.swing.JButton();
        jbproximo3 = new javax.swing.JButton();
        jbfinalizar3 = new javax.swing.JButton();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jbproximo4 = new javax.swing.JButton();
        jbchamar4 = new javax.swing.JButton();
        jbfinalizar4 = new javax.swing.JButton();
        jbausente4 = new javax.swing.JButton();
        jSeparator9 = new javax.swing.JSeparator();
        jbfila4 = new javax.swing.JButton();
        jbfila5 = new javax.swing.JButton();
        jlfilabarbeiro3 = new javax.swing.JLabel();
        jlsenhabarbeiro3 = new javax.swing.JLabel();
        jlbarbeiro8 = new javax.swing.JLabel();
        jlsenhabarbeiro4 = new javax.swing.JLabel();
        jlbarbeiro9 = new javax.swing.JLabel();
        jlfilabarbeiro4 = new javax.swing.JLabel();
        jluserSistema1 = new javax.swing.JLabel();
        jbfila6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtmensagem1 = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtmensagem = new javax.swing.JTextPane();
        
        jtmensagem1.setEditable(false);
        jScrollPane1.setViewportView(jtmensagem1);

        jtmensagem.setEditable(false);
        jScrollPane2.setViewportView(jtmensagem);


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BARBEARIA");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jDesktopPane1.setBackground(new java.awt.Color(233, 223, 223));
        jDesktopPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jDesktopPane1.setToolTipText("");

        jtfNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNomeActionPerformed(evt);
            }
        });

        jLabel1.setText("NOME:");

        comboBoxListaCorte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxListaCorte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxListaCorteActionPerformed(evt);
            }
        });

        jLabel3.setText("CORTE:");

        comboBoxListaBarbeiro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxListaBarbeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxListaBarbeiroActionPerformed(evt);
            }
        });

        jLabel4.setText("BARBEIRO:");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo8.png"))); // NOI18N

        buttonAgenda.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonAgenda.setText("Agendar");
        buttonAgenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAgendaActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(jtfNome, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(comboBoxListaCorte, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(comboBoxListaBarbeiro, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(buttonAgenda, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jtfNome)
                                .addComponent(jLabel1)
                                .addComponent(jLabel3)
                                .addComponent(comboBoxListaCorte, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboBoxListaBarbeiro, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonAgenda)
                        .addGap(37, 37, 37)))
                .addGap(5, 5, 5))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxListaCorte, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxListaBarbeiro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(buttonAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jdpPrincipal2.setBackground(new java.awt.Color(233, 223, 223));
        jdpPrincipal2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo8.png"))); // NOI18N

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Pessoas na Fila :");

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Barbeiro:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Status:");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel32.setText("Barbeiro:");

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel33.setText("Pessoas na Fila:");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel34.setText("Status:");

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel35.setText("Senha:");

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel36.setText("Senha:");

        jlData2.setFont(new java.awt.Font("Ink Free", 1, 18)); // NOI18N

        jlHora2.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N

        jlbarbeiro6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
      

        jlStatus4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlStatus4.setText("FECHADO");

        jlfila4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlfila4.setText("---");

        jlsenha4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlsenha4.setText("---");

        jlbarbeiro1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
       

        jlStatus5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlStatus5.setText("FECHADO");

        jlfila5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlfila5.setText("---");

        jlsenha5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlsenha5.setText("---");
        
        for (int i = 0; i < barbeiros.size(); i++) {
            Barbeiro barbeiro = barbeiros.get(i);
        if (i == 0) {
            String primeiroNome = barbeiro.getNome();
           
            jlbarbeiro6.setText(primeiroNome);
        } else if (i == 1) {
            String segundoNome = barbeiro.getNome();
            
            jlbarbeiro1.setText(segundoNome);
        }
    }

        jdpPrincipal2.setLayer(jLabel31, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpPrincipal2.setLayer(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpPrincipal2.setLayer(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpPrincipal2.setLayer(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpPrincipal2.setLayer(jSeparator6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpPrincipal2.setLayer(jLabel32, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpPrincipal2.setLayer(jLabel33, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpPrincipal2.setLayer(jLabel34, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpPrincipal2.setLayer(jLabel35, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpPrincipal2.setLayer(jLabel36, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpPrincipal2.setLayer(jlData2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpPrincipal2.setLayer(jlHora2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpPrincipal2.setLayer(jlbarbeiro6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpPrincipal2.setLayer(jlStatus4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpPrincipal2.setLayer(jlfila4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpPrincipal2.setLayer(jlsenha4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpPrincipal2.setLayer(jlbarbeiro1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpPrincipal2.setLayer(jlStatus5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpPrincipal2.setLayer(jlfila5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpPrincipal2.setLayer(jlsenha5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jdpPrincipal2Layout = new javax.swing.GroupLayout(jdpPrincipal2);
        jdpPrincipal2.setLayout(jdpPrincipal2Layout);
        jdpPrincipal2Layout.setHorizontalGroup(
            jdpPrincipal2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator6)
            .addGroup(jdpPrincipal2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jdpPrincipal2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jdpPrincipal2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jlHora2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jdpPrincipal2Layout.createSequentialGroup()
                        .addGroup(jdpPrincipal2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlData2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jdpPrincipal2Layout.createSequentialGroup()
                                .addGroup(jdpPrincipal2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel33))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jdpPrincipal2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlfila4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlfila5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel35)
                            .addGroup(jdpPrincipal2Layout.createSequentialGroup()
                                .addComponent(jLabel32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlbarbeiro1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jdpPrincipal2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jdpPrincipal2Layout.createSequentialGroup()
                                    .addComponent(jLabel36)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlsenha5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jdpPrincipal2Layout.createSequentialGroup()
                                    .addComponent(jLabel34)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jlStatus5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jdpPrincipal2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(jlbarbeiro6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jdpPrincipal2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jlsenha4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jdpPrincipal2Layout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jlStatus4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jdpPrincipal2Layout.createSequentialGroup()
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 14, Short.MAX_VALUE))))
        );
        jdpPrincipal2Layout.setVerticalGroup(
            jdpPrincipal2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdpPrincipal2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlHora2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jdpPrincipal2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jlbarbeiro6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jdpPrincipal2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jlStatus4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jdpPrincipal2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jlfila4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jdpPrincipal2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(jlsenha4))
                .addGap(31, 31, 31)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jdpPrincipal2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32)
                    .addComponent(jlbarbeiro1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jdpPrincipal2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(jlStatus5))
                .addGap(12, 12, 12)
                .addGroup(jdpPrincipal2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33)
                    .addComponent(jlfila5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jdpPrincipal2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(jlsenha5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlData2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );


        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setMinimumSize(new java.awt.Dimension(100, 50));

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel41.setText("User: admin");

        jLabel42.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel42.setText("Barbearia ");

        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel43.setText("Fila :");

        jLabel44.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel44.setText("Senha :");

        jLabel45.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel45.setText("Barbeiro :");

        jbchamar3.setBackground(new java.awt.Color(102, 204, 255));
        jbchamar3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jbchamar3.setText("CHAMAR");
        jbchamar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbchamar3ActionPerformed(evt);
            }
        });

        jbausente3.setBackground(new java.awt.Color(255, 0, 0));
        jbausente3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jbausente3.setText("AUSENTE");
        jbausente3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbausente3ActionPerformed(evt);
            }
        });

        jbproximo3.setBackground(new java.awt.Color(102, 255, 102));
        jbproximo3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jbproximo3.setText("PROXIMO");
        jbproximo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbproximo3ActionPerformed(evt);
            }
        });

        jbfinalizar3.setBackground(new java.awt.Color(204, 204, 204));
        jbfinalizar3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jbfinalizar3.setText("FINALIZAR");
        jbfinalizar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbfinalizar3ActionPerformed(evt);
            }
        });

        jLabel46.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel46.setText("Fila :");

        jLabel47.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel47.setText("Senha :");

        jLabel48.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel48.setText("Barbeiro :");

        jbproximo4.setBackground(new java.awt.Color(102, 255, 102));
        jbproximo4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jbproximo4.setText("PROXIMO");
        jbproximo4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbproximo4ActionPerformed(evt);
            }
        });

        jbchamar4.setBackground(new java.awt.Color(102, 204, 255));
        jbchamar4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jbchamar4.setText("CHAMAR");
        jbchamar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbchamar4ActionPerformed(evt);
            }
        });

        jbfinalizar4.setBackground(new java.awt.Color(204, 204, 204));
        jbfinalizar4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jbfinalizar4.setText("FINALIZAR");
        jbfinalizar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbfinalizar4ActionPerformed(evt);
            }
        });

        jbausente4.setBackground(new java.awt.Color(255, 0, 0));
        jbausente4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jbausente4.setText("AUSENTE");
        jbausente4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbausente4ActionPerformed(evt);
            }
        });

        jbfila4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jbfila4.setText("Abrir");
        jbfila4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbfila4ActionPerformed(evt);
            }
        });

        jbfila5.setBackground(new java.awt.Color(0, 0, 0));
        jbfila5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jbfila5.setForeground(new java.awt.Color(255, 255, 255));
        jbfila5.setText("FILA");
        jbfila5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbfila5ActionPerformed(evt);
            }
        });

        jlfilabarbeiro3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlfilabarbeiro3.setForeground(new java.awt.Color(255, 153, 0));
        jlfilabarbeiro3.setText("---");

        jlsenhabarbeiro3.setBackground(new java.awt.Color(204, 204, 204));
        jlsenhabarbeiro3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlsenhabarbeiro3.setForeground(new java.awt.Color(0, 204, 0));
        jlsenhabarbeiro3.setText("---");

        jlbarbeiro8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlbarbeiro8.setForeground(new java.awt.Color(0, 0, 255));
       

        jlsenhabarbeiro4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlsenhabarbeiro4.setForeground(new java.awt.Color(0, 204, 0));
        jlsenhabarbeiro4.setText("---");

        jlbarbeiro9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlbarbeiro9.setForeground(new java.awt.Color(0, 0, 255));
       

        jlfilabarbeiro4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlfilabarbeiro4.setForeground(new java.awt.Color(255, 153, 0));
        jlfilabarbeiro4.setText("---");

        jluserSistema1.setFont(new java.awt.Font("NSimSun", 1, 14)); // NOI18N

        jbfila6.setBackground(new java.awt.Color(0, 0, 0));
        jbfila6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jbfila6.setForeground(new java.awt.Color(255, 255, 255));
        jbfila6.setText("FILA");
        jbfila6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbfila6ActionPerformed(evt);
            }
        });
        
        for (int i = 0; i < barbeiros.size(); i++) {
            Barbeiro barbeiro = barbeiros.get(i);
        if (i == 0) {
            String primeiroNome = barbeiro.getNome();
          
            jlbarbeiro8.setText(primeiroNome);
        } else if (i == 1) {
            String segundoNome = barbeiro.getNome();
            
            jlbarbeiro9.setText(segundoNome);
        }
    }

        jtmensagem1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 102, 102), new java.awt.Color(255, 102, 102), new java.awt.Color(255, 102, 102), new java.awt.Color(255, 153, 153)));
        jtmensagem1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jScrollPane1.setViewportView(jtmensagem1);

        jtmensagem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 0, 204), new java.awt.Color(167, 0, 205), new java.awt.Color(204, 0, 204), new java.awt.Color(204, 0, 204)));
        jtmensagem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jScrollPane2.setViewportView(jtmensagem);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator8, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator9, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel42)
                                .addGap(33, 33, 33)
                                .addComponent(jbfila4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jluserSistema1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jlfilabarbeiro3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(37, 37, 37)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel44)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(jlsenhabarbeiro3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(44, 44, 44)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel45)
                                            .addComponent(jlbarbeiro8, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jlfilabarbeiro4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(34, 34, 34)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel47)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jlsenhabarbeiro4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(45, 45, 45)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlbarbeiro9, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbchamar4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jbproximo4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbfinalizar4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbausente4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbfila5, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jbausente3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jbfinalizar3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jbchamar3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jbfila6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jbproximo3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(22, 22, 22))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(jbfila4))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jluserSistema1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(jLabel44)
                    .addComponent(jLabel45))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlfilabarbeiro3)
                    .addComponent(jlsenhabarbeiro3)
                    .addComponent(jlbarbeiro8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbproximo3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jbchamar3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbfinalizar3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbausente3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbfila6))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jbproximo4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel46)
                                    .addComponent(jLabel47))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jlfilabarbeiro4)
                                    .addComponent(jlsenhabarbeiro4)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel48)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlbarbeiro9)))
                        .addGap(28, 28, 28)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jbchamar4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbfinalizar4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbausente4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbfila5))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(jdpPrincipal2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jdpPrincipal2, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }
    private void formWindowOpened(java.awt.event.WindowEvent evt) {                                  
        // TODO add your handling code here:
        LocalDateTime dataHora = LocalDateTime.now();
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        jlData2.setText(dataHora.format(formatoData));
        int intervaloAtualizacao = 1000; // 1 segundo

        // Criar um timer para atualizar a hora a cada intervalo definido
        Timer timer = new Timer(intervaloAtualizacao, atualizarHora);
        timer.start();
        
    }                           

    private void jtfNomeActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void comboBoxListaCorteActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        // TODO add your handling code here:
    }                                                  

    private void comboBoxListaBarbeiroActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        // TODO add your handling code here:
    }                                                     

    @SuppressWarnings("unused")
	private void buttonAgendaActionPerformed(java.awt.event.ActionEvent evt) {
        String nomeCliente = jtfNome.getText();
        String corteSelecionado = comboBoxListaCorte.getSelectedItem().toString();

        Cliente cliente = new Cliente(nomeCliente, "", "");

        List<Cliente> clientes = BaseDeDados.pesquisarClientePorNome(nomeCliente);
        if (clientes.isEmpty()) {
            BaseDeDados.inserirCliente(cliente);
        }

        Cortes corte = BaseDeDados.pesquisarCortePorNome(corteSelecionado);

        int numeroBarbeiro = comboBoxListaBarbeiro.getSelectedIndex();
        Barbeiro barbeiroEscolhido;

        if (numeroBarbeiro == 0) {
            if (barbearia.getTamanho(barbeiros.get(0)) == 0) {
                // Sem preferência de barbeiro, mas ambos os barbeiros têm fila vazia
                barbeiroEscolhido = barbeiros.get(0);
            } else if (barbearia.getTamanho(barbeiros.get(1)) == 0) {
                // Sem preferência de barbeiro, mas ambos os barbeiros têm fila vazia
                barbeiroEscolhido = barbeiros.get(1);
            } else {
                // Sem preferência de barbeiro, escolhe o barbeiro com o último agendamento de menor horário
                barbeiroEscolhido = barbearia.getBarbeiroComMenorHorario();
            }
        } else {
            barbeiroEscolhido = barbeiros.get(numeroBarbeiro - 1);
        }

        // Verifica se a variável de senha do barbeiro já foi inicializada
        if (!barbearia.temSenha(barbeiroEscolhido)) {
            // Inicializa a senha com o valor padrão
            barbearia.inicializarSenha(barbeiroEscolhido);
        }

        // Obtém a senha atual do barbeiro
        String senha = barbearia.getSenhaAtual(barbeiroEscolhido);

        // Incrementa a senha atual do barbeiro
        barbearia.incrementarSenha(barbeiroEscolhido);

        LocalDateTime dataHora;
        LocalDateTime dataHoraMarcacao = LocalDateTime.now();

        dataHora = LocalDateTime.now();
        if (barbearia.getTamanho(barbeiroEscolhido) == 0) {
            // Para o primeiro agendamento, o próximo horário é o horário atual + duração do corte
            LocalDateTime horarioProximoAgendamento = dataHora.plus(corte.getDuracao());
            barbearia.agendarCliente(cliente, dataHora, corte, barbeiroEscolhido, "agendado", senha);
        } else {
            // Para os próximos agendamentos, o próximo horário é o horário do último agendamento + duração do corte
            Agendamento ultimoAgendamento = barbearia.getUltimoAgendamento(barbeiroEscolhido);
            dataHora = ultimoAgendamento.getDataHora().plus(ultimoAgendamento.getCorte().getDuracao());
            LocalDateTime horarioProximoAgendamento = dataHora.plus(corte.getDuracao());
            barbearia.agendarCliente(cliente, dataHora, corte, barbeiroEscolhido, "agendado", senha);
        }

        String linhaSeparadora = "----------------------------------------------------------------------------------------";

        String mensagem = linhaSeparadora + "\n";
        mensagem += "TICKET DE MARCAÇÃO            \n";
        mensagem += linhaSeparadora + "\n";
        mensagem += "Cliente: " + cliente.getNome() + "\n";
        mensagem += "Senha: " + senha + "\n";
        mensagem += "Barbeiro : " + barbeiroEscolhido.getNome() + "\n";
        mensagem += "Custo: " + corte.getCusto() + "$00" + "\n";
        mensagem += "Tipo de Corte: " + corte.getTipoCorte() + "\n";
        mensagem += "Data Marcação: " + dataHoraMarcacao.format(formatoData) + "\n";
        mensagem += linhaSeparadora + "\n";
        mensagem += "                     Espere sua vez!!                     \n";
        mensagem += "                                         ";

        JOptionPane.showMessageDialog(null, mensagem);
        barbearia.atualizarTamanhoFila(barbeiroEscolhido);
        jlfilabarbeiro3.setText("" + barbearia.getTamanho(barbeiros.get(0)));
        jlfilabarbeiro4.setText("" + barbearia.getTamanho(barbeiros.get(1)));
        jlfila4.setText("" + barbearia.getTamanho(barbeiros.get(0)));
        jlfila5.setText("" + barbearia.getTamanho(barbeiros.get(1)));

        jtfNome.setText("");
    }
                                         

    private void jbchamar3ActionPerformed(java.awt.event.ActionEvent evt) {                                          
    
    	// Verifica se a fila do barbeiro 1 está vazia
        FilaAtendimento filaBarbeiro1 = barbearia.getFila(barbeiros.get(0));
        if (filaBarbeiro1 != null && !filaBarbeiro1.isEmpty()) {
            // Obtém o próximo agendamento
            Agendamento agendamento = filaBarbeiro1.getPrimeiroAgendamento();

            // Exibe a senha do agendamento para os clientes
            jlsenha4.setText(agendamento.getSenha());
            jlsenhabarbeiro3.setText(agendamento.getSenha());
            
            jlStatus4.setText("Em Serviço");
            
            

            // Atualiza as informações no campo de mensagem
            String mensagem = "Cliente: " + agendamento.getCliente().getNome() + "\n";
            mensagem += "Tipo de Corte: " + agendamento.getCorte().getTipoCorte() + "\n";
            mensagem += "Senha: " + agendamento.getSenha() + "\n";
            mensagem += "Custo: " + agendamento.getCorte().getCusto() + "\n";
            
            jtmensagem.setText(mensagem);
           

            
        } else {
            // Caso a fila esteja vazia, exibe uma mensagem de aviso
            jtmensagem.setText("Não há agendamentos na fila.");
            
        }
      
    }                                         

    private void jbausente3ActionPerformed(java.awt.event.ActionEvent evt) {
        FilaAtendimento filaBarbeiro1 = barbearia.getFila(barbeiros.get(0));
        
        if (filaBarbeiro1 != null && !filaBarbeiro1.isEmpty()) {
            Agendamento agendamento = filaBarbeiro1.getPrimeiroAgendamento();
            
            // Atualiza o status do agendamento para "Cancelado" na base de dados
            int idAgendamento = BaseDeDados.getIdAgendamento(agendamento);
            System.out.println("Id agendamento:"+idAgendamento);
            BaseDeDados.atualizarStatusAgendamento(idAgendamento, "cancelado");
            
            // Remove o agendamento da fila
            filaBarbeiro1.dequeue();
            jtmensagem.setText("Cliente Ausente, corte cancelado.");
            
            // Atualiza a quantidade de pessoas na fila
            jlfila4.setText(Integer.toString(filaBarbeiro1.getTamanho()));
            jlfilabarbeiro3.setText(Integer.toString(filaBarbeiro1.getTamanho()));
            jlStatus4.setText("Aguarde...");
        } else {
            // Caso a fila esteja vazia, exibe uma mensagem de aviso
            jtmensagem.setText("Não há agendamentos na fila.");
        }
    }
  
    private void jbproximo3ActionPerformed(java.awt.event.ActionEvent evt) {
    	
    	// Verifica se a fila do barbeiro 1 está vazia
        FilaAtendimento filaBarbeiro1 = barbearia.getFila(barbeiros.get(0));
        if (filaBarbeiro1 != null && !filaBarbeiro1.isEmpty()) {
            // Obtém o próximo agendamento
            Agendamento agendamento = filaBarbeiro1.getPrimeiroAgendamento();

            // Atualiza as informações no campo de mensagem
            String mensagem = "Proximo a ser atendido \n";
            mensagem +="";
            mensagem +=		"Cliente: " + agendamento.getCliente().getNome() + "\n";
            mensagem += "Tipo de Corte: " + agendamento.getCorte().getTipoCorte() + "\n";
            mensagem += "Marcada: " + agendamento.getDataHora().format(formatoHora) + "\n";
            jtmensagem.setText(mensagem);
        } else {
        	
            // Caso a fila esteja vazia, exibe uma mensagem de aviso
            jtmensagem.setText("Não há agendamentos na fila.");
          
         
            
        }
    }                                          

    private void jbfinalizar3ActionPerformed(java.awt.event.ActionEvent evt) { 
        FilaAtendimento filaBarbeiro1 = barbearia.getFila(barbeiros.get(0));
        
        if (filaBarbeiro1 != null && !filaBarbeiro1.isEmpty()) {
            Agendamento agendamento = filaBarbeiro1.getPrimeiroAgendamento();
            
            // Atualiza o status do agendamento para "Finalizado" na base de dados
            int idAgendamento = BaseDeDados.getIdAgendamento(agendamento);
            System.out.println("Id agendamento:"+idAgendamento);
            BaseDeDados.atualizarStatusAgendamento(idAgendamento, "finalizado");
            
            // Remove o agendamento da fila
            filaBarbeiro1.dequeue();
            jtmensagem.setText("Agendamento finalizado.");
            
            // Atualiza a quantidade de pessoas na fila
            jlfila4.setText(Integer.toString(filaBarbeiro1.getTamanho()));
            jlfilabarbeiro3.setText(Integer.toString(filaBarbeiro1.getTamanho()));
            jlStatus4.setText("Aguarde...");
        } else {
            // Caso a fila esteja vazia, exibe uma mensagem de aviso
            jtmensagem.setText("Não há agendamentos na fila.");
            
        }
    }

    private void jbproximo4ActionPerformed(java.awt.event.ActionEvent evt) {

    	// Verifica se a fila do barbeiro 2 está vazia
        FilaAtendimento filaBarbeiro2 = barbearia.getFila(barbeiros.get(1));
        if (filaBarbeiro2 != null && !filaBarbeiro2.isEmpty()) {
        
            // Obtém o próximo agendamento
            Agendamento agendamento = filaBarbeiro2.getPrimeiroAgendamento();

            // Atualiza as informações no campo de mensagem
            String mensagem = "Proximo a ser atendido \n";
            mensagem +="";
            mensagem +=		"Cliente: " + agendamento.getCliente().getNome() + "\n";
            mensagem += "Tipo de Corte: " + agendamento.getCorte().getTipoCorte() + "\n";
            mensagem += "Marcada: " + agendamento.getDataHora().format(formatoHora) + "\n";
            jtmensagem1.setText(mensagem);
            
        } else {
            // Caso a fila esteja vazia, exibe uma mensagem de aviso
            jtmensagem1.setText("Não há agendamentos na fila.");
        }
    }                                          

    private void jbchamar4ActionPerformed(java.awt.event.ActionEvent evt) {   
    	
    	// Verifica se a fila do barbeiro 2 está vazia
        FilaAtendimento filaBarbeiro2 = barbearia.getFila(barbeiros.get(1));
        if (filaBarbeiro2 != null && !filaBarbeiro2.isEmpty()) {
            // Obtém o próximo agendamento
            Agendamento agendamento = filaBarbeiro2.getPrimeiroAgendamento();

            // Exibe a senha do agendamento para os clientes
            jlsenha5.setText(agendamento.getSenha());
            jlsenhabarbeiro4.setText(agendamento.getSenha());
            
            jlStatus5.setText("Em Serviço");
            
           

            // Atualiza as informações no campo de mensagem
            String mensagem = "Cliente: " + agendamento.getCliente().getNome() + "\n";
            mensagem += "Tipo de Corte: " + agendamento.getCorte().getTipoCorte() + "\n";
            mensagem += "Senha: " + agendamento.getSenha() + "\n";
            mensagem += "Custo: " + agendamento.getCorte().getCusto() + "\n";
            jtmensagem1.setText(mensagem);

            
        } else {
            // Caso a fila esteja vazia, exibe uma mensagem de aviso
            jtmensagem1.setText("Não há agendamentos na fila.");
            
        }
    }                     
    
    private void jbfinalizar4ActionPerformed(java.awt.event.ActionEvent evt) {
        FilaAtendimento filaBarbeiro2 = barbearia.getFila(barbeiros.get(1));
        
        if (filaBarbeiro2 != null && !filaBarbeiro2.isEmpty()) {
            Agendamento agendamento = filaBarbeiro2.getPrimeiroAgendamento();
            
            // Atualiza o status do agendamento para "Finalizado" na base de dados
            int idAgendamento = BaseDeDados.getIdAgendamento(agendamento);
            System.out.println("Id agendamento:"+idAgendamento);
            BaseDeDados.atualizarStatusAgendamento(idAgendamento, "finalizado");
            
            // Remove o agendamento da fila
            filaBarbeiro2.dequeue();
            jtmensagem1.setText("Agendamento finalizado.");
            
            // Atualiza a quantidade de pessoas na fila
            jlfila5.setText(Integer.toString(filaBarbeiro2.getTamanho()));
            jlfilabarbeiro4.setText(Integer.toString(filaBarbeiro2.getTamanho()));
            jlStatus5.setText("Aguarde...");
        } else {
            // Caso a fila esteja vazia, exibe uma mensagem de aviso
            jtmensagem1.setText("Não há agendamentos na fila.");
          
        }
    }

    private void jbausente4ActionPerformed(java.awt.event.ActionEvent evt) {
        FilaAtendimento filaBarbeiro2 = barbearia.getFila(barbeiros.get(1));
        
        if (filaBarbeiro2 != null && !filaBarbeiro2.isEmpty()) {
            Agendamento agendamento = filaBarbeiro2.getPrimeiroAgendamento();
            
            // Atualiza o status do agendamento para "Cancelado" na base de dados
            int idAgendamento = BaseDeDados.getIdAgendamento(agendamento);
            System.out.println("Id agendamento:"+idAgendamento);
            BaseDeDados.atualizarStatusAgendamento(idAgendamento, "cancelado");
            
            // Remove o agendamento da fila
            filaBarbeiro2.dequeue();
            jtmensagem1.setText("Cliente Ausente, corte cancelado.");
            
            // Atualiza a quantidade de pessoas na fila
            jlfila5.setText(Integer.toString(filaBarbeiro2.getTamanho()));
            jlfilabarbeiro4.setText(Integer.toString(filaBarbeiro2.getTamanho()));
            jlStatus5.setText("Aguarde...");
        } else {
            // Caso a fila esteja vazia, exibe uma mensagem de aviso
            jtmensagem1.setText("Não há agendamentos na fila.");
            
        }
    }
                                                                                 
    private void jbfila4ActionPerformed(java.awt.event.ActionEvent evt) { 
    	
    	jlStatus4.setText("Aberto");
    	jlStatus5.setText("Aberto");
  
    }                                       

    private void jbfila5ActionPerformed(java.awt.event.ActionEvent evt) {    
    	
      FilaAtendimento filaBarbeiro2 = barbearia.getFila(barbeiros.get(1));
    	
        if (filaBarbeiro2 != null && !filaBarbeiro2.isEmpty()) {
        
        	List<Agendamento> agendamentos = filaBarbeiro2.getAgendamentos();
        	String mensagem = "";
        	
        	for (int i = 0; i < agendamentos.size(); i++) {
        	    Agendamento agendamento = agendamentos.get(i);

        	    // Número do agendamento
        	    String numeroAgendamento = "Agendamento " + (i + 1);
        	    

        	    // Informações do agendamento
        	    String informacoesAgendamento = numeroAgendamento + "\n";
        	    informacoesAgendamento += "Nome: " + agendamento.getCliente().getNome() + "\n";
        	    informacoesAgendamento += "Corte: " + agendamento.getCorte().getTipoCorte() + "\n";
        	    informacoesAgendamento += "Hora: " + agendamento.getDataHora().format(formatoHora) + "\n";

        	    mensagem += informacoesAgendamento + "\n";
        	}

        	jtmensagem1.setText(mensagem);
        	
        	
        }else {
            // Caso a fila esteja vazia, exibe uma mensagem de aviso
            jtmensagem1.setText("Não há agendamentos na fila.");
        }
    }                                       

    private void jbfila6ActionPerformed(java.awt.event.ActionEvent evt) { 
    	
    	 FilaAtendimento filaBarbeiro1 = barbearia.getFila(barbeiros.get(0));
     	
         if (filaBarbeiro1 != null && !filaBarbeiro1.isEmpty()) {
         
         	List<Agendamento> agendamentos = filaBarbeiro1.getAgendamentos();
         	String mensagem = "";
         	
         	for (int i = 0; i < agendamentos.size(); i++) {
         	    Agendamento agendamento = agendamentos.get(i);

         	    // Número do agendamento
         	    String numeroAgendamento = "Agendamento " + (i + 1);

         	    // Informações do agendamento
         	    String informacoesAgendamento = numeroAgendamento + "\n";
         	    informacoesAgendamento += "Nome: " + agendamento.getCliente().getNome() + "\n";
         	    informacoesAgendamento += "Corte: " + agendamento.getCorte().getTipoCorte() + "\n";
         	    informacoesAgendamento += "Hora: " + agendamento.getDataHora().format(formatoHora) + "\n";

         	    mensagem += informacoesAgendamento + "\n";
         	}

         	jtmensagem.setText(mensagem);
         	
         	
         }else {
             // Caso a fila esteja vazia, exibe uma mensagem de aviso
             jtmensagem.setText("Não há agendamentos na fila.");
         }
    }                                       

    
    public static void main(String args[]) {
    	EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    //UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
                    UIManager.setLookAndFeel(new TextureLookAndFeel());
                } catch (Exception ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                } /*catch (IllegalAccessException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }*/
                new Login();
            }
        });

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelasBarbearia().setVisible(true);
            }
        });
    }

                      
    private javax.swing.JButton buttonAgenda;
    private javax.swing.JComboBox<String> comboBoxListaBarbeiro;
    private javax.swing.JComboBox<String> comboBoxListaCorte;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JButton jbausente3;
    private javax.swing.JButton jbausente4;
    private javax.swing.JButton jbchamar3;
    private javax.swing.JButton jbchamar4;
    private javax.swing.JButton jbfila4;
    private javax.swing.JButton jbfila5;
    private javax.swing.JButton jbfila6;
    private javax.swing.JButton jbfinalizar3;
    private javax.swing.JButton jbfinalizar4;
    private javax.swing.JButton jbproximo3;
    private javax.swing.JButton jbproximo4;
    private javax.swing.JDesktopPane jdpPrincipal2;
    private javax.swing.JLabel jlData2;
    private javax.swing.JLabel jlHora2;
    private javax.swing.JLabel jlStatus4;
    private javax.swing.JLabel jlStatus5;
    private javax.swing.JLabel jlbarbeiro1;
    private javax.swing.JLabel jlbarbeiro6;
    private javax.swing.JLabel jlbarbeiro8;
    private javax.swing.JLabel jlbarbeiro9;
    private javax.swing.JLabel jlfila4;
    private javax.swing.JLabel jlfila5;
    private javax.swing.JLabel jlfilabarbeiro3;
    private javax.swing.JLabel jlfilabarbeiro4;
    private javax.swing.JLabel jlsenha4;
    private javax.swing.JLabel jlsenha5;
    private javax.swing.JLabel jlsenhabarbeiro3;
    private javax.swing.JLabel jlsenhabarbeiro4;
    private javax.swing.JLabel jluserSistema1;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTextPane jtmensagem;
    private javax.swing.JTextPane jtmensagem1;

    
    ActionListener atualizarHora = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            LocalDateTime dataHora = LocalDateTime.now();
            DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
            jlHora2.setText(dataHora.format(formatoHora));
        }
        

          };
}


