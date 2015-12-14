package application;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;


public class Player
{
    // Instance Variables for Player 1's key and Player 2's key.
    static String p1Key;
    static String p2Key;

    public Player()
    {
        
    }

    /*
     * Assigns the Key that Player 1 will have to press, from options 'a' or 'l'
     * 
     * @return p1Key, the key assigned to Player 1
     * @throws IllegalArgument Exception if user does not type 'a' or 'l'
     */
    public static String assignPlayer1Key() //**********
    {
        Scanner keyIn = new Scanner(System.in);
        System.out.println("Player 1 choose 'a' or 'l'");
        String key = keyIn.next();
        
        // Precondition #2
        while (!key.equals("a") && !key.equals("l"))
        {
            try
            {
                if (!key.contains("al"))
                {
                    System.out.println("Please type 'a' or 'l' and make sure it is NOT capatalized");
                    throw new IllegalArgumentException();
                }
            }
            catch (IllegalArgumentException e)
            {
                System.err.println("Illegal letter '" + key + "' was typed.");
                key = keyIn.next();
            }
        }
        p1Key = key;
        return p1Key;
    
    }

    /* 
     * Assigns the Key that Player 2 will have to press, from options 'a' or 'l', 
     *         depending on what Player 1 chose.
     * 
     * @param p1Key, the key assigned to Player 1, to determine which key
     *              Player 2 will have to choose.
     * @return p2Key, the key assigned to Player 2
     * @throws IllegalArgument Exception if user does not type 'a' or 'l'
     */
    public static String assignPlayer2Key(String p1Key)  //*********
    {
        Scanner keyIn = new Scanner(System.in);
        
        if (p1Key.equals("a"))
        {
            System.out.println("Player 2 choose 'l'");
        }
        else if (p1Key.equals("l"))
        {
            System.out.println("Player 2 choose 'a'");
        }
        
        String key = keyIn.next();
        
        // Precondition #3
        while (!key.equals("a") || !key.equals("l"))
        {
            try
            {
                if (p1Key.equals("a"))
                {
                    if (!key.equals("l"))
                    {
                        System.out.println("Please type 'l' and make sure it is NOT capatalized");
                        throw new IllegalArgumentException();
                    }
                    else
                    {
                        p2Key = key;
                        break;
                    }
                }
            
                
                else if (p1Key.equals("l"))
                {
                    if (!key.equals("a"))
                    {
                        System.out.println("Please type 'a' and make sure it is NOT capatalized");
                        throw new IllegalArgumentException();
                    }
                    else
                    {
                        p2Key = key;
                        break;
                    }
                }
            }
            catch(IllegalArgumentException e)
            {
                System.err.println("Illegal letter '" + key + "' was typed.");
                key = keyIn.next();
            }
        }
        
        return p2Key;    
    }
    
    /* 
     * Gets the key Player 1 was assigned
     * 
     * @returns p1Key, the key assigned to Player 1
     */
    public static String getPlayer1Key( )
    {
        return p1Key;
    }
    
    /* Gets the key Player 1 was assigned
     * 
     * @returns p1Key, the key assigned to Player 1
     */
    public static String getPlayer2Key( )
    {
        return p2Key;
    }
    
    /* 
     * Prints the default Hippo picture, for Player 1, off of the board
     */
    public static void player1Default()
    {
        System.out.println("          |                   |          ");
        System.out.println("          |                   |          ");
        System.out.println("          |      (o)  (o)     |          ");
        System.out.println("          \\ __________________/          ");
        System.out.println("             |             |             ");
        System.out.println("             |     .  .    |             ");
        System.out.println("             \\ ____________/          ");
    }
    
    /* 
     * Prints the default Hippo picture, for Player 2, off of the board
     */
    public static void player2Default()
    {
        System.out.println("              ____________              ");
        System.out.println("             /     .  .    \\             ");
        System.out.println("             |             |             ");
        System.out.println("            _|_____________|_            ");
        System.out.println("          /                  \\           ");
        System.out.println("          |      (o)  (o)     |          ");
        System.out.println("          |                   |          ");
        System.out.println("          |                   |          ");

    }
    
    /* 
     * Shows what the board looks like when Player 1 presses their key.
     *  -Constructs the game board, with Food on board.
     *  -Prints the Hippo picture, for Player 1, onto the board.
     *  -Prints the game board
     *  -Prints the default hippo for Player 2
     * 
     * @return board, returns everything on the board so points for scorekeeper
     *         can be calculated for Player 1, and so food can be counted.
     */
    public static String[][] player1Press()
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

        board[1][13] = "|";
        board[1][27] = "|";

        board[2][13] = "|";
        board[2][27] = "|";
        board[2][19] = ".";
        board[2][22] = ".";

        board[3][13] = "\\";
        board[3][27] = "/";
        
        for (int i = 14; i<27; i++)
        {
            board[3][i] ="_";
        }
        
        for (int k = 1; k<board[board.length-1].length-1;k++)
        {
             board[board.length-1][k] = "_";
        }
        
        for (int i =0; i<Food.normCount; i++)
        {
            board[randInt.nextInt(10)+1][randInt.nextInt(38)+1] = "0";
        }
        
        if (Board.getLevel().equals("HARD"))
        {
            for (int i =0; i<Food.extraCount; i++)
            {
                board[randInt.nextInt(10)+1][randInt.nextInt(38)+1] = "+";
            }
        
            for (int i =0; i<Food.negCount; i++)
            {
                board[randInt.nextInt(10)+1][randInt.nextInt(38)+1] = "-";
            }
        }
        
        System.out.println("          |                   |          ");
        System.out.println("          |                   |          ");
        System.out.println("          |      (o)  (o)     |          ");
        
        for ( int l = 0; l< board.length; l++)
        {
            for ( int m = 0; m < board[l].length; m++)
            {
                System.out.print(board[l][m]);
                
            }
            System.out.println();
        }
        
        player2Default();

        Food.getCountNormal1(board);
        Food.getCountExtra1(board);
        Food.getCountNegative1(board);
        
        return board;
        
    }
    
    /*
     * Shows what the board looks like when Player 2 presses their key.
     *  -Constructs the game board, with food on the board.
     *  -Prints the default hippo for Player 1
     *  -Prints the game board.
     *  -Prints the Hippo picture, for Player 2, onto the board.
     * 
     * @return board, returns everything on the board so points for scorekeeper
     *         can be calculated for Player 2, and so food can be counted.
     */
    public static String[][] player2Press()
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
        
        board[11][13] = "|";
        board[11][27] = "|";

        board[10][13] = "|";
        board[10][27] = "|";
        board[10][19] = ".";
        board[10][22] = ".";

        board[9][13] = "/";
        board[9][27] = "\\";
        
        for (int i = 14; i<27; i++)
        {
            board[8][i] ="_";
        }

        for (int i =0; i<Food.normCount; i++)
        {
            board[randInt.nextInt(10)+1][randInt.nextInt(38)+1] = "0";
        }
        
        if (Board.getLevel().equals("HARD"))
        {
            for (int i =0; i<Food.extraCount; i++)
            {
                board[randInt.nextInt(10)+1][randInt.nextInt(38)+1] = "+";
            }
            
            for (int i =0; i<Food.negCount; i++)
            {
                board[randInt.nextInt(10)+1][randInt.nextInt(38)+1] = "-";
            }
        }
        player1Default();
        
        for ( int l = 0; l< board.length; l++)
        {
            for ( int m = 0; m < board[l].length; m++)
            {
                System.out.print(board[l][m]);
                
            }
            System.out.println();
        }

        
        System.out.println("          /                  \\           ");
        System.out.println("          |      (o)  (o)     |          ");
        System.out.println("          |                   |          ");
        System.out.println("          |                   |          ");
        
        Food.getCountNormal2(board);
        Food.getCountExtra2(board);
        Food.getCountNegative2(board);
        return board;
        
    }
}

