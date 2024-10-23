

class Puzzle{
    public int[][] board;
    public int size;
    public int Col;
    public int Row;
    public int MvC;
    public Puzzle(int size)
    {
        this.size = size;
        board=new int[size][size];
        int num = 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                    board[i][j] = num++;
            }
        }
        
        for(int i = 0, j = size-1; i < j; i++, j--){  // reverse Last row for Shuffle
            int temp = board[size-1][j];
            board[size-1][j] = board[size-1][i];
            board[size-1][i] = temp; 
        }
        
        board[size-1][0]=0;  // Assign zero at Last
        Col = 0;           // Get ZeroPosition Column
        Row = size-1;      // Get ZeroPosition Row
        MvC = 0;           // Initialize Move count = 0
    }
    
    public boolean up(){
        int temp = board[Row+1][Col]; 
        board[Row+1][Col] = board[Row][Col];
        board[Row][Col] = temp;
        Row = Row + 1;               // Zero Replaced Index (Row+1,Col)
        MvC++;
        return checkpuzzle();

    }
    public boolean down(){
        int temp = board[Row-1][Col]; 
        board[Row-1][Col] = board[Row][Col]; 
        board[Row][Col] = temp;
        Row = Row - 1;             // Zero Replaced Index (Row-1,Col)
        MvC++;
        return checkpuzzle();
    }
    public boolean right(){
        int temp = board[Row][Col-1];
        board[Row][Col-1] = board[Row][Col]; 
        board[Row][Col] = temp;
        Col = Col - 1;            // Zero Replaces Index (Row,Col-1)
        MvC++;
        return checkpuzzle();
    }
    public boolean left(){
        int temp = board[Row][Col+1];
        board[Row][Col+1] = board[Row][Col]; 
        board[Row][Col] = temp;
        Col = Col + 1;            // Zero Replaces Index (Row,Col+1)
        MvC++;
        return checkpuzzle();
    } 
    public boolean checkpuzzle(){
        int num =1;
        for(int i=0;i<size;i++){
            for(int j=0;j<size && (i != size-1 || j != size-1);j++){
                if(board[i][j] != num++)
                    return  true;
            }
        }
        System.out.println("------------------------------You are Win!!");
        System.out.println(MvC+" Moves used");
        return false;
    }
    public void display(){
        System.out.println("------------>");
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("------------>");
    }
    // public void reverseCol(int c){
    //     for(int i = 0 ;i < size/2; i++){
    //         int temp = board[i][c];
    //         board[i][c] = board[size-1-i][c];
    //         board[size-1-i][c] = temp;
    //     }
    // }
}