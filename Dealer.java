import java.util.Scanner;
import java.lang.Object;
import java.lang.Thread;
import java.util.InputMismatchException;
public class Dealer
{
   private Hand hand;
   private Shoe shoe;
   private Player player;
   private String name;
   private double money;
   private boolean dd;
   private boolean run;
   private String ans;
   private double bet;
   private double bet1;
   
   /**
     * Constructor
     * Begins the game and initializes dealer
     **/
   public Dealer() throws InterruptedException
   {
       System.out.println("\u2660\u2661Welcome to Blackjack.\u2662\u2663");
       System.out.println("Basic Rules of the game are: \nPlayer has a hand of cards that they want to get as close"); 
       System.out.println("to 21 with, \nThe Dealer will do the same.");
       System.out.println("Bet before each hand so bankroll will change depending if \nyou win or lose at end of hand.");
       hand = new Hand();
       shoe = new Shoe();
       Scanner a = new Scanner(System.in);
       Thread.sleep(2000);
       System.out.println("\nWhat is your name? ");
       name = a.nextLine();
       try
       {
       Scanner e = new Scanner(System.in);
       System.out.println("How much money do you want to buy in for? ");
       money = e.nextDouble();
       }
       catch(InputMismatchException ime)
       {
           Scanner t = new Scanner(System.in);
           System.out.println("You did not enter an integer, try again.");
           money = t.nextDouble();
       }
       player = new Player(name(), money());
   }
   /**
     * name()
     * returns name
     **/
   public String name() 
   {
       return name;
   }
   /**
     * money()
     * returns money
     **/
   public double money()
   {
       return money;
   } 
   
   /**
     * startGame()
     * Runs the whole game
     **/
   public void startGame() throws InterruptedException
   {
       run = true;
       System.out.println("Hello " + name() + " You are starting with $" + money());
       Scanner e = new Scanner(System.in);
       Thread.sleep(750);
       try
       {
       System.out.println("What is your bet? ");
       bet = e.nextDouble();
       }
       catch(InputMismatchException ime)
       {
           Scanner y = new Scanner(System.in);
           System.out.println("You did not enter an integer, try again.");
           bet = y.nextDouble();
       }
       while(bet > player.getBankroll())
       {
           System.out.println("Bet is greater than bankroll. \nBet again.");
           Thread.sleep(750);
           try
        {
            System.out.println("What is your bet? ");
            bet = e.nextDouble();
       }
       catch(InputMismatchException ime)
       {
           Scanner y = new Scanner(System.in);
           System.out.println("You did not enter an integer, try again.");
           bet = y.nextDouble();
       }
       
       }
       player.hit(drawCard());
       hit(drawCard());
       player.hit(drawCard());
       System.out.println(player);
       if(player.getHand().isBlackjack())
       {
           player.addBankroll((bet / 2) * 3);
           System.out.println("You Won with Blackjack!");
           Thread.sleep(750);
           System.out.println(name() + " has $" + player.getBankroll());
       }
       else
       {
       System.out.print("You have: " + player.getHand().getHandValue() + "\n");
       Thread.sleep(750);
       System.out.println(toString());
       if(getHand().getHandValue() == 11)
       {
           Scanner r = new Scanner(System.in);
           Thread.sleep(750);
           System.out.println("Would you like Insurance?");
           ans = r.nextLine();
           while(!ans.equalsIgnoreCase("yes") && !ans.equalsIgnoreCase("no"))
       {
           System.out.println("You did not choose yes or no, \nChoose Again.");
           ans = r.nextLine();
       }
           hit(drawCard());
           if(ans.equalsIgnoreCase("Yes") && getHand().isBlackjack())
           {
               Thread.sleep(750);
               System.out.println("Dealer has Blackjack, you get Insurance.");
               Thread.sleep(750);
               System.out.println(toString());
               player.removeBankroll((bet / 2));
               Thread.sleep(750);
               System.out.println(name() + " has $" + player.getBankroll());
               dd = false;
               run = false;
           }
           if(ans.equalsIgnoreCase("Yes") && !(getHand().isBlackjack()))
           {
               Thread.sleep(750);
               System.out.println("Dealer does not have Blackjack, you lose your Insurance.");
               player.removeBankroll(bet / 2);
               Thread.sleep(750);
               System.out.println(name() + " has $" + player.getBankroll());
               dd = true;
               run = true;
           }
           if(ans.equalsIgnoreCase("No") && getHand().isBlackjack())
       {
           player.removeBankroll(bet);
           Thread.sleep(750);
           System.out.println("The Dealer has Blackjack!");
           Thread.sleep(750);
           System.out.println(toString());
           Thread.sleep(750);
           System.out.println(name() + " has $" + player.getBankroll());
           run = false;
           dd = false;
       }
       if(ans.equalsIgnoreCase("No") && !getHand().isBlackjack())
       {
           System.out.println("Good Choice, Dealer does not have blackjack.");
           run = true;
           dd = true;
       }
       } 
       if(getHand().getHandValue() == 11 && !getHand().isBlackjack() || !(getHand().getHandValue() == 11))
       {
        if(run)
        {
       hit(drawCard());
       Scanner a = new Scanner(System.in);
       if(bet * 2 <= player.getBankroll())
       {
           Thread.sleep(750);
       System.out.println("Hit, Stay, or Double Down? ");
       }
       else
       {
           Thread.sleep(750);
           System.out.println("Hit or Stay?");
       }
       String opt = a.nextLine();
       while(opt.equalsIgnoreCase("Double Down") && (bet * 2 > player.getBankroll()))
       {
           Thread.sleep(750);
           System.out.println("Bet would be greater than bankroll. \nChoose Hit or Stay.");
           Thread.sleep(750);
           System.out.println("Hit or Stay? ");
        opt = a.nextLine();
           
       }
       while(!opt.equalsIgnoreCase("Hit") && !opt.equalsIgnoreCase("Stay") && !opt.equalsIgnoreCase("Double Down"))
       {
           Thread.sleep(750);
           System.out.println("You did not choose hit, stay, or double down. \nChoose Again.");
           Thread.sleep(750);
           System.out.println("Hit, Stay, or Double Down? ");
           opt = a.nextLine();
       }
       while(opt.equalsIgnoreCase("Hit"))
       {
           player.hit(drawCard());
           System.out.println(player.getHand());
           Thread.sleep(750);
           System.out.println("You have: " + player.getHand().getHandValue());
           
           if(player.getHand().checkBust())
           {
               Thread.sleep(750);
               System.out.println("You busted.");
               break;
           }
           if(player.getHand().getSize() == 5 && player.getHand().getHandValue() <= 21 && !player.getHand().checkBust())
           {
               player.addBankroll(bet);
               Thread.sleep(750);
               System.out.println("You Won! (5 Card Charlie)");
               Thread.sleep(750);
               System.out.println(name() + " has $" + player.getBankroll());
               dd = false;
               break;
           }
        Thread.sleep(750);
        System.out.println("Hit or Stay? ");
        opt = a.nextLine();
        while(!opt.equalsIgnoreCase("hit") && !opt.equalsIgnoreCase("stay"))
        {
            System.out.println("You did not choose hit or stay, \nChoose Again.");
            opt = a.nextLine();
        }
        dd = true;
           
       }
       
       if(opt.equals("Stay") && !player.getHand().checkBust());
       {
           
           if(getHand().isBlackjack())
           {
               Thread.sleep(750);
               System.out.println("Dealer has Blackjack!");
           }
           
           
           while(getHand().getHandValue() <= 16)
           {
               if(player.getHand().checkBust())
               {
                   break;
               }
               hit(drawCard());
               Thread.sleep(1000);
               System.out.println(toString());
           
               if(getHand().checkBust() && !player.getHand().checkBust())
                    {
                        Thread.sleep(750);
                        System.out.println("The Dealer Busted!");
                        break;
                    }
            
           }
           if(getHand().getSize() <= 2 && !player.getHand().checkBust())
           {
               Thread.sleep(750);
               System.out.println(toString());
           }
           dd = true;
           
       }
       if(opt.equalsIgnoreCase("Double Down"))
       {
           bet = bet * 2;
           player.hit(drawCard());
           while(getHand().getHandValue() <= 16)
           {
               hit(drawCard());
               if(getHand().checkBust())
               {
                   dd = false;
                   Thread.sleep(750);
                   System.out.println("The Dealer Busted!");
                   player.addBankroll(bet);
                   Thread.sleep(750);
                   System.out.println("You Won!");
                   Thread.sleep(750);
                    System.out.println(name() + " has $" + player.getBankroll());
                   break;
                }
           }
           if(!getHand().checkBust())
           {
               Thread.sleep(750);
           System.out.println(player);
           Thread.sleep(750);
           System.out.println("You Have: " + player.getHand().getHandValue());
        }
        Thread.sleep(750);
        System.out.println(toString());
       } 
       }
       if(dd)
       {
       if(player.getHand().getHandValue() > getHand().getHandValue() && !(player.getHand().checkBust()) || getHand().checkBust())
       {
           player.addBankroll(bet);
           //money = player.getBankroll();
           Thread.sleep(750);
           System.out.println("The Dealer Has: " + getHand().getHandValue());
           Thread.sleep(750);
           System.out.println("You Won!");
           Thread.sleep(750);
           System.out.println(name() + " has $" + player.getBankroll());
           
       }
       if(player.getHand().getHandValue() < getHand().getHandValue() && !(getHand().checkBust()) || player.getHand().checkBust() || getHand().isBlackjack())
       {
           player.removeBankroll(bet);
           if(!player.getHand().checkBust())
           {
               Thread.sleep(750);
           System.out.println("The Dealer Won with: " + getHand().getHandValue());
           }
           Thread.sleep(750);
           System.out.println("You Lost.");
           Thread.sleep(750);
           System.out.println(name() + " has $" + player.getBankroll());
           
       }
       if(player.getHand().getHandValue() == getHand().getHandValue() && !player.getHand().checkBust())
       {
           System.out.println("The Dealer has: " + getHand().getHandValue());
           Thread.sleep(750);
           System.out.println("You Pushed!");
       }
       if(player.getBankroll() <= 0)
       {
           Thread.sleep(750);
       System.out.println("You have no money left.");
       }
       }
    }
       }
       
      
     
       
    
       Scanner z = new Scanner(System.in);
       Thread.sleep(750);
       if(player.getBankroll() > 0)
       {
       System.out.println("Would you like to play again? ");
       }
       String again = z.nextLine();
       while(!again.equalsIgnoreCase("yes") && !again.equalsIgnoreCase("no"))
       {
           System.out.println("You did not choose yes or no, \nChoose Again.");
           again = z.nextLine();
       }
       while(player.getBankroll() > 0)
     {
       while(again.equalsIgnoreCase("yes"))
       {
        player.clearHand();
        clearHand();
        getShoe().Shuffle();
       //System.out.println("Welcome to Blackjack.");
       Scanner x = new Scanner(System.in);
       System.out.println("Hello " + name() + ", you currently have $" + player.getBankroll());
       Thread.sleep(750);
       try
       {
       System.out.println("What is your bet? ");
       bet1 = x.nextDouble();
       }
       catch(InputMismatchException ime)
       {
           Scanner y = new Scanner(System.in);
           System.out.println("You did not enter an integer, try again.");
           bet1 = y.nextDouble();
       }
       while(bet1 > player.getBankroll())
       {
           System.out.println("Bet is greater than bankroll. \nBet again.");
           Thread.sleep(750);
           try
           {
           System.out.println("What is your bet? ");
           bet1 = x.nextDouble();
           }
           catch(InputMismatchException ime)
       {
           Scanner y = new Scanner(System.in);
           System.out.println("You did not enter an integer, try again.");
           bet1 = y.nextDouble();
       }
       }
       player.hit(drawCard());
       hit(drawCard());
       player.hit(drawCard());
       System.out.println(player);
       if(player.getHand().isBlackjack())
       {
           player.addBankroll((bet1 / 2) * 3);
           System.out.println("You Win!");
           Thread.sleep(750);
           System.out.println(name() + " has $" + player.getBankroll());
       }
       else 
       {
           Thread.sleep(750);
       System.out.print("You have: " + player.getHand().getHandValue() + "\n");
       Thread.sleep(750);
       System.out.println(toString());
       if(getHand().getHandValue() == 11)
       {
           Scanner r = new Scanner(System.in);
           System.out.println("Would you like Insurance?");
           ans = r.nextLine();
           while(!ans.equalsIgnoreCase("yes") && !ans.equalsIgnoreCase("no"))
       {
           System.out.println("You did not choose yes or no, \nChoose Again.");
           ans = r.nextLine();
       }
           hit(drawCard());
           if(ans.equalsIgnoreCase("Yes") && getHand().isBlackjack())
           {
               Thread.sleep(750);
               System.out.println("Dealer has Blackjack, you get Insurance.");
               Thread.sleep(750);
               System.out.println(toString());
               player.removeBankroll((bet / 2));
               Thread.sleep(750);
               System.out.println(name() + " has $" + player.getBankroll());
               dd = false;
               run = false;
           }
           if(ans.equalsIgnoreCase("Yes") && !(getHand().isBlackjack()))
           {
               Thread.sleep(750);
               System.out.println("Dealer does not have Blackjack, you lose your Insurance.");
               player.removeBankroll(bet / 2);
               Thread.sleep(750);
               System.out.println(name() + " has $" + player.getBankroll());
               dd = true;
               run = true;
           }
           if(ans.equalsIgnoreCase("No") && getHand().isBlackjack())
       {
           player.removeBankroll(bet);
           Thread.sleep(750);
           System.out.println("The Dealer has Blackjack!");
           Thread.sleep(750);
           System.out.println(name() + " has $" + player.getBankroll());
           run = false;
           dd = false;
       }
       if(ans.equalsIgnoreCase("No") && !getHand().isBlackjack())
       {
           System.out.println("Good Choice, Dealer does not have blackjack.");
           run = true;
           dd = true;
       }
       
       } 
       if(getHand().getHandValue() == 11 && !getHand().isBlackjack() || !(getHand().getHandValue() == 11))
       {
        if(run)
        {
       hit(drawCard());
       Scanner y = new Scanner(System.in);
       if(bet1 * 2 <= player.getBankroll())
       {
           Thread.sleep(750);
         System.out.println("Hit, Stay, or Double Down? ");
       }
       else
       {
           Thread.sleep(750);
           System.out.println("Hit or Stay?");
       }
       String opt1 = y.nextLine();
       while(opt1.equalsIgnoreCase("Double Down") && (bet1 * 2 > player.getBankroll()))
       {
           System.out.println("Bet would be greater than bankroll. \nChoose Hit or Stay.");
           Thread.sleep(750);
           System.out.println("Hit or Stay? ");
        opt1 = y.nextLine();
           
       }
       while(!opt1.equalsIgnoreCase("Hit") && !opt1.equalsIgnoreCase("Stay") && !opt1.equalsIgnoreCase("Double Down"))
       {
           System.out.println("You did not choose hit, stay, or double down. \nChoose Again.");
           Thread.sleep(750);
           System.out.println("Hit, Stay, or Double Down? ");
           opt1 = y.nextLine();
       }
       while(opt1.equalsIgnoreCase("Hit"))
       {
           player.hit(drawCard());
           System.out.println(player.getHand());
           Thread.sleep(750);
           System.out.println("You have: " + player.getHand().getHandValue());
           
           if(player.getHand().checkBust())
           {
               Thread.sleep(750);
               System.out.println("You busted with: " + player.getHand().getHandValue());
               break;
           }
           if(player.getHand().getSize() == 5 && player.getHand().getHandValue() <= 21 && !player.getHand().checkBust())
           {
               player.addBankroll(bet);
               Thread.sleep(750);
               System.out.println("You Won! (5 Card Charlie)");
               Thread.sleep(750);
               System.out.println(name() + " has $" + player.getBankroll());
               dd = false;
               break;
           }
    
        System.out.println("Hit or Stay? ");
        opt1 = y.nextLine();
        while(!opt1.equalsIgnoreCase("hit") && !opt1.equalsIgnoreCase("stay"))
        {
            System.out.println("You did not choose hit or stay, \nChoose Again.");
            opt1 = y.nextLine();
        }
         dd = true;
       }
       
       if(opt1.equalsIgnoreCase("Stay") && !player.getHand().checkBust())
       {
           
           if(getHand().isBlackjack())
           {
               Thread.sleep(750);
               System.out.println("Dealer has Blackjack!");
           }
           
           while(getHand().getHandValue() <= 16)
           {
               if(player.getHand().checkBust())
               {
                   break;
               }
               hit(drawCard());
               Thread.sleep(1000);
               System.out.println(toString());
           
               if(getHand().checkBust() && !player.getHand().checkBust())
                    {
                        Thread.sleep(750);
                        System.out.println("The Dealer Busted!");
                        break;
                    }
           }
           if(getHand().getSize() <= 2 && !player.getHand().checkBust())
           {
               Thread.sleep(750);
               System.out.println(toString());
           }
           dd = true;
           
       }
       if(opt1.equalsIgnoreCase("Double Down"))
       {
           bet1 = bet1 * 2;
           player.hit(drawCard());
           while(getHand().getHandValue() <= 16)
           {
               hit(drawCard());
               if(getHand().checkBust())
               {
                   dd = false;
                   Thread.sleep(750);
                   System.out.println("The Dealer Busted!");
                   player.addBankroll(bet1);
                   Thread.sleep(750);
                   System.out.println("You Won!");
                   Thread.sleep(750);
                    System.out.println(name() + " has $" + player.getBankroll());
                   break;
                }
           }
           if(!getHand().checkBust())
           {
               Thread.sleep(750);
           System.out.println(player);
           Thread.sleep(750);
           System.out.println("You Have: " + player.getHand().getHandValue());
        }
        Thread.sleep(750);
           System.out.println(toString());
       } 
       }
       if(dd)
       {
       if(player.getHand().getHandValue() > getHand().getHandValue() && !(player.getHand().checkBust()) || getHand().checkBust())
       {
           player.addBankroll(bet1);
           System.out.println("The Dealer Has: " + getHand().getHandValue());
           Thread.sleep(750);
           System.out.println("You Won!");
           Thread.sleep(750);
           System.out.println(name() + " has $" + player.getBankroll());
           
       }
       if(player.getHand().getHandValue() < getHand().getHandValue() && !(getHand().checkBust()) || player.getHand().checkBust() || getHand().isBlackjack())
       {
           player.removeBankroll(bet1);
           System.out.println("You Lost.");
           if(!player.getHand().checkBust())
           {
               Thread.sleep(750);
           System.out.println("The Dealer Won with: " + getHand().getHandValue());
           }
           Thread.sleep(750);
           System.out.println(name() + " has $" + player.getBankroll());
           
       }
       if(player.getHand().getHandValue() == getHand().getHandValue() && !player.getHand().checkBust())
       {
           System.out.println("The Dealer has: " + getHand().getHandValue());
           Thread.sleep(750);
           System.out.println("You Pushed!");
       }
    }
    if(player.getBankroll() <= 0)
       {
           Thread.sleep(750);
       System.out.println("You have no money left.");
       break;
       }
       }
       Thread.sleep(750);
       if(player.getBankroll() > 0)
       {
       System.out.println("Would you like to play again? ");
       }
        again = z.nextLine();
        while(!again.equalsIgnoreCase("yes") && !again.equalsIgnoreCase("no"))
       {
           System.out.println("You did not choose yes or no, \nChoose Again.");
           again = z.nextLine();
       }
        
        
       
       }
       }
       }
     
     
       
    }
    /**
     * getShoe()
     * returns the current shoe
     **/
   public Shoe getShoe()
   {
       return shoe;
   }
   /**
     * getHand()
     * returns the current hand
     **/
   public Hand getHand()
   {
       return hand;
   }
   /**
     * drawCard()
     * draws card from top of shoe
     **/
   public Card drawCard()
   {
       return shoe.drawCard();
   }
   /**
     * hit()
     * adds card to hand when called
     **/
   public void hit(Card c)
   {
       hand.addCard(c);
   }
   /**
     * Shuffle()
     * shuffles the shoe
     **/
   public void shuffle()
   {
       shoe = new Shoe();
   }
   /**
     * clearHand()
     * clears the hand
     **/
   public void clearHand()
   {
       hand.clearHand();
   }
  
   
  
       
   /**
     * toString()
     * displays the hand
     **/
   public String toString()
   {
       return "The Dealer has: \n" + getHand().toString();
   } 
}

