import java.util.Scanner;
import java.lang.Object;
import java.lang.Thread;
import java.util.InputMismatchException;
import java.lang.Object;
import java.util.Random;
/**
 * HoldEmDealer.java  
 *
 * @author:
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
public class HoldEmDealer
{
    private Hand hand;
    private Shoe shoe;
    private Player player;
    private String name;
    private double money;
    private boolean dd;
    private Table table;
    private String k;
    private int who;
    private double bet;
    private double ans;
    private boolean run;
    private boolean work;
    private int rand;
    private int rand1;
    private int rand2;
    private int rand3;
    private int rand4;
    private int rand5;
    private int rand6;
    public HoldEmDealer() throws InterruptedException
    {
        /**System.out.println(rand);
        System.out.println(rand1);
        System.out.println(rand2);
        System.out.println(rand3);
        System.out.println(rand4);
        System.out.println(rand5);
        System.out.println(rand6);
         **/

        System.out.println("Welcome to Texas Hold'Em.");
        hand = new Hand();
        shoe = new Shoe();
        Scanner a = new Scanner(System.in);
        try{
            System.out.println("What is your name? ");
            name = a.nextLine();
        }
        catch(InputMismatchException ime)
        {
            Scanner y = new Scanner(System.in);
            System.out.println("You did not enter a String, try again.");
            name = y.nextLine();
        } 
        Scanner e = new Scanner(System.in);
        try{
            System.out.println("How much money do you want to buy in for? ");
            money = e.nextDouble();
        }
        catch(InputMismatchException ime)
        {
            Scanner y = new Scanner(System.in);
            System.out.println("You did not enter a Integer, try again.");
            money = y.nextDouble();
        } 
        player = new Player(name(), money());
        table = new Table();
        who = 2;
        work = true;
    }

    public String name()
    {
        return name;
    }

    public double money()
    {
        return money;
    } 

    public void turn() throws InterruptedException
    {
        run = true;
        work = true;
        player.clearHand();
        table.clearHand();
        //table.removeBankroll(2); //change
        clearHand();
        rand = (int) (Math.random()*2) +1;
        rand1 = (int) (Math.random()*2) +1;
        rand2 = (int) (Math.random()*2) +1;
        rand3 = (int) (Math.random()*2) +1;
        rand4 = (int) (Math.random()*2) +1;
        rand5 = (int) (Math.random()*2) +1;
        rand6 = (int) (Math.random()*2) +1;
        while(run)
        {
            player.clearHand();
            table.clearHand();
            //table.removeBankroll(2); //change
            clearHand();
            //System.out.println("Hello " + name() + " You have $" + player.getBankroll());
            Scanner e = new Scanner(System.in);
            player.hit(drawCard());
            hit(drawCard());
            player.hit(drawCard());
            hit(drawCard());
            System.out.println(player);
            try
            {
                System.out.println("Check, Bet, or Fold? (0 for Check, -1 for Fold)");
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
                    System.out.println("Check, Bet, or Fold? (0 for Check, -1 for Fold) ");
                    bet = e.nextDouble();
                }
                catch(InputMismatchException ime)
                {
                    Scanner y = new Scanner(System.in);
                    System.out.println("You did not enter an integer, try again.");
                    bet = y.nextDouble();
                }

            }
            if(bet == -1)
            {

                Scanner t = new Scanner(System.in);
                System.out.println("Would you like to play again?");
                k = t.nextLine();

                if(k.equalsIgnoreCase("yes"))
                {
                    player.clearHand();
                    clearHand();
                    // add bankroll to either dealer or player
                    table.clearBet();
                    System.out.print("Shuffling");
                    for(int i =0; i<3;i++){
                        Thread.sleep(500);
                        System.out.print(".");
                    }
                    Thread.sleep(1600);

                    System.out.println();
                    run = false;
                    turn();
                }

            }
            if(bet == 0)
            {
                if(rand == 1)
                {
                    Thread.sleep(500);
                    System.out.println("The Computer bets $1.");
                    Thread.sleep(200);
                    Scanner y = new Scanner(System.in);
                    System.out.println("Call (1) or Fold? (-1)");
                    int ans = y.nextInt();
                    if(ans == -1)
                    {
                        Scanner t = new Scanner(System.in);
                        System.out.println("Would you like to play again?");
                        k = t.nextLine();

                        if(k.equalsIgnoreCase("yes"))
                        {
                            player.clearHand();
                            clearHand();
                            // add bankroll to either dealer or player
                            table.clearBet();
                            System.out.print("Shuffling");
                            for(int i =0; i<3;i++){
                                Thread.sleep(500);
                                System.out.print(".");
                            }
                            Thread.sleep(1600);

                            System.out.println();
                            run = false;
                            turn();
                        }

                    }
                    if(ans == 1)
                    {
                        table.addBet(2);
                        player.removeBankroll(1);
                        Thread.sleep(50);
                        //System.out.println(table);
                    }

                }
                if(rand == 2 || rand ==1)
                {
                    Thread.sleep(300);
                    System.out.println("The Computer Checks.");
                    Thread.sleep(200);
                    table.hit(drawCard());
                    Thread.sleep(50);
                    table.hit(drawCard());
                    Thread.sleep(50);
                    table.hit(drawCard());
                    Thread.sleep(50);
                    System.out.println(table);
                    System.out.println();
                }
            }

            if(bet > 0)
            {
                if(rand1 == 1)
                {
                    Thread.sleep(200);
                    System.out.println("The Dealer Calls.");
                    player.removeBankroll(bet);
                    table.addBet(bet * 2);
                    Thread.sleep(200);
                    table.hit(drawCard());
                    Thread.sleep(50);
                    table.hit(drawCard());
                    Thread.sleep(50);
                    table.hit(drawCard());
                    Thread.sleep(50);
                    System.out.println("\n" + table);
                }
                else
                {
                    Thread.sleep(200);
                    System.out.println("The Dealer has Folded.");
                    player.addBankroll(table.getPot());
                    Scanner t = new Scanner(System.in);
                    System.out.println("Would you like to play again?");
                    k = t.nextLine();

                    if(k.equalsIgnoreCase("yes"))
                    {
                        player.clearHand();
                        clearHand();
                        // add bankroll to either dealer or player
                        table.clearBet();
                        System.out.print("Shuffling");
                        for(int i =0; i<3;i++){
                            Thread.sleep(500);
                            System.out.print(".");
                        }
                        Thread.sleep(1600);

                        System.out.println();
                        run = false;
                        turn();
                    }

                }
            }
            //Make it so when you play again it doesnt ask this
            //if(bet != -1)

            if(run)
            {
                try
                {
                    Scanner o = new Scanner(System.in);
                    System.out.println("Check, Bet, or Fold? (0 for Check, -1 for Fold)");
                    bet = o.nextDouble();
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
                        System.out.println("Check, Bet, or Fold? (0 for Check, -1 for Fold) ");
                        bet = e.nextDouble();
                    }
                    catch(InputMismatchException ime)
                    {
                        Scanner y = new Scanner(System.in);
                        System.out.println("You did not enter an integer, try again.");
                        bet = y.nextDouble();
                    }

                }

                if(bet == -1)
                {
                    Scanner t = new Scanner(System.in);
                    System.out.println("Would you like to play again?");
                    k = t.nextLine();

                    if(k.equalsIgnoreCase("yes"))
                    {
                        player.clearHand();
                        clearHand();
                        // add bankroll to either dealer or player
                        table.clearBet();
                        System.out.print("Shuffling");
                        for(int i =0; i<3;i++){
                            Thread.sleep(500);
                            System.out.print(".");
                        }
                        Thread.sleep(1600);

                        System.out.println();
                        run = false;
                        turn();
                    }

                }
                if(bet == 0)
                {
                    if(rand2 == 1)
                    {
                        table.addBet(1);
                        Thread.sleep(500);
                        System.out.println("The Computer bets $1.");
                        Thread.sleep(200);
                        Scanner y = new Scanner(System.in);
                        System.out.println("Call (1), or Fold? (-1)");
                        double two = y.nextDouble();
                        if(two == -1)
                        {
                            Scanner t = new Scanner(System.in);
                            System.out.println("Would you like to play again?");
                            k = t.nextLine();

                            if(k.equalsIgnoreCase("yes"))
                            {
                                player.clearHand();
                                clearHand();
                                // add bankroll to either dealer or player
                                table.clearBet();
                                System.out.print("Shuffling");
                                for(int i =0; i<3;i++){
                                    Thread.sleep(500);
                                    System.out.print(".");
                                }
                                Thread.sleep(1600);

                                System.out.println();
                                run = false;
                                turn();
                            }

                        }
                        if(two == 1)
                        {
                            table.addBet(1);
                            player.removeBankroll(1);
                            Thread.sleep(200);
                            //table.hit(drawCard());
                            Thread.sleep(50);
                            //System.out.println(table);
                            System.out.println();
                        }

                    }
                    if(rand2 == 2 || rand2 == 1)
                    {
                        Thread.sleep(300);
                        System.out.println("The Computer Checks.");
                        Thread.sleep(200);
                        table.hit(drawCard());
                        Thread.sleep(50);
                        System.out.println(table);
                        System.out.println();
                    }
                }

                if(bet > 0)
                {
                    if(rand3 == 2)
                    {
                        Thread.sleep(200);
                        System.out.println("The Dealer Calls.");
                        player.removeBankroll(bet);
                        table.addBet(bet * 2);
                        Thread.sleep(200);
                        table.hit(drawCard());
                        Thread.sleep(50);
                        System.out.println("\n" + table);
                        System.out.println();
                    }
                    else
                    {
                        Thread.sleep(200);
                        System.out.println("The Dealer has Folded.");
                        player.addBankroll(table.getPot());
                        Scanner t = new Scanner(System.in);
                        System.out.println("Would you like to play again?");
                        k = t.nextLine();

                        if(k.equalsIgnoreCase("yes"))
                        {
                            player.clearHand();
                            clearHand();
                            // add bankroll to either dealer or player
                            table.clearBet();
                            System.out.print("Shuffling");
                            for(int i =0; i<3;i++){
                                Thread.sleep(500);
                                System.out.print(".");
                            }
                            Thread.sleep(1600);

                            System.out.println();
                            run = false;
                            turn();
                        }

                    }

                }
            }
            try
            {
                Scanner o = new Scanner(System.in);
                System.out.println("Check, Bet, or Fold? (0 for Check, -1 for Fold)");
                bet = o.nextDouble();
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
                    System.out.println("Check, Bet, or Fold? (0 for Check, -1 for Fold) ");
                    bet = e.nextDouble();
                }
                catch(InputMismatchException ime)
                {
                    Scanner y = new Scanner(System.in);
                    System.out.println("You did not enter an integer, try again.");
                    bet = y.nextDouble();
                }

            }

            if(bet == -1)
            {
                Scanner t = new Scanner(System.in);
                System.out.println("Would you like to play again?");
                k = t.nextLine();

                if(k.equalsIgnoreCase("yes"))
                {
                    player.clearHand();
                    clearHand();
                    // add bankroll to either dealer or player
                    table.clearBet();
                    System.out.print("Shuffling");
                    for(int i =0; i<3;i++){
                        Thread.sleep(500);
                        System.out.print(".");
                    }
                    Thread.sleep(1600);

                    System.out.println();
                    run = false;
                    turn();
                }

            }
            if(bet == 0)
            {
                if(rand4 == 1)
                {
                    table.addBet(1);
                    Thread.sleep(500);
                    System.out.println("The Computer bets $1.");
                    Thread.sleep(200);
                    Scanner y = new Scanner(System.in);
                    System.out.println("Call (1), or Fold? (-1)");
                    double two = y.nextDouble();
                    if(two == -1)
                    {
                        Scanner t = new Scanner(System.in);
                        System.out.println("Would you like to play again?");
                        k = t.nextLine();

                        if(k.equalsIgnoreCase("yes"))
                        {
                            player.clearHand();
                            clearHand();
                            // add bankroll to either dealer or player
                            table.clearBet();
                            System.out.print("Shuffling");
                            for(int i =0; i<3;i++){
                                Thread.sleep(500);
                                System.out.print(".");
                            }
                            Thread.sleep(1600);

                            System.out.println();
                            run = false;
                            turn();
                        }

                    }
                    if(two == 1)
                    {
                        table.addBet(1);
                        player.removeBankroll(1);
                        Thread.sleep(200);
                        //table.hit(drawCard());
                        Thread.sleep(50);
                        //System.out.println(table);
                        System.out.println();

                    }

                }
                if(rand4 == 2 || rand4 == 1)
                {
                    Thread.sleep(300);
                    System.out.println("The Computer Checks.");
                    Thread.sleep(200);
                    table.hit(drawCard());
                    Thread.sleep(50);
                    System.out.println(table);
                    System.out.println();
                }
            }

            if(bet > 0)
            {
                if(rand5 == 1)
                {
                    Thread.sleep(200);
                    System.out.println("The Dealer Calls.");
                    player.removeBankroll(bet);
                    table.addBet(bet * 2);
                    Thread.sleep(200);
                    table.hit(drawCard());
                    Thread.sleep(50);
                    System.out.println("\n" + table);
                    System.out.println();
                    run = true;
                }
                if(rand5 == 2)
                {
                    Thread.sleep(200);
                    System.out.println("The Dealer has Folded.");
                    player.addBankroll(table.getPot());
                    Scanner t = new Scanner(System.in);
                    System.out.println("Would you like to play again?");
                    k = t.nextLine();

                    if(k.equalsIgnoreCase("yes"))
                    {
                        player.clearHand();
                        clearHand();
                        // add bankroll to either dealer or player
                        table.clearBet();
                        System.out.print("Shuffling");
                        for(int i =0; i<3;i++){
                            Thread.sleep(500);
                            System.out.print(".");
                        }
                        Thread.sleep(1600);

                        System.out.println();
                        run = false;
                        turn();
                    }

                }

            }
            //{
            try
            {
                Scanner o = new Scanner(System.in);
                System.out.println("Check, Bet, or Fold? (0 for Check, -1 for Fold)");
                bet = o.nextDouble();
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
                    System.out.println("Check, Bet, or Fold? (0 for Check, -1 for Fold) ");
                    bet = e.nextDouble();
                }
                catch(InputMismatchException ime)
                {
                    Scanner y = new Scanner(System.in);
                    System.out.println("You did not enter an integer, try again.");
                    bet = y.nextDouble();
                }

            }

            if(bet == -1)
            {
                Scanner t = new Scanner(System.in);
                System.out.println("Would you like to play again?");
                k = t.nextLine();

                if(k.equalsIgnoreCase("yes"))
                {
                    player.clearHand();
                    clearHand();
                    // add bankroll to either dealer or player
                    table.clearBet();
                    System.out.print("Shuffling");
                    for(int i =0; i<3;i++){
                        Thread.sleep(500);
                        System.out.print(".");
                    }
                    Thread.sleep(1600);

                    System.out.println();
                    run = false;
                    turn();
                }

            }
            if(bet == 0)
            {
                if(rand4 == 1)
                {
                    table.addBet(1);
                    Thread.sleep(500);
                    System.out.println("The Computer bets $1.");
                    Thread.sleep(200);
                    Scanner y = new Scanner(System.in);
                    System.out.println("Call (1), or Fold? (-1)");
                    double two = y.nextDouble();
                    if(two == -1)
                    {
                        Scanner t = new Scanner(System.in);
                        System.out.println("Would you like to play again?");
                        k = t.nextLine();

                        if(k.equalsIgnoreCase("yes"))
                        {
                            player.clearHand();
                            clearHand();
                            // add bankroll to either dealer or player
                            table.clearBet();
                            System.out.print("Shuffling");
                            for(int i =0; i<3;i++){
                                Thread.sleep(500);
                                System.out.print(".");
                            }
                            Thread.sleep(1600);

                            System.out.println();
                            run = false;
                            turn();
                        }

                    }
                    if(two == 1)
                    {
                        table.addBet(1);
                        player.removeBankroll(1);
                        Thread.sleep(200);
                        //table.hit(drawCard());
                        Thread.sleep(50);
                        //System.out.println(table);
                        System.out.println();
                        run = true;
                        check();
                        turn();

                    }

                }
                if(rand4 == 2 || rand4 == 1)
                {
                    Thread.sleep(300);
                    System.out.println("The Computer Checks.");
                    Thread.sleep(200);
                    //table.hit(drawCard());
                    Thread.sleep(50);
                    //System.out.println(table);
                    System.out.println();
                    //System.out.println(getHand());
                    //System.out.println(getHand().cardValue());
                    //System.out.println(player.getHand().cardValue());
                    check();
                    turn();
                    run1();
                }
            }
            if(bet > 0)
            {
                if(rand6 == 1)
                {
                    Thread.sleep(200);
                    System.out.println("The Dealer Calls.");
                    player.removeBankroll(bet);
                    table.addBet(bet * 2);
                    Thread.sleep(200);
                    //table.hit(drawCard());
                    Thread.sleep(50);
                    //System.out.println("\n" + table);
                    System.out.println();
                    check();
                    run1();
                    run = true;

                }
                if(rand6 == 2)
                {
                    Thread.sleep(200);
                    System.out.println("The Dealer has Folded.");
                    player.addBankroll(table.getPot());
                    Scanner t = new Scanner(System.in);
                    System.out.println("Would you like to play again?");
                    k = t.nextLine();

                    if(k.equalsIgnoreCase("yes"))
                    {
                        player.clearHand();
                        clearHand();
                        // add bankroll to either dealer or player
                        table.clearBet();
                        System.out.print("Shuffling");
                        for(int i =0; i<3;i++){
                            Thread.sleep(500);
                            System.out.print(".");
                        }
                        Thread.sleep(1600);

                        System.out.println();
                        run = false;
                        turn();
                    }

                }
                run1();
            }


        }
    }

    public Shoe getShoe()
    {
        return shoe;
    }

    public void run1() throws InterruptedException
    {
        Scanner t = new Scanner(System.in);
        System.out.println("Would you like to play again?");
        k = t.nextLine();
        if(k.equalsIgnoreCase("yes"))
        {
            player.clearHand();
            clearHand();
            // add bankroll to either dealer or player
            table.clearBet();
            System.out.print("Shuffling");
            for(int i =0; i<3;i++){
                Thread.sleep(500);
                System.out.print(".");
            }
            Thread.sleep(1600);

            System.out.println();
            run = false;

        }
    }

    public void check() throws InterruptedException
    {
        /**if(player.getHand().cardValue() != table.getHand().cardValue() && getHand().cardValue() != table.getHand().cardValue())
        {
        if(player.getHand().cardValue() > getHand().cardValue())
        {
        System.out.println("You Win!");
        Thread.sleep(100);
        System.out.println(toString());
        player.addBankroll(table.getPot());

        }
        if(player.getHand().cardValue() < getHand().cardValue())
        {
        System.out.println("You Lose.");
        Thread.sleep(100);
        System.out.println(toString());

        }
        } **/
        while(run)
        {
            if(table.getHand().royalFlush(player.getHand()) && !(table.getHand().royalFlush(getHand())))
            {
                System.out.println("You Win!");
                System.out.println("You Have a Royal Flush!");
                Thread.sleep(100);
                System.out.println(toString());
                player.addBankroll(table.getPot());
                break;
            }
            if (!table.getHand().royalFlush(player.getHand()) && (table.getHand().royalFlush(getHand())))
            {
                System.out.println("You Lose.");
                System.out.println("Dealer has a Royal Flush.");
                Thread.sleep(100);
                System.out.println(toString());
                Thread.sleep(100);
                break;
            }

            if(table.getHand().royalFlush(player.getHand()) && (table.getHand().royalFlush(getHand())))
            {
                if(player.getHand().cardValue() > getHand().cardValue())
                {
                    System.out.println("You Win!");
                    System.out.println("You Have a Royal Flush and the High Card!");
                    Thread.sleep(100);
                    System.out.println(toString());
                    player.addBankroll(table.getPot());
                    break;
                }

                if(player.getHand().cardValue() < getHand().cardValue())
                {
                    System.out.println("You Lose.");
                    System.out.println("Dealer has a Royal Flush and the High Card.");
                    Thread.sleep(100);
                    System.out.println(toString());
                    Thread.sleep(100);
                    break;
                }

                if(player.getHand().cardValue() < getHand().cardValue())
                {
                    System.out.println("You Pushed.");
                    Thread.sleep(100);
                    System.out.println(toString());
                    player.addBankroll(table.getPot() / 2);
                    Thread.sleep(100);
                    break;
                }
            } 

            if(table.getHand().straightFlush(player.getHand()) && !(table.getHand().straightFlush(getHand())))
            {
                System.out.println("You Win!");
                System.out.println("You Have a Straight Flush!");
                Thread.sleep(100);
                System.out.println(toString());
                player.addBankroll(table.getPot());
                break;
            }
            if (!table.getHand().straightFlush(player.getHand()) && (table.getHand().straightFlush(getHand())))
            {
                System.out.println("You Lose.");
                System.out.println("Dealer has a Straight Flush.");
                Thread.sleep(100);
                System.out.println(toString());
                Thread.sleep(100);
                break;
            }

            if(table.getHand().straightFlush(player.getHand()) && (table.getHand().straightFlush(getHand())))
            {
                if(player.getHand().cardValue() > getHand().cardValue())
                {
                    System.out.println("You Win!");
                    System.out.println("You Have a Straight Flush and the High Card!");
                    Thread.sleep(100);
                    System.out.println(toString());
                    player.addBankroll(table.getPot());
                    break;
                }

                if(player.getHand().cardValue() < getHand().cardValue())
                {
                    System.out.println("You Lose.");
                    System.out.println("Dealer has a Straight Flush and the High Card.");
                    Thread.sleep(100);
                    System.out.println(toString());
                    Thread.sleep(100);
                    break;
                }

                if(player.getHand().cardValue() < getHand().cardValue())
                {
                    System.out.println("You Pushed.");
                    Thread.sleep(100);
                    System.out.println(toString());
                    player.addBankroll(table.getPot() / 2);
                    Thread.sleep(100);
                    break;
                }
            } 

            if(table.getHand().fourOfAKind(player.getHand()) && !(table.getHand().fourOfAKind(getHand())))
            {
                System.out.println("You Win!");
                System.out.println("You Have a Four Of A Kind!");
                Thread.sleep(100);
                System.out.println(toString());
                player.addBankroll(table.getPot());
                break;
            }
            if (!table.getHand().fourOfAKind(player.getHand()) && (table.getHand().fourOfAKind(getHand())))
            {
                System.out.println("You Lose.");
                System.out.println("Dealer has a Four of a Kind.");
                Thread.sleep(100);
                System.out.println(toString());
                Thread.sleep(100);
                break;
            }

            if(table.getHand().fourOfAKind(player.getHand()) && (table.getHand().fourOfAKind(getHand())))
            {
                if(player.getHand().cardValue() > getHand().cardValue())
                {
                    System.out.println("You Win!");
                    System.out.println("You Have a Four of a Kind and the High Card!");
                    Thread.sleep(100);
                    System.out.println(toString());
                    player.addBankroll(table.getPot());
                    break;
                }

                if(player.getHand().cardValue() < getHand().cardValue())
                {
                    System.out.println("You Lose.");
                    System.out.println("Dealer has a Four of a Kind and the High Card.");
                    Thread.sleep(100);
                    System.out.println(toString());
                    Thread.sleep(100);
                    break;
                }

                if(player.getHand().cardValue() < getHand().cardValue())
                {
                    System.out.println("You Pushed.");
                    Thread.sleep(100);
                    System.out.println(toString());
                    player.addBankroll(table.getPot() / 2);
                    Thread.sleep(100);
                    break;
                }
            } 

            if(table.getHand().fullHouse(player.getHand()) && !(table.getHand().fullHouse(getHand())))
            {
                System.out.println("You Win!");
                System.out.println("You Have a Full House!");
                Thread.sleep(100);
                System.out.println(toString());
                player.addBankroll(table.getPot());
                break;
            }
            if(!table.getHand().fullHouse(player.getHand()) && (table.getHand().fullHouse(getHand())))
            {
                System.out.println("You Lose.");
                System.out.println("Dealer has a Full House.");
                Thread.sleep(100);
                System.out.println(toString());
                Thread.sleep(100);
                break;
            }

            if(table.getHand().fullHouse(player.getHand()) && (table.getHand().fullHouse(getHand())))
            {
                if(player.getHand().cardValue() > getHand().cardValue())
                {
                    System.out.println("You Win!");
                    System.out.println("You Have a Full House and the High Card!");
                    Thread.sleep(100);
                    System.out.println(toString());
                    player.addBankroll(table.getPot());
                    break;
                }

                if(player.getHand().cardValue() < getHand().cardValue())
                {
                    System.out.println("You Lose.");
                    System.out.println("Dealer has a Full House and the High Card.");
                    Thread.sleep(100);
                    System.out.println(toString());
                    Thread.sleep(100);
                    break;
                }

                if(player.getHand().cardValue() < getHand().cardValue())
                {
                    System.out.println("You Pushed.");
                    Thread.sleep(100);
                    System.out.println(toString());
                    player.addBankroll(table.getPot() / 2);
                    Thread.sleep(100);
                    break;
                }
            } 

            if(table.getHand().flush(player.getHand()) && (!table.getHand().flush(getHand())))
            {
                System.out.println("You Win!");
                System.out.println("You Have a Flush!");
                Thread.sleep(100);
                System.out.println(toString());
                player.addBankroll(table.getPot());
                break;
            }
            if(!table.getHand().flush(player.getHand()) && (table.getHand().flush(getHand())))
            {
                System.out.println("You Lose.");
                System.out.println("Dealer has a Flush.");
                Thread.sleep(100);
                System.out.println(toString());
                Thread.sleep(100);
                break;
            }

            if(table.getHand().flush(player.getHand()) && (table.getHand().flush(getHand())))
            {
                if(player.getHand().cardValue() > getHand().cardValue())
                {
                    System.out.println("You Win!");
                    System.out.println("You Have a Flush and the High Card!");
                    Thread.sleep(100);
                    System.out.println(toString());
                    player.addBankroll(table.getPot());
                    break;
                }

                if(player.getHand().cardValue() < getHand().cardValue())
                {
                    System.out.println("You Lose.");
                    System.out.println("Dealer has a Flush and the High Card.");
                    Thread.sleep(100);
                    System.out.println(toString());
                    Thread.sleep(100);
                    break;
                }

                if(player.getHand().cardValue() < getHand().cardValue())
                {
                    System.out.println("You Pushed.");
                    Thread.sleep(100);
                    System.out.println(toString());
                    player.addBankroll(table.getPot() / 2);
                    Thread.sleep(100);
                    break;
                }
            } 

            
            if(table.getHand().straightCheck(player.getHand()) && (!table.getHand().straightCheck(getHand())))
            {
                System.out.println("You Win!");
                System.out.println("You Have a Straight!");
                Thread.sleep(100);
                System.out.println(toString());
                player.addBankroll(table.getPot());
                break;
            }
            if(!table.getHand().straightCheck(player.getHand()) && (table.getHand().straightCheck(getHand())))
            {
                System.out.println("You Lose.");
                System.out.println("Dealer has a Straight.");
                Thread.sleep(100);
                System.out.println(toString());
                Thread.sleep(100);
                break;
            }

            if(table.getHand().straightCheck(player.getHand()) && (table.getHand().straightCheck(getHand())))
            {
                if(player.getHand().cardValue() > getHand().cardValue())
                {
                    System.out.println("You Win!");
                    System.out.println("You Have a Straight and the High Card!");
                    Thread.sleep(100);
                    System.out.println(toString());
                    player.addBankroll(table.getPot());
                    break;
                }

                if(player.getHand().cardValue() < getHand().cardValue())
                {
                    System.out.println("You Lose.");
                    System.out.println("Dealer has a Straight and the High Card.");
                    Thread.sleep(100);
                    System.out.println(toString());
                    Thread.sleep(100);
                    break;
                }

                if(player.getHand().cardValue() < getHand().cardValue())
                {
                    System.out.println("You Pushed.");
                    Thread.sleep(100);
                    System.out.println(toString());
                    player.addBankroll(table.getPot() / 2);
                    Thread.sleep(100);
                    break;
                }
            } 

            if(player.getHand().threeOfAKind(table.getHand()) && (!getHand().threeOfAKind(table.getHand())))
            {
                System.out.println("You Win!");
                System.out.println("You Have a Three of a Kind!");
                Thread.sleep(100);
                System.out.println(toString());
                player.addBankroll(table.getPot());
                break;
            }

            if(!player.getHand().threeOfAKind(table.getHand()) && (getHand().threeOfAKind(table.getHand()))) 
            {
                System.out.println("You Lose.");
                System.out.println("Dealer has Three of a Kind.");
                Thread.sleep(100);
                System.out.println(toString());
                Thread.sleep(100);
                break; 
            }

            if(player.getHand().threeOfAKind(table.getHand()) && (getHand().threeOfAKind(table.getHand())))
            {
                if(player.getHand().cardValue() > getHand().cardValue())
                {
                    System.out.println("You Win!");
                    System.out.println("You Have a Three of a Kind and the High Card!");
                    Thread.sleep(100);
                    System.out.println(toString());
                    player.addBankroll(table.getPot());
                    break;
                }

                if(player.getHand().cardValue() < getHand().cardValue())
                {
                    System.out.println("You Lose.");
                    System.out.println("Dealer has a Three of a Kind the High Card.");
                    Thread.sleep(100);
                    System.out.println(toString());
                    Thread.sleep(100);
                    break;
                }

                if(player.getHand().cardValue() < getHand().cardValue())
                {
                    System.out.println("You Pushed.");
                    Thread.sleep(100);
                    System.out.println(toString());
                    player.addBankroll(table.getPot() / 2);
                    Thread.sleep(100);
                    break;
                }
            } 

            if(player.getHand().twoPair(table.getHand()) && (!getHand().twoPair(table.getHand())))
            {
                System.out.println("You Win!");
                System.out.println("You Have a Two Pair!");
                Thread.sleep(100);
                System.out.println(toString());
                player.addBankroll(table.getPot());
                break;
            }

            if(!player.getHand().twoPair(table.getHand()) && (getHand().twoPair(table.getHand()))) 
            {
                System.out.println("You Lose.");
                System.out.println("Dealer has a Two Pair.");
                Thread.sleep(100);
                System.out.println(toString());
                Thread.sleep(100);
                break;
            }

            if(player.getHand().twoPair(table.getHand()) && (getHand().twoPair(table.getHand())))
            {
                if(player.getHand().cardValue() > getHand().cardValue())
                {
                    System.out.println("You Win!");
                    System.out.println("You Have a Two Pair and the High Card!");
                    Thread.sleep(100);
                    System.out.println(toString());
                    player.addBankroll(table.getPot());
                    break;
                }

                if(player.getHand().cardValue() < getHand().cardValue())
                {
                    System.out.println("You Lose.");
                    System.out.println("Dealer has a two pair and the High Card.");
                    Thread.sleep(100);
                    System.out.println(toString());
                    Thread.sleep(100);
                    break;
                }

                if(player.getHand().cardValue() < getHand().cardValue())
                {
                    System.out.println("You Pushed.");
                    Thread.sleep(100);
                    System.out.println(toString());
                    player.addBankroll(table.getPot() / 2);
                    Thread.sleep(100);
                    break;
                }
            }

            if(table.getHand().pair() && !player.getHand().pair1(table.getHand()) && !player.getHand().pair() && !getHand().pair() && (!getHand().pair1(table.getHand())))
            {
                if(player.getHand().cardValue() > getHand().cardValue())
                {
                    System.out.println("You Win!");
                    System.out.println("You Have a Pair and the High Card!");
                    Thread.sleep(100);
                    System.out.println(toString());
                    player.addBankroll(table.getPot());
                    break;
                }

                if(player.getHand().cardValue() < getHand().cardValue())
                {
                    System.out.println("You Lose.");
                    System.out.println("Dealer has the High Card.");
                    Thread.sleep(100);
                    System.out.println(toString());
                    Thread.sleep(100);
                    break;
                }

                if(player.getHand().cardValue() < getHand().cardValue())
                {
                    System.out.println("You Pushed.");
                    Thread.sleep(100);
                    System.out.println(toString());
                    player.addBankroll(table.getPot() / 2);
                    Thread.sleep(100);
                    break;
                }
            }

            if(player.getHand().pair1(table.getHand()) && (!getHand().pair1(table.getHand())))
            {
                System.out.println("You Win!");
                System.out.println("You Have a Pair!");
                Thread.sleep(100);
                System.out.println(toString());
                player.addBankroll(table.getPot());
                break;
            }

            if(!player.getHand().pair1(table.getHand()) && (getHand().pair1(table.getHand()))) 
            {
                System.out.println("You Lose.");
                System.out.println("Dealer has a Pair.");
                Thread.sleep(100);
                System.out.println(toString());
                Thread.sleep(100);
                break;
            }

            if(player.getHand().pair1(table.getHand()) || player.getHand().pair() && (getHand().pair1(table.getHand())))
            {
                if(player.getHand().cardValue() > getHand().cardValue())
                {
                    System.out.println("You Win!");
                    System.out.println("You Have a Pair and the High Card!");
                    Thread.sleep(100);
                    System.out.println(toString());
                    player.addBankroll(table.getPot());
                    break;
                }

                if(player.getHand().cardValue() < getHand().cardValue())
                {
                    System.out.println("You Lose.");
                    System.out.println("Dealer has a Pair and the High Card.");
                    Thread.sleep(100);
                    System.out.println(toString());
                    Thread.sleep(100);
                    break;
                }

                if(player.getHand().cardValue() < getHand().cardValue())
                {
                    System.out.println("You Pushed.");
                    Thread.sleep(100);
                    System.out.println(toString());
                    player.addBankroll(table.getPot() / 2);
                    Thread.sleep(100);
                    break;
                }
            }

        }

        /** if(player.getHand().cardValue() == table.getHand().cardValue() && getHand().cardValue() == table.getHand().cardValue())
        {
        if(player.getHand().getHandValue() > getHand().getHandValue())
        {
        System.out.println("You Win!");
        Thread.sleep(100);
        System.out.println(toString());
        player.addBankroll(table.getPot());
        Thread.sleep(100);

        }
        else
        {
        System.out.println("You Lose.");
        Thread.sleep(100);
        System.out.println(toString());
        Thread.sleep(100);

        }

        } **/

    }

    public Hand getHand()
    {
        return hand;
    }

    public Card drawCard()
    {
        return shoe.drawCard();
    }

    public void hit(Card c)
    {
        hand.addCard(c);
    }

    public void shuffle()
    {
        shoe = new Shoe();
    }

    public void clearHand()
    {
        hand.clearHand();
    }

    public String toString()
    {
        return "The Dealer has: \n" + getHand().toString();
    } 
}
