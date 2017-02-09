package br.ufla.dcc.ppoo.gui;

import br.ufla.dcc.ppoo.i18n.I18N;
import br.ufla.dcc.ppoo.imagens.GerenciadorDeImagens;
import br.ufla.dcc.ppoo.modelo.Avaliacao;
import br.ufla.dcc.ppoo.modelo.Usuario;
import br.ufla.dcc.ppoo.modelo.Jogo;
import br.ufla.dcc.ppoo.servicos.GerenciadorUsuarios;
import br.ufla.dcc.ppoo.util.Utilidades;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Classe que representa a Tela de Autenticação (login no sistema)
 *
 * @author Paulo Jr. e Julio Alves
 */
public class TelaAvaliacao {

    // referência para a tela principal
    private final TelaPrincipal telaPrincipal;
    // referência para o gerenciador de usuários
    private final GerenciadorUsuarios gerenciadorUsuarios;
            
    // componentes da tela
    private JDialog janela;
    private GridBagLayout layout;
    private GridBagConstraints gbc;
    
    private JLabel lbNomeJogo;
    private JLabel lbProdutora;
    private JLabel lbGenero;
    private JLabel lbModoJogo;
    private JLabel lbAno;
    private JTextField txtNomeJogo;
    private JTextField txtProdutora;
    private JTextField txtGenero;
    private JTextField txtModoJogo;
    private JTextField txtAno;
    
    private JPasswordField txtSenha; //Perguntar Professor
    private JButton btnEntrar;
    private JButton btnCancelar;
    

    /**
     * Constrói a tela de autenticação guardando a referência da tela principal
     * e criando o gerenciador de usuários.
     * 
     * @param telaPrincipal Referência da tela principal.
     */
    public TelaAvaliacao(TelaPrincipal telaPrincipal) {
        this.gerenciadorUsuarios = new GerenciadorUsuarios();
        this.telaPrincipal = telaPrincipal;
    }

    /**
     * Inicializa a tela, construindo seus componentes, configurando os eventos
     * e, ao final, exibe a tela.
     */
    public void inicializar() {
        construirTela();
        configurarEventosTela();
        exibirTela();
    }

    /**
     * Adiciona um componente à tela.
     */
    private void adicionarComponente(Component c,
            int anchor, int fill, int linha,
            int coluna, int largura, int altura) {
        gbc.anchor = anchor;
        gbc.fill = fill;
        gbc.gridy = linha;
        gbc.gridx = coluna;
        gbc.gridwidth = largura;
        gbc.gridheight = altura;
        gbc.insets = new Insets(5, 5, 5, 5);
        layout.setConstraints(c, gbc);
        janela.add(c);
    }

    /**
     * Adiciona os componentes da tela tratando layout e internacionalização
     */
    private void adicionarComponentes() {
        //(I18N.obterRotuloUsuarioLogin());
        lbNomeJogo = new JLabel(I18N.obterRotuloNomeJogo());
        adicionarComponente(lbNomeJogo,
                GridBagConstraints.LINE_END,
                GridBagConstraints.NONE,
                0, 0, 1, 1);

        lbProdutora = new JLabel(I18N.obterRotuloProdutora());
        adicionarComponente(lbProdutora,
                GridBagConstraints.LINE_END,
                GridBagConstraints.NONE,
                1, 0, 1, 1);
        
        lbGenero = new JLabel(I18N.obterRotuloGenero());
        adicionarComponente(lbGenero,
                GridBagConstraints.LINE_END,
                GridBagConstraints.NONE,
                2, 0, 1, 1);
        
        lbModoJogo = new JLabel(I18N.obterRotuloModoJogo());
        adicionarComponente(lbModoJogo,
                GridBagConstraints.LINE_END,
                GridBagConstraints.NONE,
                3, 0, 1, 1);
        
        lbAno = new JLabel(I18N.obterRotuloAno());
        adicionarComponente(lbAno,
                GridBagConstraints.LINE_END,
                GridBagConstraints.NONE,
                4, 0, 1, 1);
//^adiciona pergunta -------v adiciona box para escrever
        txtNomeJogo = new JTextField(25);
        adicionarComponente(txtNomeJogo,
                GridBagConstraints.LINE_START,
                GridBagConstraints.NONE,
                0, 1, 1, 1);
        
        txtProdutora = new JTextField(25);
        adicionarComponente(txtProdutora,
                GridBagConstraints.LINE_START,
                GridBagConstraints.NONE,
                1, 1, 1, 1);
        
        txtGenero = new JTextField(25);
        adicionarComponente(txtGenero,
                GridBagConstraints.LINE_START,
                GridBagConstraints.NONE,
                2, 1, 1, 1);
        
        txtModoJogo = new JTextField(25);
        adicionarComponente(txtModoJogo,
                GridBagConstraints.LINE_START,
                GridBagConstraints.NONE,
                3, 1, 1, 1);
        
        txtAno = new JTextField(25);
        adicionarComponente(txtAno,
                GridBagConstraints.LINE_START,
                GridBagConstraints.NONE,
                4, 1, 1, 1); 
        
        
       /* txtSenha = new JPasswordField(25);
        adicionarComponente(txtSenha,
                GridBagConstraints.LINE_START,
                GridBagConstraints.NONE,
                1, 1, 1, 1);*/

        btnEntrar = new JButton(I18N.obterBotaoCadastrar(),
                GerenciadorDeImagens.OK);

        btnCancelar = new JButton(I18N.obterBotaoCancelar(),
                GerenciadorDeImagens.CANCELAR);

        JPanel painelBotoes = new JPanel();
        painelBotoes.add(btnEntrar);
        painelBotoes.add(btnCancelar);

        adicionarComponente(painelBotoes,
                GridBagConstraints.CENTER,
                GridBagConstraints.NONE,
                15, 0, 2, 1);
    }

    /**
     * Retorna um novo usuário a partir do login e senha passados.
     * 
     * @return Usuário criado.
     */
    private Jogo carregarJogo() {
       // return new Usuario(txtLogin.getText(), txtSenha.getPassword());
       return new Jogo(txtNomeJogo.getText(), txtProdutora.getText(), txtGenero.getText(), txtModoJogo.getText() , txtAno.getText());
    }

    /**
     * Configura os eventos da tela.
     */
    private void configurarEventosTela() {
        btnEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    carregarJogo();
                    telaPrincipal.inicializar();
                    janela.dispose();
                } catch (Exception ex) {
                    Utilidades.msgErro(ex.getMessage());
                }
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janela.dispose();
            }
        });
    }

    /**
     * Constrói a janela tratando internacionalização, componentes e layout.
     */
    private void construirTela() {
        janela = new JDialog();
        janela.setTitle(I18N.obterTituloTelaAutenticacao());
        layout = new GridBagLayout();
        gbc = new GridBagConstraints();
        janela.setLayout(layout);
        adicionarComponentes();
        janela.pack();
    }

    /**
     * Exibe a tela.
     */
    private void exibirTela() {
        janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        janela.setLocationRelativeTo(telaPrincipal.obterJanela());
        janela.setModal(true);
        janela.setVisible(true);
        janela.setResizable(false);
    }
}
