package view;


import com.jtattoo.plaf.texture.TextureLookAndFeel;

import controle.BaseDeDados;
import modelo.Agendamento;
import modelo.Barbeiro;
import modelo.Cortes;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Login extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	BaseDeDados baseDeDados = new BaseDeDados();
    
	// 1º Os Componentesprivate
    private JLabel lblNome, lblLOGIN, lblSenha;
    private JTextField txtNome;
    private JButton btnLogin;
    private JButton btnIconRetorc;
    private JPanel painel;
    private Container contetor;
    private JPasswordField PassWSenha;
    private JMenuBar MenuBar;
    private JMenu MenuCadast, MenuRelatorio, MenuSobre, MenuVer;
    private JMenuItem MenuItemSistema, MenuItemBarbeiro, MenuItemCortes, MenuItemAgendamento, MenuItemContabilidade, MenuItemBarb, MenuItemSoftware, MenuItemtiposDeCorte;
    
    // COMPONENTES PARA CADASTRAR BARBEIRO
    private JLabel lblNomeBarb, lblContacBarb, lblCNIBarber, lblMoradaBarb,lblEspecial,lblTipo,lblPreco,lblDuracao ;
    private JTextField txtNomeBarb, txtContacBarb, txtCNIBarber, txtMoradaBarb, txtEspecial, txtTipo,txtPreco,txtDuracao;
    private JButton btnBarb;
    private JPanel painelBarber;

    // COMPONENTES PARA CADASTRAR CORTES
    private JButton btnOK, btnCancelar;
    ImageIcon sistema, contabilidade, software, barbeiro01, barbeiroSobre, agendamento, cortes, tiposDeCorte;
    ImageIcon imgFundo = new ImageIcon(getClass().getResource("..//img//fundo.png"));
    ImageIcon imgFundoBarber = new ImageIcon(getClass().getResource("..//img//barber.png"));
    Font fonte = new Font("Segoe UI", Font.BOLD, 14);
    Cursor cursor = new Cursor(Cursor.HAND_CURSOR); // Escolha o cursor desejado


    //==================================== Trabalhando na imagem para botao  =================================================
    // Pegando a localizaçao da Imagem..
    ImageIcon ImgRetorceder = new ImageIcon(getClass().getResource("..//img//arrow_left_icon_143116.png"));
    Image ImgRetorceder01 = ImgRetorceder.getImage();// Transformando ImageIcon em um Objeto Imagem Para poder dar a imagem uma largura e altura...
    Image RemidencionarIMG = ImgRetorceder01.getScaledInstance(30, 30, Image.SCALE_DEFAULT); // Agora podemos dar a imagem uma largura e altura nova....
    ImageIcon novoImageIconRetorceder = new ImageIcon(RemidencionarIMG);/* Aqui Após redimensionar a imagem usando getScaledInstance(), o código cria um novo objeto
     ImageIcon chamado novoImageIcon utilizando a imagem redimensionada */

    //=======================================================================================================================
    JLabel lblFundo = new JLabel(imgFundo);
    // para tela de fundo de cadast barber...
    JLabel lblFundoBarb = new JLabel(imgFundoBarber);

    public Login() {
        // 2º Configurações do JFrame
        setTitle("Login");
        setSize(400, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);

        contetor = getContentPane();
        contetor.setLayout(null);
        painel = new JPanel();
        painel.setLayout(null); // Definindo o layout como null

        // Carrega a imagem
        BufferedImage image = null;
        try {
            image = ImageIO.read(getClass().getResource("..//img//Estampa-Barbeiro.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (image != null) {
            CircularPanel circularPanel = new CircularPanel(image);
            circularPanel.setBounds(50, 0, 200, 200);
            circularPanel.setBackground(new Color(0, 0, 0, 0));
            painel.add(circularPanel);
        }

        //=========================== INICIALIZAÇAO DE TODOS OS ELEMENTOS ======================
        // INICIALIZAR
        btnBarb = new JButton("Concluir");
        btnOK = new JButton("Salvar");
        lblLOGIN = new JLabel("Login");
        lblSenha = new JLabel("Password");
        lblNome = new JLabel("User");
        txtNome = new JTextField();
        PassWSenha = new JPasswordField();
        btnLogin = new JButton("Login");
        btnIconRetorc = new JButton(novoImageIconRetorceder);
        MenuBar = new JMenuBar();
        MenuCadast = new JMenu("Registrar");
        MenuRelatorio = new JMenu("Relatorio");
        MenuSobre = new JMenu("Sobre");
        MenuVer = new JMenu("Ver");
        MenuItemSistema = new JMenuItem("Sistema");
        MenuItemBarbeiro = new JMenuItem("Barbeiro");
        MenuItemCortes = new JMenuItem("Cortes");
        MenuItemAgendamento = new JMenuItem("Agendamento");
        MenuItemContabilidade = new JMenuItem("Contabilidade");
        MenuItemBarb = new JMenuItem("Barbearia");
        MenuItemSoftware = new JMenuItem("Software");
        MenuItemtiposDeCorte = new JMenuItem("Tipos de Cortes");
        btnOK = new JButton("Salvar");
        btnCancelar = new JButton("Limpar");

        // ImageIcon em MenuItem
        sistema = new ImageIcon(getClass().getResource("..//Icons//sistema-operacional.png"));
        contabilidade = new ImageIcon(getClass().getResource("..//Icons//contabilidade.png"));
        software = new ImageIcon(getClass().getResource("..//Icons//desenvolvimento-de-software.png"));
        agendamento = new ImageIcon(getClass().getResource("..//Icons//agendamento.png"));
        barbeiro01 = new ImageIcon(getClass().getResource("..//Icons//barbearia (1).png"));
        barbeiroSobre = new ImageIcon(getClass().getResource("..//Icons//barbeiro.png"));
        cortes = new ImageIcon(getClass().getResource("..//Icons//corte-de-barba.png"));
        tiposDeCorte = new ImageIcon(getClass().getResource("..//Icons//corte-de-barba.png"));

        //======================================= FIM =========================================

        //================ Colocando ImageIcon dentro de cada MenuItem ================
        MenuItemSistema.setIcon(sistema);
        MenuItemBarbeiro.setIcon(barbeiro01);
        MenuItemBarb.setIcon(barbeiroSobre);
        MenuItemCortes.setIcon(cortes);
        MenuItemSoftware.setIcon(software);
        MenuItemContabilidade.setIcon(contabilidade);
        MenuItemAgendamento.setIcon(agendamento);
        MenuItemtiposDeCorte.setIcon(tiposDeCorte);
        //================================ FIM ================================
        //========================= DANDO COR NO LABEL =========================
        lblLOGIN.setForeground(Color.WHITE);
        lblNome.setForeground(Color.WHITE);
        lblSenha.setForeground(Color.WHITE);
        btnLogin.setBackground(Color.BLACK);
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFont(fonte);
        lblLOGIN.setFont(fonte);

        //=================================== FIM ==================================

        //========================= ADICIONANDO CURSOR NO BOTOES =========================

        btnLogin.setCursor(cursor);
        btnIconRetorc.setCursor(cursor);
        btnLogin.setCursor(cursor);
        MenuRelatorio.setCursor(cursor);
        MenuSobre.setCursor(cursor);
        MenuCadast.setCursor(cursor);
        MenuItemSistema.setCursor(cursor);
        MenuItemBarbeiro.setCursor(cursor);
        MenuItemCortes.setCursor(cursor);

        //================================= FIM ========================================

        //================ CONFIGURAÇAO DE TODOS OS ELEMENTOS ================

        lblFundo.setBounds(0, 0, 400, 720);
        lblLOGIN.setBounds(130, 180, 230, 30);
        lblNome.setBounds(0, 240, 80, 30);
        lblNome.setFont(fonte);
        txtNome.setBounds(90, 235, 200, 40);

        lblSenha.setBounds(0, 335, 200, 40);
        lblSenha.setFont(fonte);
        PassWSenha.setBounds(90, 335, 200, 40);

        btnLogin.setBounds(50, 490, 200, 40);
        MenuBar.setBounds(28, 0, 720, 20);

        // Configuraçao de botao de retorceder
        btnIconRetorc.setBounds(0, 0, 30, 20);
        // Tornando meu botao (btnIconRetorc) transparente...
        btnIconRetorc.setBorderPainted(false);
        btnIconRetorc.setBackground(new Color(0, 0, 0, 0));

        // Configuraçao do painel
        painel.setBounds(50, 40, 300, 650);
        // Semover cor padrao do painel e colocar transparente
        painel.setOpaque(false);

        //================================ FIM ================================

        // ============ ADICIOANANDO MENU DENTRO DO MENU_BAR ===============
        MenuBar.add(MenuCadast);
        MenuBar.add(MenuRelatorio);
        MenuBar.add(MenuSobre);
        MenuBar.add(MenuVer);

        // Adicionando Menu Itens dentro do MenuCadast
        MenuCadast.add(MenuItemSistema);
        MenuCadast.add(MenuItemBarbeiro);
        MenuCadast.add(MenuItemCortes);

        // Adicionando Menu Itens dentro do MenuRelatorio
        MenuRelatorio.add(MenuItemAgendamento);
        MenuRelatorio.add(MenuItemContabilidade);

        // Adicionando Menu Itens dentro do MenuSobre
        MenuSobre.add(MenuItemSoftware);
        MenuSobre.add(MenuItemBarb);

        // Adicionando Menu Itens dentro do MenuVer
        MenuVer.add(MenuItemtiposDeCorte);
        //================================ FIM ================================

        //=========== ADICIONANDO TODOS OS ELEMENTOS DENTRO DO PAINEL ===========
        painel.add(lblLOGIN);
        painel.add(lblNome);
        painel.add(btnLogin);
        painel.add(txtNome);
        painel.add(lblSenha);
        painel.add(PassWSenha);

        //================================= FIM =================================

        //================ ADICIONANDO PAINEL DENTRO DO CONTEINER ================
        contetor.add(btnIconRetorc);
        contetor.add(MenuBar);
        contetor.add(painel);
        contetor.add(lblFundo);
        //=============================== FIM ====================================

        //================ ADICIONANDO EVENTO EM TODOS OS BOTOES ================
        btnLogin.addActionListener(this);
        btnIconRetorc.addActionListener(this);
        MenuItemBarbeiro.addActionListener(this::actionPerformed);
        MenuItemtiposDeCorte.addActionListener(this::actionPerformed);
        MenuItemCortes.addActionListener(this::actionPerformed);
        MenuItemBarb.addActionListener(this::actionPerformed);
        MenuItemAgendamento.addActionListener(this::actionPerformed);
        MenuItemContabilidade.addActionListener(this::actionPerformed);
        MenuItemSoftware.addActionListener(this::actionPerformed);
        btnBarb.addActionListener(this);
        btnCancelar.addActionListener(this);
        btnOK.addActionListener(this);
        //================================== FIM ================================

        

    }

    @SuppressWarnings("deprecation")
	@Override
    public void actionPerformed(ActionEvent e) {
        //============== AO CLICAR NO BOTAO ELE VERIFICA SE USUARIO ESTA CADASTRADO PARA INICIAR SEÇAO ================
        if (e.getSource().equals(btnLogin)) {
        	
        	String user, pass;

            user = txtNome.getText();
            pass = PassWSenha.getText();
            
            if (user.isEmpty() && pass.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Usuario e Senha invalido!");
            }
            
            else {
            	
            boolean autenticado = baseDeDados.autenticarSistema(user,pass);	
            
             if(!autenticado){
               JOptionPane.showMessageDialog(this, "Credenciais inválidas",
                        "Erro de Login", JOptionPane.ERROR_MESSAGE);
                } else {
             // Código para abrir o programa
                	
                	TelasBarbearia telaBarbearia = new TelasBarbearia();
                    telaBarbearia.setVisible(true);
                    this.dispose();
              
              
                }
            }
                          
        }
        
        
        if (e.getSource().equals(MenuItemCortes)){
        	
            JFrame frame = new JFrame();
            //CONFIGURAÇAO DA TELA
            frame.setTitle("Registrar Cortes");
            frame.setResizable(false);
            frame.setSize(400, 300);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            frame.setLayout(null);

            // COMPONENTES INICIALIZADA...
            JPanel painel = new JPanel();
            lblTipo = new JLabel("Tipo");
            lblPreco = new JLabel("Preço");
            lblDuracao = new JLabel("Duração");
            txtTipo = new JTextField();
            txtPreco = new JTextField();
            txtDuracao = new JTextField();

            painel.setLayout(null);// Painel null Para conf meus componentes...

            lblTipo.setBounds(100, 15, 40, 70);
            txtTipo.setBounds(160, 35, 150, 30);
            lblPreco.setBounds(100, 65, 40, 70);
            txtPreco.setBounds(160, 85, 150, 30);
            lblDuracao.setBounds(100, 120, 60, 70);
            txtDuracao.setBounds(160, 140, 150, 30);
            btnOK.setBounds(100, 200, 70, 40);
            btnCancelar.setBounds(250, 200, 70, 40);
            painel.setBounds(0, 0, 400, 300);

            painel.add(lblTipo);
            painel.add(lblPreco);
            painel.add(lblDuracao);
            painel.add(txtTipo);
            painel.add(txtPreco);
            painel.add(txtDuracao);
            painel.add(btnOK);
            painel.add(btnCancelar);

            frame.add(painel);
            
            
            
        }
 
        if (e.getSource().equals(btnCancelar)) {
        	
        txtPreco.setText("");
        txtTipo.setText("");
        txtDuracao.setText("");
        
        }
        if (e.getSource().equals(btnOK)) {
        	if (autenticarUser()) {
    	        Corte();
    	    }
        }

        if (e.getSource().equals(MenuItemBarbeiro)) {
            JFrame novaJanela = new JFrame("Cadastrar Novo Barbeiro");
            novaJanela.setVisible(true);
            novaJanela.setTitle("Cadastrar Novo Barbeiro");
            novaJanela.setSize(600, 330);
            novaJanela.setResizable(false);
            novaJanela.setLocationRelativeTo(null);
            setLayout(null);

            // INICIALIZAR COMPONENTES
            lblNomeBarb = new JLabel("Nome");
            lblMoradaBarb = new JLabel("Morada");
            lblCNIBarber = new JLabel("CNI");
            lblContacBarb = new JLabel("Contacto");
            lblEspecial = new JLabel("Especial");
            txtCNIBarber = new JTextField();
            txtMoradaBarb = new JTextField();
            txtContacBarb = new JTextField();
            txtNomeBarb = new JTextField();
            txtEspecial = new JTextField();

            //INICIALIZAR CONTEINOR
            painelBarber = new JPanel();
            painelBarber.setLayout(null);

            // INICIALIAZANDO UM FONTE PARA LABEL COM STRING

            lblNomeBarb.setForeground(Color.WHITE);
            lblNomeBarb.setFont(fonte);
            lblMoradaBarb.setForeground(Color.WHITE);
            lblMoradaBarb.setFont(fonte);
            lblCNIBarber.setForeground(Color.WHITE);
            lblCNIBarber.setFont(fonte);
            lblContacBarb.setForeground(Color.WHITE);
            lblContacBarb.setFont(fonte);
            lblEspecial.setForeground(Color.WHITE);
            lblEspecial.setFont(fonte);

            // ADICIONAR COMPONENTES NO CONTEINER
            painelBarber.add(btnBarb);
            painelBarber.add(lblNomeBarb);
            painelBarber.add(lblMoradaBarb);
            painelBarber.add(lblCNIBarber);
            painelBarber.add(lblContacBarb);
            painelBarber.add(lblEspecial);
            painelBarber.add(txtCNIBarber);
            painelBarber.add(txtMoradaBarb);
            painelBarber.add(txtContacBarb);
            painelBarber.add(txtNomeBarb);
            painelBarber.add(txtEspecial);

            // ADICIONAR OS PAINEL DENTRO DA NOVA JANELA
            novaJanela.add(painelBarber);
            novaJanela.add(lblFundoBarb);

            // Conf Painel...
            painelBarber.setBounds(0, 0, 600, 300);
            painelBarber.setOpaque(false);

            //CONFIGURANDO COMPONENTES
            lblNomeBarb.setBounds(50, 30, 70, 20);
            txtNomeBarb.setBounds(160, 30, 180, 25);

            lblMoradaBarb.setBounds(50, 90, 70, 20);
            txtMoradaBarb.setBounds(160, 90, 180, 25);

            lblCNIBarber.setBounds(50, 150, 70, 20);
            txtCNIBarber.setBounds(160, 150, 180, 25);

            lblContacBarb.setBounds(50, 210, 70, 20);	
            txtContacBarb.setBounds(160, 210, 180, 25);
            

            lblEspecial.setBounds(50, 270, 70, 20);
            txtEspecial.setBounds(160, 270, 180, 25);


            btnBarb.setBounds(470, 110, 100, 40);
            btnBarb.setCursor(cursor);

        }

        if (e.getSource().equals(btnBarb)) {
        	  if (autenticarUser()) {
        	        Barbero();
        	    }
        }
        
        
        if (e.getSource().equals(MenuItemAgendamento)) {
        	
            if (autenticarUser()) {
                // Opções disponíveis 
                String[] options = {"Agendamentos do Dia", "Agendamentos em Data Específica"};

                // Solicita selecione uma opção
                int selectedOption = JOptionPane.showOptionDialog(null, "Selecione a opção desejada:", "Consulta de Agendamentos",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

                // Verifica a opção selecionada 
                if (selectedOption == 0) {
                    // Agendamentos do dia atual
                    LocalDate hoje = LocalDate.now();
                    List<Agendamento> agendamentosDia = BaseDeDados.consultarAgendamentosPorData(hoje);

                    exibirAgendamentos(agendamentosDia);
                } else if (selectedOption == 1) {
                    // Agendamentos em uma data específica escolhida 
                    String inputData = JOptionPane.showInputDialog("Digite a data no formato dd/mm/aaaa:");
                    LocalDate dataEspecifica = LocalDate.parse(inputData, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                    List<Agendamento> agendamentosDataEspecifica = BaseDeDados.consultarAgendamentosPorData(dataEspecifica);

                    exibirAgendamentos(agendamentosDataEspecifica);
                }
            }
        }
        
        if (e.getSource().equals(MenuItemContabilidade)) {
        	
        	if (autenticarUser()) {
            // Opções disponíveis para o usuário
            String[] options = {"Contabilidade do Dia", "Contabilidade em Data Específica"};

            // Solicita ao usuário que selecione uma opção
            int selectedOption = JOptionPane.showOptionDialog(null, "Selecione a opção desejada:", "Relatório de Contabilidade",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            // Verifica a opção selecionada pelo usuário
            if (selectedOption == 0) {
                // Contabilidade do dia atual
                LocalDate hoje = LocalDate.now();
                Map<String, Double> totalPorBarbeiro = BaseDeDados.consultarAgendamentosFinalizadosPorBarbeiro(hoje);

                exibirRelatorioContabilidade(totalPorBarbeiro);
            } else if (selectedOption == 1) {
                // Contabilidade em uma data específica escolhida pelo usuário
                String inputData = JOptionPane.showInputDialog("Digite a data no formato dd/mm/aaaa:");
                LocalDate dataEspecifica = LocalDate.parse(inputData, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                Map<String, Double> totalPorBarbeiro = BaseDeDados.consultarAgendamentosFinalizadosPorBarbeiro(dataEspecifica);

                exibirRelatorioContabilidade(totalPorBarbeiro);
            }
        }
    }


        
        
        if (e.getSource().equals(MenuItemtiposDeCorte)) {
        	List<Cortes> listaCortes = BaseDeDados.listarCortes(); // Obtenha a lista de cortes da base de dados

            // Crie uma matriz para armazenar os dados dos cortes
            Object[][] data = new Object[listaCortes.size()][3];

            // Preencha a matriz com os dados dos cortes
            for (int i = 0; i < listaCortes.size(); i++) {
                Cortes corte = listaCortes.get(i);
                data[i][0] = corte.getTipoCorte();
                data[i][1] = corte.getDuracao();
                data[i][2] = corte.getCusto();
            }

            // Defina os nomes das colunas
            String[] columnNames = {"Tipo de Corte", "Duração", "Preço"};

            // Crie uma tabela com os dados e nomes das colunas
            JTable table = new JTable(data, columnNames);

            // Crie um painel de rolagem para a tabela
            JScrollPane scrollPane = new JScrollPane(table);

            // Exiba a tabela em uma caixa de diálogo JOptionPane
            JOptionPane.showMessageDialog(null, scrollPane);
        }

        if (e.getSource().equals(MenuItemAgendamento)) {
         
        }

        if (e.getSource().equals(MenuItemBarb)) {
            JOptionPane.showMessageDialog(null, "Barbearia: Bom Corte\n" +
                    "N° Tel: 9743647\n" +
                    "Gmail: barbomcorte@gmail.com\n" +
                    "Localização: Praia, Taiti\n");
        }
        if (e.getSource().equals(MenuItemSoftware)) {
            JOptionPane.showMessageDialog(null, "Software: Desenvolvido em Linguagem Java\n" +
                    "\n" +
                    "Identificação: CAA-PP\n" +
                    "\n" +
                    "Grupo:\n" +
                    "-Admilson De Pina\n" +
                    "-Amadou Da Veiga\n" +
                    "-Kevin Sousa\n" +
                    "\n" +
                    "Valério Santos\n" +
                    "vsantos@us.edu.cv ");
        }

        //============================================ FIM ========================================================
    }

    public static void main(String[] args) {
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
    }
 
    public boolean autenticarUser() {

    	    JPanel panel = new JPanel();
    	    JPasswordField passwordField = new JPasswordField(10);
    	    panel.add(new JLabel("User:"));
    	    panel.add(new JTextField(10));
    	    panel.add(new JLabel("Password:"));
    	    panel.add(passwordField);

    	    int option = JOptionPane.showOptionDialog(null, panel, "Autenticação",
    	            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

    	    if (option == JOptionPane.OK_OPTION) {
    	        String user = ((JTextField) panel.getComponent(1)).getText();
    	        char[] password = passwordField.getPassword();
    	        String pass = new String(password);

    	        boolean autenticado = baseDeDados.autenticarSistema(user, pass);

    	        if (autenticado) {
    	        } else {
    	            JOptionPane.showMessageDialog(null, "Autenticação inválida!", "Autenticação", JOptionPane.ERROR_MESSAGE);
    	        }

    	        return autenticado;
    	    }

    	    return false;
    	}


    public void Barbero() {
        String nomeBarber, Contactobarber, CNIBarber, MoradaBarber , Especialidade;

        // Pegando os valores incerido no campo JTextFiel...
        nomeBarber = txtNomeBarb.getText();
        MoradaBarber = txtMoradaBarb.getText();
        Contactobarber = txtContacBarb.getText();
        CNIBarber = txtCNIBarber.getText();
        Especialidade = txtEspecial.getText();

        if (nomeBarber.isEmpty() && MoradaBarber.isEmpty() || Contactobarber.isEmpty() && CNIBarber.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
        } else {
            // Recebendo os dados que foram inserido nas variaveis 
            Barbeiro barber = new Barbeiro(nomeBarber,Contactobarber,CNIBarber,MoradaBarber,Especialidade);

            // Chamando a class base de dados e inserindo Barbeiro na BD
           
           BaseDeDados.inserirBarbeiro(barber);
        }

        txtNomeBarb.setText("");
        txtCNIBarber.setText("");
        txtContacBarb.setText("");
        txtMoradaBarb.setText("");
        txtEspecial.setText("");

    }
    public void Corte() {
        String tipo;
	    double preco;
		Duration duracao;

        // Pegando os valores incerido no campo JTextFiel...
        tipo = txtTipo.getText();
        preco = Integer.parseInt(txtPreco.getText());
        String duracaoTexto = txtDuracao.getText();
        duracao = Duration.parse("PT"+duracaoTexto+"M");
        if (tipo.isEmpty() && preco == 0 && duracao.isZero()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
        } else {
           
           Cortes corte = new Cortes (0,tipo,duracao,preco);
           BaseDeDados.adicionarCorte(corte);
         
        }

        txtPreco.setText("");
        txtDuracao.setText("");
        txtTipo.setText("");
        
    }
    
    public static void exibirAgendamentos(List<Agendamento> agendamentos) {
        String[] columnNames = {"Cliente", "Barbeiro", "Corte", "Custo", "Data/Hora", "Status", "Senha"};
        Object[][] data = new Object[agendamentos.size()][7];

        for (int i = 0; i < agendamentos.size(); i++) {
            Agendamento agendamento = agendamentos.get(i);
            data[i][0] = agendamento.getCliente().getNome();
            data[i][1] = agendamento.getBarbeiro().getNome();
            data[i][2] = agendamento.getCorte().getTipoCorte();
            data[i][3] = agendamento.getCorte().getCusto();
            data[i][4] = agendamento.getDataHora();
            data[i][5] = agendamento.getStatus();
            data[i][6] = agendamento.getSenha();
        }

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        JOptionPane.showMessageDialog(null, scrollPane, "Agendamentos", JOptionPane.PLAIN_MESSAGE);
        
    }
    
    private static void exibirRelatorioContabilidade(Map<String, Double> totalPorBarbeiro) {
        StringBuilder mensagem = new StringBuilder();
        mensagem.append("Relatório de Contabilidade\n\n");

        for (Map.Entry<String, Double> entry : totalPorBarbeiro.entrySet()) {
            String nomeBarbeiro = entry.getKey();
            double total = entry.getValue();

            mensagem.append("Barbeiro: ").append(nomeBarbeiro).append("\n");
            mensagem.append("Total: ").append(total).append("$00\n");
            mensagem.append("------------------------------------\n");
        }

        JOptionPane.showMessageDialog(null, mensagem.toString(), "Contabilidade", JOptionPane.INFORMATION_MESSAGE);
    }



    public void MinhaJanela(JFrame frame, String Titulo, String Menssagem) {

    }
}