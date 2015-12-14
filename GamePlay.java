package application;

import java.util.Scanner;

public class GamePlay
{
    /*
     * Main driving function for game. Continues until the "Normal Food" is all gone.
     * 
     * @throws IllegalArgumentException if the totals are not equal to zero. (PostCondition)
     *          (Totals need to be zero, if for some reason they are not reset after last
     *           run of program, then the current run should terminate)
     * @throws IllegalArgumentException if either user does not pressed their assigned key
     * 
     */
    public static void main()
    { 
        Board.beginBoard();
        System.out.println();
        
        int total1 = 0;
        int total2 = 0;
        
        // PostCondition and Assertion
        if (total1 != 0 || total2 != 0)
        {
            throw new IllegalArgumentException("Totals need to start out at 0!");
        }
        assert total1 == 0;
        assert total2 == 0;
        
        // PreCondition #1
        if (Player.getPlayer1Key() != null && Player.getPlayer2Key() != null)
        {
            while(Food.normCount >0)  //*********
            {
                try
                {
                    Scanner in = new Scanner(System.in);
                    System.out.print("(press next key)");
                    String nextKey = in.next();
                    System.out.println();
            
                    if (nextKey.equals(Player.getPlayer1Key()))
                    {
                        int scoreP1 = ScoreKeeper.countPlayer1Score(Player.player1Press());
                        total1 = total1 + scoreP1;
                        System.out.println();
                        ScoreKeeper.scoreBoard(total1, total2);
                    }
                    else if (nextKey.equals(Player.getPlayer2Key()))
                    {
                         int scoreP2 = ScoreKeeper.countPlayer2Score(Player.player2Press());
                         total2 = total2 + scoreP2;
                         System.out.println();
                         ScoreKeeper.scoreBoard(total1, total2);
                    }
                    else
                    {
                        System.out.println("Player 1 or 2, please press your assigned letter");
                        throw new IllegalArgumentException();
                    }
                }
                catch(IllegalArgumentException e)
                {
                    System.err.println("Illegal letter was typed.");
                }
            }
        }
        
        System.out.println();
        ScoreKeeper.storeWinnerScore(total1, total2);
        ScoreKeeper.readWinnerScores();
    }
}
