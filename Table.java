
/**
 * Table.java  
 *
 * @author:
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
public class Table
{
   private double bankroll;
   private Hand hand;
   
   public Table()
   {
       bankroll = 0;
       hand = new Hand();
   }
   
   public void hit(Card c)
   {
       hand.addCard(c);
   }
   
   public void addBet(double a)
   {
       bankroll = bankroll + a;
   }
   
   public void removeBet(double a)
   {
       bankroll = bankroll - a;
   }
   
   public void clearBet()
   {
       bankroll = 0;
    }
   
   public double getPot()
   {
       return bankroll;
   }
   
   public Hand getHand()
   {
       return hand;
   }
   
   public void clearHand()
   {
       hand.clearHand();
   }
   
   public boolean isBlackjack()
   {
       if(hand.isBlackjack())
       {
           return true;
       }
       return false;
   }
   
   public String toString()
    {
        return ("Table: \n" + getHand().toString() + "\nPot: " + getPot());
    }
}
