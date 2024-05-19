
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





// 1 2 3 
// 8 9 4
// 7 6 5

// 3|2|2|1|1



// 1  2   3   4
// 12 13  14  5
// 11 16  15  6
// 10  9   8  7

// 4|3|3|2|2|1|1


// 1  2   3   4  5
// 16 17  18  19 6
// 15 24  25  20 7
// 14 23  22  21 8
// 13 12  11  10 9


// 5|4|4|3|3|2|2|1|1
