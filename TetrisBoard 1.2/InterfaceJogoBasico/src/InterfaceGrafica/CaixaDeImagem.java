package InterfaceGrafica;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class CaixaDeImagem extends JPanel{

	 private BufferedImage image;

	    public CaixaDeImagem(String nome) {
	    	setVisible(true);
	    	if(nome == "l") {
	    		loadImage("/imgs/l.jpg");
	    	}else if(nome == "linha"){
	    		loadImage("/imgs/linha.jpg");
	    	}else if(nome == "t"){
	    		loadImage("/imgs/t.jpg");
	    	}else if(nome == "quadrado") {
	    		loadImage("/imgs/quadrado.jpg");
	    	}
	    }
	    
	    private void loadImage(String caminho) {
	    	try {
		          image = ImageIO.read(CaixaDeImagem.class.getResource(caminho));
	    	} catch (IOException ex) {
		            // handle exception...
		    }
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        g.drawImage(image, 0, 0, getWidth(), getHeight(), this); // see javadoc for more info on the parameters            
	    }
}
