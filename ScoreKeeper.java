package application;

import java.util.Scanner;
import java.io.*;

public class ScoreKeeper
{
    static int scoreP1 = 0;
    static int scoreP2 = 0;

    public static void scoreBoard(int scoreP1, int scoreP2)
    {      
        System.out.println(" ______________");
        System.out.println("|   *Scores*   |");
        System.out.println("|Player 1: "+scoreP1+"   |");
        System.out.println("|--------------|");    
        System.out.println("|Player 2: "+scoreP2+"   |");
        System.out.println("|______________|");
        
    }
    
    public static int countPlayer1Score(String [][] board)
    {
        int normScoreCount = 0;
        int extraScoreCount = 0;
        int negScoreCount = 0;
        for (int i = 1; i<4; i++)
        {
            for (int j =13; j<28; j++)
            {
                if (board[i][j].equals("0"))
                {
                    normScoreCount++;
                }
                
                else if (board[i][j].equals("+"))
                {
                   extraScoreCount++;
                }
                
                else if (board[i][j].equals("-"))
                {
                    negScoreCount++;
                }
            }
        }
        scoreP1 = (normScoreCount*1) + (extraScoreCount*2) + (negScoreCount*-1);
        normScoreCount = 0;
        extraScoreCount = 0;
        negScoreCount = 0;
        return scoreP1;
   
    }
    
    public static int countPlayer2Score(String [][] board)
    {
        int normScoreCount = 0;
        int extraScoreCount = 0;
        int negScoreCount = 0;
        for (int i = 9; i<12; i++)
        {
            for (int j =13; j<28; j++)
            {
                if (board[i][j].equals("0"))
                {
                    normScoreCount++;
                }
                
                else if (board[i][j].equals("+"))
                {
                   extraScoreCount++;
                }
                
                else if (board[i][j].equals("-"))
                {
                    negScoreCount++;
                }
            }
        }
        scoreP2 = (normScoreCount*1) + (extraScoreCount*2) + (negScoreCount*-1);
        normScoreCount = 0;
        extraScoreCount = 0;
        negScoreCount = 0;
        return scoreP2;
    }
    
    public static void main(int total1, int total2)
    {
        scoreBoard(total1, total2);
    }
    
    public static void storeWinnerScore(int total1, int total2)
    {
        Scanner in = new Scanner(System.in);
        FileWriter myWriter;
        int count = 1;
        BufferedReader myReader;
        try
        {
            myReader = new BufferedReader(new FileReader("WinnerScores.txt"));
            String winnerData;
            while ((winnerData = myReader.readLine()) != null)
            {
                String [] fields = winnerData.split("\\)");
                count = Integer.parseInt(fields[0])+1;
            }
        }
        catch (FileNotFoundException e)
        {
            System.err.println("No Winner Scores file has been created yet.");
            System.err.println("Please play a game to create such file.");
        }
        catch (IOException e)
        {
            System.err.println("Something went wrong when trying to read the scores.");
        }
        
        try
        {
            if (total1 > total2)
            {
                myWriter = new FileWriter("WinnerScores.txt",true);
                System.out.println("\nPlayer 1, you won!");
                System.out.println("You get to be on the Winners Board!");
                System.out.print("Please type your name: ");
                String nameIn = in.next();
                myWriter.write(count + ") " + nameIn + ": " + total1 + "\n");
                System.out.println("\nThank you! Please come back and play again soon!");
                myWriter.close();
            }
            else if (total2 > total1)
            {
                myWriter = new FileWriter("WinnerScores.txt",true);
                System.out.println("\nPlayer 2, you won!");
                System.out.println("You get to be on the Winners Board!");
                System.out.print("Please type your name: ");
                String nameIn = in.next();
                myWriter.write(count + ") " + nameIn + ": " + total2 + "\n");
                System.out.println("\nThank you! Please come back and play again soon!");
                myWriter.close();
            }
            else if ((total1 == total2) && (Food.normCount == 0) )
            {
                System.out.println("\nYou tied eachother!");
                System.out.println("Sorry, because of that neither of you can be on the Winners Board :(");
                System.out.println("Please play again to try to get one of your names on the board!");
            }
        }
        catch (IOException e) 
        {
            System.err.println("Something went wrong trying to save your score.");
        }
       
    }
    
    public static void readWinnerScores()
    {
        BufferedReader myReader;
        try
        {
            myReader = new BufferedReader(new FileReader("WinnerScores.txt"));
            String winnerData;
            System.out.println("\nHere is the list of past Winners: ");
            while ((winnerData = myReader.readLine()) != null)
            {
                System.out.println();
                System.out.println(winnerData);
            }
        }
        catch (FileNotFoundException e)
        {
            System.err.println("No Winner Scores file has been created yet.");
            System.err.println("Please play a game to create such file.");
        }
        catch (IOException e)
        {
            System.err.println("Something went wrong when trying to read the scores.");
        }
    }
    
}

