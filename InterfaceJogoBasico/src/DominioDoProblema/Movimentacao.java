package DominioDoProblema;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import InterfaceGrafica.AtorJogador;
import Rede.AtorNetgames;

public class Movimentacao implements ActionListener, MouseListener {
	public JButton[][] botoesTabuleiro;
	public JButton[] botoesMenu;
	public boolean vezQuadrado,vezL,vezLinha,vezT;
	public AtorJogador atorJogador;
	public boolean pecaColocada=false;
	public AtorNetgames ngServer;
	
	
	public Movimentacao(JButton[][] botoesTabuleiro,JButton[] botoesMenu) {
		this.botoesTabuleiro = botoesTabuleiro;
		this.botoesMenu = botoesMenu;
	}
	
	
	public boolean podeColocarPeca(JButton botao, int tipo) {
		switch(tipo) {
		case 0:
			for(int i = 0; i<8; i++) {
				for(int j = 0; j<8; j++) {
					if(botoesTabuleiro[i][j] == botao) {
						if(botoesTabuleiro[i][j].getBackground()==Color.WHITE && botoesTabuleiro[i+1][j].getBackground()==Color.WHITE && botoesTabuleiro[i][j+1].getBackground()==Color.WHITE && botoesTabuleiro[i+1][j+1].getBackground()==Color.WHITE) {
							return true;
						}
						return false;
					}
				}
			}
		case 1:
			for(int i = 0; i<8; i++) {
				for(int j = 0; j<8; j++) {
					if(botoesTabuleiro[i][j] == botao) {
						if(botoesTabuleiro[i][j].getBackground()==Color.WHITE && botoesTabuleiro[i+1][j].getBackground()==Color.WHITE && botoesTabuleiro[i-1][j].getBackground()==Color.WHITE && botoesTabuleiro[i+1][j+1].getBackground()==Color.WHITE) {
							return true;
						}
						return false;
					}
				}
			}
		case 2:
			for(int i = 0; i<8; i++) {
				for(int j = 0; j<8; j++) {
					if(botoesTabuleiro[i][j] == botao) {
						if(botoesTabuleiro[i][j].getBackground()==Color.WHITE && botoesTabuleiro[i+1][j].getBackground()==Color.WHITE && botoesTabuleiro[i+2][j].getBackground()==Color.WHITE && botoesTabuleiro[i+3][j].getBackground()==Color.WHITE) {
							return true;
						}
						return false;
					}
				}
			}
		case 3:
			for(int i = 0; i<8; i++) {
				for(int j = 0; j<8; j++) {
					if(botoesTabuleiro[i][j] == botao) {
						if(botoesTabuleiro[i][j].getBackground()==Color.WHITE && botoesTabuleiro[i-1][j].getBackground()==Color.WHITE && botoesTabuleiro[i][j+1].getBackground()==Color.WHITE && botoesTabuleiro[i][j-1].getBackground()==Color.WHITE) {
							return true;
						}
						return false;
					}
				}
			}
		}
		return false;
			
	}
	
	public boolean jogoAcabou() {
		for(int k = 0; k<=3;k++) {
			for(int i=0;i<8;i++) {
				for(int j=0;j<8;j++) {
					try {
					if(podeColocarPeca(botoesTabuleiro[i][j],k)) {
						
						System.out.println("jogo nao acabou");
						return false;
					}
					}catch(Exception E) {
						
					}
				}
			}
		}
		JOptionPane.showMessageDialog(null, "Fim de Jogo!");
		return true;
	}
	
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == botoesMenu[0]) {
			vezQuadrado = true;
			vezL=false;
			vezT = false;
			vezLinha = false;
			
		}
		if(e.getSource() == botoesMenu[1]) {
			vezQuadrado = false;
			vezL = true;
			vezT = false;
			vezLinha = false;
		
		}
		if(e.getSource() == botoesMenu[2]) {
			vezQuadrado = false;
			vezL = false;
			vezT = false;
			vezLinha = true;
			
		}
		if(e.getSource() == botoesMenu[3]) {
			vezQuadrado = false;
			vezL = false;
			vezT = true;
			vezLinha = false;
			
		}
		for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
            	
                if (e.getSource() == botoesTabuleiro[i][j] && vezQuadrado && podeColocarPeca(botoesTabuleiro[i][j],0)) {
                	
	                botoesTabuleiro[i][j].setBackground(Color.RED);
	                botoesTabuleiro[i+1][j].setBackground(Color.RED);
	                botoesTabuleiro[i][j+1].setBackground(Color.RED);
	                botoesTabuleiro[i+1][j+1].setBackground(Color.RED);
	                Lance lance = new Lance();
	                lance.matrizPecas[i][j] = 1;
	                lance.matrizPecas[i+1][j] = 1;
	                lance.matrizPecas[i][j+1] = 1;
	                lance.matrizPecas[i+1][j+1] = 1;
	                lance.cor = "vermelho";
	               	ngServer.enviarJogada(lance);
	                
	                vezQuadrado=false;
	                jogoAcabou();
                	
                }
                else if (e.getSource() == botoesTabuleiro[i][j] && vezL && podeColocarPeca(botoesTabuleiro[i][j],1)) { 
                	
                	botoesTabuleiro[i][j].setBackground(Color.BLUE);
                	botoesTabuleiro[i+1][j].setBackground(Color.BLUE);
                	botoesTabuleiro[i-1][j].setBackground(Color.BLUE);
                	botoesTabuleiro[i+1][j+1].setBackground(Color.BLUE);
                	vezL=false;
                	jogoAcabou();
                }
                else if (e.getSource() == botoesTabuleiro[i][j] && vezLinha && podeColocarPeca(botoesTabuleiro[i][j],2)) { 
                	
                	botoesTabuleiro[i][j].setBackground(Color.ORANGE);
                	botoesTabuleiro[i+1][j].setBackground(Color.ORANGE);
                	botoesTabuleiro[i+2][j].setBackground(Color.ORANGE);
                	botoesTabuleiro[i+3][j].setBackground(Color.ORANGE);
                	vezLinha=false;
                	 jogoAcabou();
                }
                else if (e.getSource() == botoesTabuleiro[i][j] && vezT && podeColocarPeca(botoesTabuleiro[i][j],3)) { 
                	
                	botoesTabuleiro[i][j].setBackground(Color.MAGENTA);
                	botoesTabuleiro[i-1][j].setBackground(Color.MAGENTA);
                	botoesTabuleiro[i][j+1].setBackground(Color.MAGENTA);
                	botoesTabuleiro[i][j-1].setBackground(Color.MAGENTA);
                	vezT=false;
                	 jogoAcabou();
                }
                
            }
            pecaColocada=true;
		}
		
			
	}
	
	
	
	public void mouseEntered(MouseEvent e) {
		/*for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
            	
                if (e.getSource() == botoesTabuleiro[i][j] && vezQuadrado) {
                	System.out.println("oi");
	                botoesTabuleiro[i][j].setBackground(new Color(255,167,167));
	                botoesTabuleiro[i+1][j].setBackground(new Color(255,167,167));
	                botoesTabuleiro[i][j+1].setBackground(new Color(255,167,167));
	                botoesTabuleiro[i+1][j+1].setBackground(new Color(255,167,167));
                	
                }
                else if (e.getSource() == botoesTabuleiro[i][j]) { 
                	L
                	botoesTabuleiro[i][j].setBackground(Color.BLUE);
                	botoesTabuleiro[i+1][j].setBackground(Color.BLUE);
                	botoesTabuleiro[i-1][j].setBackground(Color.BLUE);
                	botoesTabuleiro[i+1][j+1].setBackground(Color.BLUE);
                }
                
            }
		}*/
	}
	

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void receberJogada(Lance lance) {
		// TODO Auto-generated method stub
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if(lance.matrizPecas[i][j]==1) {
					if(lance.cor=="vermelho") {
						this.botoesTabuleiro[i][j].setBackground(Color.RED);
					}
				}
			}
		}
		
	}
}