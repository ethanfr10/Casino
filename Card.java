public class Card
{
    private int suit;
    private int rank;
    private boolean ace;
    
    //public final String 1 = "Diamonds";
    //public final String 2 = "Hearts";
    //public final String 3 = "Spades";
    //public final String 4 = "Clubs";
    
    public Card()
    {
        suit = 0;
        rank = 1;
        ace = true;
    }
    
    public Card(int s, int r)
    {
        suit = s;
        rank = r;
        ace = true;
    }
    
    public int getSuit() 
    {
        return suit;
    }
    
    public String suitString()
    {
        if(suit == 0)
        {
            return "Spades";
        }
        else if(suit == 1)
        {
            return "Diamonds";
        }
        else if(suit == 2)
        {
            return "Clubs";
        }
        else 
        {
            return "Hearts";
        }
    }
    
    public int getRank()
    {
        return rank;
    }
    
    public String rankString()
    {
        if(rank == 1)
        {
            return "Ace";
        }
        else if(rank >= 2 && rank <= 10)
        {
            return String.valueOf(rank);
        }
        else if(rank == 11)
        {
            return "Jack";
        }
        else if(rank == 12)
        {
            return "Queen";
        }
        else if(rank == 13)
        {
            return "King";
        }
        return "Error";
    }
    
    public int getValue()
    {
        if(rank <= 10 && rank >= 2)
        {
            return rank;
        }
        if(rank > 10)
        {
            return 10;
        }
        else
        {
            if(ace)
            {
                return 11;
            }
            else
            {
                return 1;
            }
        }
    }
    public void switchAce()
    {
        ace = !ace;
    }
    public String toString()
    {
        return rankString() + " of " + suitString();
    }
}
