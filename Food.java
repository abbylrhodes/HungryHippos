package application;

public class Food
{
    // instance variables - replace the example below with your own
    //public static String [][] foodCoordinates;
    static int extraCount = 7;
    static int normCount = 15;
    static int negCount = 7;

        public static int getCountExtra1(String [][] board)
    {
        for (int i = 1; i<4; i++)
        {
            for (int j =13; j<28; j++)
            {
                if (board[i][j].equals("+"))
                {
                    extraCount --;
                }
            }
        }
        return extraCount;
    }
    
    public static int getCountExtra2(String [][] board)
    {
        for (int i = 9; i<12; i++)
        {
            for (int j =13; j<28; j++)
            {
                if (board[i][j].equals("+"))
                {
                    extraCount --;
                }
            }
        }
        return extraCount;
    }    
    
    
    public static int getCountNormal1(String [][] board)
    {
        for (int i = 1; i<4; i++)
        {
            for (int j =13; j<28; j++)
            {
                if (board[i][j].equals("0"))
                {
                    normCount --;
                }
            }
        }
        return normCount;
    }
    
    
    public static int getCountNormal2(String [][] board)
    {
        for (int i = 9; i<12; i++)
        {
            for (int j =13; j<28; j++)
            {
                if (board[i][j].equals("0"))
                {
                    normCount --;
                }
            }
        }
        return normCount;
    }
    
        public static int getCountNegative1(String [][] board)
    {
        for (int i = 1; i<4; i++)
        {
            for (int j =13; j<28; j++)
            {
                if (board[i][j].equals("-"))
                {
                    negCount --;
                }
            }
        }
        return negCount;
    }
    
    public static int getCountNegative2(String [][] board)
    {
        for (int i = 9; i<12; i++)
        {
            for (int j =13; j<28; j++)
            {
                if (board[i][j].equals("-"))
                {
                    negCount --;
                }
            }
        }
        return negCount;
    }
    
}

