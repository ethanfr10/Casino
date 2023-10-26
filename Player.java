public class Player
{
   private double bankroll;
   private Hand hand;
   private double bet;
   private String name;
   
   public Player(String n, double b)
   {
       bankroll = b;
       bet = 0;
       hand = new Hand();
       name = n;
   }
   
   public String getName()
   {
       return name;
   }
   
   public void bet(double b)
   {
       bet = b;
   }
   
   public double getBet()
   {
       return bet;
   }
   
   public void doubleDown(double b)
   {
       bet = bet * 2;
   }
   
   public void hit(Card c)
   {
       hand.addCard(c);
   }
   
   public void addBankroll(double a)
   {
       bankroll = bankroll + a;
   }
   
   public void removeBankroll(double a)
   {
       bankroll = bankroll - a;
   }
   
   public double getBankroll()
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
        return "Name: " + getName() + ". Has: $" + getBankroll() + "\nHand: \n" + getHand().toString();
    }
}
