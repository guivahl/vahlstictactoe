import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Celula extends JButton {
    private int linha;
    private int coluna;
    
    public Celula(int l, int c){
        linha = l;
        coluna = c;
        this.setSize(98,98); // Seta o tamanho
        this.setBackground(Color.white); // Seta a cor de fundo para branco       
        this.setFont(new Font("Courier new", Font.BOLD, 70)); // Seta a fonte
    }

    public int getLinha(){
        return linha;
    }
    
    public int getColuna(){
        return coluna;
    }
}
