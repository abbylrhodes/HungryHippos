package application;


import java.util.Random;
import java.util.Scanner;

public class Board {
    static String level;
    
    public static void beginBoard() 
    {
        StartMenu.start();
        if(Player.getPlayer1Key() != null && Player.getPlayer2Key() != null)
        {
            Player.player1Default();
           
            //drawBoard();
            printBoard(drawBoard());
        
            Player.player2Default();
        
            ScoreKeeper.main(0,0);
            
            System.out.println("\nBefore you start, a difficulty level needs to be chosen!\n");

            chooseLevel();
        }
    }
    
    public static String chooseLevel()
    {
        Scanner levelIn = new Scanner(System.in);
        System.out.print("Choose 'EASY' or 'HARD' for level: ");
        level = levelIn.next();
        
        if (level.equals("EASY"))
        {
        	EasyLevelBoard.beginEasyLevel();
        }
        
        else if (level.equals("HARD"))
        {
        	HardLevelBoard.beginHardLevel();
        }
        return level;
    }
    
    public static String getLevel()
    {
        return level;
    }
    
    public static String [][] drawBoard()
    {

        String [][] board = new String [12][40];
        Random randInt = new Random();
        
        for ( int n = 0; n< board.length; n++)
        {
             for ( int p = 0; p < board[n].length; p++)
             {
                     board[n][p] = " ";
             }   
        }
        
        for (int i = 0; i<board[0].length; i++)
        {
            board[0][i] = "_";
        }
        
        for (int j = 1; j<board.length; j++)
        {
            board[j][0] = "|";
            board[j][board[j].length-1] = "|";
        }
        
        for (int k = 1; k<board[board.length-1].length-1;k++)
        {
             board[board.length-1][k] = "_";
        }

        return board;
    }
    
    public static void printBoard(String [][] board)
    {
    	for ( int l = 0; l< board.length; l++)
          {
              for ( int m = 0; m < board[l].length; m++)
              {
                  System.out.print(board[l][m]);
                  
              }
              System.out.println();
          }
    }
}
