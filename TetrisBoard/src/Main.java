import javax.swing.*;

public class Main {
    public static void main(String args[]){
        Game k = new Game();

        k.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        k.setSize(500, 500);
        k.setResizable(false);
        k.setVisible(true);
    }
}
