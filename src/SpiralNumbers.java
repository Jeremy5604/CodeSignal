
public class SpiralNumbers {
    public static void main(String[] args){
        
        mostrarMatriz(solution(3));
        mostrarMatriz(solution(5));
        mostrarMatriz(solution(10));
        mostrarMatriz(solution(20));
        
    }



    public static void mostrarMatriz(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }


    static int[][] solution(int n) {
        int consecutiveValue = 1;
        int[][] matrix = new int[n][n];
        int row = 0, column = 0;
        int spaceOccupied = 0, spaceToOccuopied = n;
        
        //Banderas de direccionamiento
        boolean rigth = true, down = false, left = false, up = false;
        
        do{
            
            
            matrix[row][column] = consecutiveValue;
            // System.out.print(matrix[row][column]);
            // System.out.println(java.util.Arrays.deepToString(matrix));
            
            if (rigth){
                spaceOccupied++;
                column++;
                if(spaceOccupied+1>spaceToOccuopied){
                    // System.out.println("Se ejecuto cambio de dirección a down");
                    column--;
                    rigth = false;
                    down = true;
                    row++;
                    spaceOccupied = 0;
                    spaceToOccuopied--;
                    // System.out.println("spaceOccupied = " + spaceOccupied);
                    // System.out.println("spacetoOccupied = " + spaceToOccuopied);
                }
            
            }else
            if(down){
                spaceOccupied++;
                row++;
                if (spaceOccupied+1> spaceToOccuopied){
                    // System.out.println("Se ejecuto cambio de dirección a left");
                    row--;
                    down = false;
                    left= true;
                    column--;
                    spaceOccupied = 0;
                    // System.out.println("spaceOccupied = " + spaceOccupied);
                    // System.out.println("spacetoOccupied = " + spaceToOccuopied);
                }
            }else
            if(left){
                spaceOccupied++;
                column--;
                if(spaceOccupied+1>spaceToOccuopied){
                    // System.out.println("Se ejecuto cambio de dirección a up"); 
                    column++;
                    left = false;
                    up = true;
                    row--;
                    spaceOccupied = 0;
                    spaceToOccuopied--;
                    // System.out.println("spaceOccupied = " + spaceOccupied);
                    // System.out.println("spacetoOccupied = " + spaceToOccuopied);
                }
                
            }else
            if(up){
                spaceOccupied++;
                row--;
                if(spaceOccupied+1> spaceToOccuopied){
                    // System.out.println("Se ejecuto cambio de dirección a rigth (Vuelta)"); 
                    row++;
                    up = false;
                    rigth = true;
                    column++;
                    spaceOccupied = 0;
                    // System.out.println("spaceOccupied = " + spaceOccupied);
                    // System.out.println("spacetoOccupied = " + spaceToOccuopied);
                }
            }
        
            consecutiveValue++;
        }while (consecutiveValue <= n*n) ;      
        return matrix;
    }
    
}