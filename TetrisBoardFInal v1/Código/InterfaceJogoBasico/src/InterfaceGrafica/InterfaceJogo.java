package InterfaceGrafica;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import DominioDoProblema.Lance;
import DominioDoProblema.Movimentacao;

import javax.swing.JMenu;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class InterfaceJogo {

	private JFrame frame;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	private AtorJogador atorJogador;
	public JButton[][] botoesTabuleiro;
	public JButton[] botoesMenu;
	public JLabel lblNomejogador;
	public Movimentacao h;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceJogo window = new InterfaceJogo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfaceJogo() {
		initialize();
	}
	public void minimizaCampo() {
    	frame.setVisible(false);

    }
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		atorJogador = AtorJogador.getInstance(this);
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 591, 529);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 635, 31);
		frame.getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Jogo");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmConectar = new JMenuItem("conectar");
		mntmConectar.setAction(action);
		mnNewMenu.add(mntmConectar);
		
		JMenuItem mntmDesconectar = new JMenuItem("desconectar");
		mntmDesconectar.setAction(action_1);
		mnNewMenu.add(mntmDesconectar);
		
		JMenuItem mntmIniciarPartida = new JMenuItem("iniciar partida");
		mntmIniciarPartida.setAction(action_2);
		mnNewMenu.add(mntmIniciarPartida);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 67, 474, 418);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(8,8));
		
		JButton btnQuadrado = new JButton();
		btnQuadrado.setBounds(484, 67, 84, 84);
		frame.getContentPane().add(btnQuadrado);
		//btnQuadrado.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("/res/imgs/quadrado.jpg")));
		ImageIcon print1 = new ImageIcon(getClass().getClassLoader().getResource("res/imgs/quadrado.jpg"));
		Image image1 = print1.getImage();
		Image img1 = image1.getScaledInstance(90, 90, java.awt.Image.SCALE_SMOOTH);
        ImageIcon quadrado = new ImageIcon(img1);
        //Image img1 = print1.getScaledInstance(90, 90, java.awt.Image.SCALE_SMOOTH);
        //ImageIcon quadrado = new ImageIcon(img1);
		btnQuadrado.setIcon(quadrado);
		

		JButton btnL = new JButton();
		btnL.setBounds(484, 180, 84, 84);
		frame.getContentPane().add(btnL);
		ImageIcon print2 = new ImageIcon(getClass().getClassLoader().getResource("res/imgs/l.jpg"));
		Image image2 = print2.getImage();
		Image img2 = image2.getScaledInstance(90, 90, java.awt.Image.SCALE_SMOOTH);
        ImageIcon l = new ImageIcon(img2);
       // Image img2 = print2.getScaledInstance(90, 90, java.awt.Image.SCALE_SMOOTH);
        //ImageIcon l = new ImageIcon(img2);
		btnL.setIcon(l);
		
		
		JButton btnLinha = new JButton();
		btnLinha.setBounds(484, 293, 84, 84);
		frame.getContentPane().add(btnLinha);
		ImageIcon print3 = new ImageIcon(getClass().getClassLoader().getResource("res/imgs/linha.jpg"));
		Image image3 = print3.getImage();
		Image img3 = image3.getScaledInstance(90, 90, java.awt.Image.SCALE_SMOOTH);
        ImageIcon linha = new ImageIcon(img3);
		btnLinha.setIcon(linha);
		
		JButton btnT = new JButton();
		btnT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnT.setBounds(484, 405, 84, 84);
		frame.getContentPane().add(btnT);
		ImageIcon print4 = new ImageIcon(getClass().getClassLoader().getResource("res/imgs/t.jpg"));
		Image image4 = print4.getImage();
		Image img4 = image4.getScaledInstance(90, 90, java.awt.Image.SCALE_SMOOTH);
        ImageIcon t = new ImageIcon(img4);
		btnT.setIcon(t);
		
		botoesMenu = new JButton[4];
		botoesMenu[0] = btnQuadrado;
		botoesMenu[1] = btnL;
		botoesMenu[2] = btnLinha;
		botoesMenu[3] = btnT;
		
		JLabel lblYut = new JLabel("VEZ DE:");
		lblYut.setBounds(10, 30, 46, 39);
		frame.getContentPane().add(lblYut);
		
		lblNomejogador = new JLabel("");
		lblNomejogador.setBounds(57, 42, 90, 14);
		frame.getContentPane().add(lblNomejogador);
		
		
 
		botoesTabuleiro = new JButton[8][8];
		h = new Movimentacao(botoesTabuleiro,botoesMenu);
	    for (int i = 0; i < 8; i++) {
	    	for (int j = 0; j < 8; j++) {
	            	
	    		botoesTabuleiro[i][j] = new JButton();
	    		botoesTabuleiro[i][j].setBackground(Color.WHITE);
	    		panel.add(botoesTabuleiro[i][j]);
	    		botoesTabuleiro[i][j].addMouseListener(h);
	    	}
	    }
	    
		for(int i = 0;i<=3;i++) {
			botoesMenu[i].addMouseListener(h);
		}
		
	   
	}
	
	private class SwingAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public SwingAction() {
			putValue(NAME, "conectar");
			putValue(SHORT_DESCRIPTION, "conectar a Netgames Server");
		}
		public void actionPerformed(ActionEvent e) {
			// Necessário definir endereço do servidor e nome do jogador
			atorJogador.conectar();
		}
	}
	private class SwingAction_1 extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public SwingAction_1() {
			putValue(NAME, "desconectar");
			putValue(SHORT_DESCRIPTION, "desconectar de Netgames Server");
		}
		public void actionPerformed(ActionEvent e) {
			atorJogador.desconectar();
		}
	}
	private class SwingAction_2 extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public SwingAction_2() {
			putValue(NAME, "iniciar partida");
			putValue(SHORT_DESCRIPTION, "iniciar partida do seu jogo");
		}
		public void actionPerformed(ActionEvent e) {
			h.definirPartidaEmAndamento(true);
			atorJogador.iniciarPartida();
			
		}
	}
	public void receberJogada(Lance lance) {
		// TODO Auto-generated method stub
		h.definirPartidaEmAndamento(true);
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if(lance.matrizPecas[i][j]==1) {
					if(lance.cor==1) {
						botoesTabuleiro[i][j].setBackground(Color.RED);
					}else if(lance.cor==2) {
						botoesTabuleiro[i][j].setBackground(Color.BLUE);
					}else if(lance.cor==3) {
						botoesTabuleiro[i][j].setBackground(Color.ORANGE);
					}else if(lance.cor==4) {
						botoesTabuleiro[i][j].setBackground(Color.MAGENTA);
					}
				}
			}
		}
		
	}
	public void notificar(String notificacao) {
		JOptionPane.showMessageDialog(null, notificacao);
	}
	
	public String obterNomeJogador() {
		String nome = JOptionPane.showInputDialog("Qual o seu nome?");
		return nome;
	}
	
	public String obterEnderecoServidor() {
		String idServidor = ("localhost");
		idServidor = JOptionPane.showInputDialog(null, "Insira o endereço do servidor", idServidor);
		return idServidor;
	}
}
