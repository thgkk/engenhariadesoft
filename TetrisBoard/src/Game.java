import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Random;
public class Game extends JFrame{
	public JButton[][] botoes;
	public JPanel p1;
	public Game() {

		super("TetrisBoard");
		p1 = new JPanel();
	    p1.setLayout(new GridLayout(8, 8));
	    botoes = new JButton[8][8];
	    movimentacao h = new movimentacao();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
            	
                botoes[i][j] = new JButton();
                botoes[i][j].setBackground(Color.WHITE);
                p1.add(botoes[i][j]);
                botoes[i][j].addActionListener(h);
            }
        }
        
        /*for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    botoes[i][j].setBackground(Color.BLACK);
                } else if (i % 2 != 0 && j % 2 != 0) {
                    botoes[i][j].setBackground(Color.BLACK);
                } else {
                    botoes[i][j].setBackground(new Color(190, 6, 0));
                }
            }
        }*/
       
        add(p1);
	}
	
    private class movimentacao implements ActionListener {
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
}
