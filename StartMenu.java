package application;

import java.util.Scanner;

public class StartMenu
{
    public StartMenu()
    {
        
    }
    
    /*
     * Creates Start Menu for game.
     * 
     * @throws IllegalArgumentException if the user does not successfully type 'START'
     *          and will quit out of program
     */
    public static void start()
    {
        System.out.println();
        System.out.println("Welcome to Hungry Hungry Hippos!");
        System.out.println("********************************");
        System.out.println();
        //System.out.println("Please type 'START' if you wish to begin");
        //Scanner startIn = new Scanner(System.in);
        //String start = startIn.next();
        String start = "START";
        
        // Precondition #4
        try
        {
            if (start.equals("START"))
            {
                Player Player1 = new Player();
                Player1.assignPlayer1Key();
                System.out.println("You will press the '" + Player1.p1Key + "' key");
                System.out.println("Your Hippo is at the top of the board.");
                
                System.out.println();
                
                Player Player2 = new Player();
                Player2.assignPlayer2Key(Player1.p1Key);
                System.out.println("You will press the '" + Player2.p2Key + "' key");
                System.out.println("Your Hippo is at the bottom of the board.");
            }
            else
            {
                throw new IllegalArgumentException();
            }
        }
        catch (IllegalArgumentException e)
        {
            System.out.println();
            System.out.println("You don't want to start?");
            System.out.println("Okay.....that was unexpected.");
            System.out.println("Please come back and try again later!");
            System.err.println("Illegal input: " + start);
        }
        
    }
    
    public static void quit()
    {
    	System.out.println();
        System.out.println("You don't want to start?");
        System.out.println("Okay.....that was unexpected.");
        System.out.println("Please come back and try again later!");
        //System.err.println("Illegal input: " + start);
    }
}
