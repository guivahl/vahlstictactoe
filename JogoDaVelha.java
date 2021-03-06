public class JogoDaVelha {
    private int m[][] = new int[5][5];
    private int estado;
    private int livres ;
    private int JogadorDaVez ;
    
    
    public JogoDaVelha(){
        int k,x;
        for(k=1;k<=3;k++){
            for(x=1;x<=3;x++){
                m[k][x] = 0;
            }
        }
    }
    
    public void inicializa(){
        int i,j;
        for (i=1;i<=3;i++){
            for(j=1;j<=3;j++){
                m[i][j] = 0;
            }
        }    
        estado = 3;
        livres = 9;
        JogadorDaVez = 1;
    }
    
    public boolean executaJogada(int l, int c){
        if(((l<=3&&l>=1)&&(c<=3&&c>=1))&&m[c][l]==0){
            if(JogadorDaVez == 1){
                m[c][l] = 1;
            }
            else if(JogadorDaVez == 2){
                m[c][l] = 2;
            }
            livres--;
            return true;
        }
        else
            return false;
    }
    
    public void atualizaEstado(){
        int x,y;
        if(estado == 3 && livres >= 0){
            for(x=1;x<=3;x++){
                if((m[x][1] == 1) && (m[x][2] == 1) && (m[x][3] == 1)){
                    estado = 1;
                } 
                else if((m[x][1]== 2) && (m[x][2]==2) && (m[x][3]==2)){
                    estado = 2;
                }
            }
        
            for(y=1;y<=3;y++){
                if((m[1][y]== 1) && (m[2][y]== 1) && (m[3][y]== 1)){
                    estado = 1;
                }
                else if((m[1][y]== 2) && (m[2][y]== 2) && (m[3][y]== 2)){
                    estado = 2;
                }
            }
            
            // Diagonal 1
            if((m[1][3]== 1)&&(m[2][2]== 1)&&(m[3][1]==1)){
                estado = 1;
            }
            else  if((m[1][3]== 2)&&(m[2][2]== 2)&&(m[3][1]==2)){
                estado = 2;
            }
            
            // Diagonal 2
            if((m[1][1]== 1)&&(m[2][2]== 1)&&(m[3][3]==1)){
                estado = 1;
            }
            else  if((m[1][1]== 2)&&(m[2][2]== 2)&&(m[3][3]==2)){
                estado = 2;
            }
            if((estado!=2&&estado!=1)&&livres==0){
                estado = 0;
            }
        } 
       
    }
    
    public void inverteJogador(){
        if(JogadorDaVez == 1)
            JogadorDaVez = 2;
        else 
            if(JogadorDaVez == 2)
                JogadorDaVez = 1;
    }
    
    public int getJogadorDaVez(){
        return JogadorDaVez;
    }
    
    public int getEstado(){
        return estado;
    }
    
    
}
