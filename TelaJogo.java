
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TelaJogo extends JFrame implements ActionListener {
    JogoDaVelha jogo = new JogoDaVelha();
    Celula celulas[][] = new Celula[5][5];
    JLabel lbMensagem = new JLabel();
    JButton btNovo = new JButton();
    private int linha,coluna;
    
    public TelaJogo(JogoDaVelha jog){
        this.jogo =  jog;
        int i,j;
      
       setSize(520, 520); // Seta o tamanho da Janela
       setName("Jogo Da Velha"); // Seta o nome da Janela
       setLayout(null); // Anula o gerenciador de layout
       setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); // Seta o botão
       setResizable(false); // Impede o redimensionamento da janela
       
      
       
       //setando o label
       lbMensagem.setSize(300, 40);
       lbMensagem.setLocation(100, 20);
       lbMensagem.setHorizontalAlignment(JTextField.CENTER);
       lbMensagem.setText("Joga Jogador 1!!!");
       lbMensagem.setVisible(true);
       add(lbMensagem);
       
       //setando o botão
       btNovo.setSize(100, 45);
       btNovo.setLocation(200, 415);
       btNovo.setText("Novo Jogo");
       btNovo.addActionListener(this);
       add(btNovo);
       
       for(j=1;j<=3;j++){
           for(i=1;i<=3;i++){
               celulas[j][i] = new Celula(j,i);
               celulas[j][i].setLocation(100 + (j-1)*100, 90 + (i-1)*100);
               add(celulas[j][i]);
           }
       }
        for(j=1;j<=3;j++){
           for(i=1;i<=3;i++){
               celulas[j][i].setText(" ");
               celulas[i][j].addActionListener(this);
           }
       }
       jogo.inicializa();
       this.setVisible(true);
               
    }
  
    @Override
    public void actionPerformed(ActionEvent evento){
    if (evento.getSource() == btNovo){
        lbMensagem.setText("Joga Jogador 1!");
       
        for(int j=1;j<=3;j++){
           for(int i=1;i<=3;i++){
               celulas[j][i].setText(" ");
           }
       }             
        jogo.inicializa(); 
        
    }
    int col,lin;
    for(col=1;col<=3;col++){
        for(lin=1;lin<=3;lin++){
            if ((evento.getSource() == celulas[col][lin]) && (jogo.getEstado()) == 3){
                 if(jogo.executaJogada(col, lin)){
                     if(jogo.getJogadorDaVez() == 1){
                        celulas[col][lin].setText("X");
                        lbMensagem.setText("Joga Jogador 2!!");
                    }
                     else if (jogo.getJogadorDaVez() == 2){
                        celulas[col][lin].setText("O");
                        lbMensagem.setText("Joga Jogador 1!!");   
                    }
                     
                    jogo.atualizaEstado();
                    
                    switch(jogo.getEstado()){
                        case 0:
                            lbMensagem.setText("Empate");
                        break;
                        case 1:
                            lbMensagem.setText("Jogador 1 venceu!");
                             break;
                        case 2:
                            lbMensagem.setText("Jogador 2 venceu!");
                            break;
                        case 3:
                            jogo.inverteJogador();
                            if(jogo.getJogadorDaVez() == 1)
                                    lbMensagem.setText("Vez do Jogador 1");
                            else 
                                 if(jogo.getJogadorDaVez() == 2)
                                     lbMensagem.setText("Vez do Jogador 2");
                                     break;
                 }
                    
                 }
                 
                 
            }
        }
    }    
            
                 
    }  
                
   
}

