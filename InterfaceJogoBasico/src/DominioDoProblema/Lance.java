package DominioDoProblema;

import java.awt.Point;

import br.ufsc.inf.leobr.cliente.Jogada;

public class Lance implements Jogada {
	
	private static final long serialVersionUID = 1L;
	public int[][] matrizPecas= new int[8][8];
	public String cor;
	
	public Lance() {
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				matrizPecas[i][j]=0;
			}
		}
	}
	public int[][] getMatrizPecas(){
		return matrizPecas;
	}
	public void setMatrizPecas(int x,int y,int z){
		matrizPecas[x][y]=z;
	}
	

}
