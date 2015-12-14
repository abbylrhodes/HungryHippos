package application;

import java.util.Random;

public class EasyLevelBoard extends Board{
    public static void beginEasyLevel()
    {
    	
        if(Player.getPlayer1Key() != null && Player.getPlayer2Key() != null)
        {
            Player.player1Default();
           
            drawLevelBoard(Board.drawBoard());
        
            Player.player2Default();
        
            ScoreKeeper.main(0,0);
        }
    }
    
    
    public static String[][] drawLevelBoard(String [][] board)
    {
        Random randInt = new Random();

        for (int i =0; i<15; i++)
        {
            board[randInt.nextInt(10)+1][randInt.nextInt(38)+1] = "0";
        }

        
        for ( int l = 0; l< board.length; l++)
        {
            for ( int m = 0; m < board[l].length; m++)
            {
                System.out.print(board[l][m]);
                
            }
            System.out.println();
        }
        
        return board;
    }
}

