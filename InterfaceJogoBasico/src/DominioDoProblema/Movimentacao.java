package DominioDoProblema;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;

public class Movimentacao implements ActionListener {
	public JButton[][] botoes;
	public Movimentacao(JButton[][] botoes) {
		this.botoes = botoes;
	}
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
            	Random rand = new Random();
            	int n = rand.nextInt(2);
            	System.out.println(n);
                if (e.getSource() == botoes[i][j] && n==0) { 
                	
                	botoes[i][j].setBackground(Color.RED);
                	botoes[i+1][j].setBackground(Color.RED);
                	botoes[i][j+1].setBackground(Color.RED);
                	botoes[i+1][j+1].setBackground(Color.RED);
                }
                else if (e.getSource() == botoes[i][j] && n==1) { 
                	
                	botoes[i][j].setBackground(Color.BLUE);
                	botoes[i+1][j].setBackground(Color.BLUE);
                	botoes[i-1][j].setBackground(Color.BLUE);
                	botoes[i+1][j+1].setBackground(Color.BLUE);
                }
                
            }
		}
	}
}