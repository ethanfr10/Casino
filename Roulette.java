import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.util.InputMismatchException;

public class Roulette
{

    public void turn() throws InterruptedException
    {
        String name; 
        int bankroll = 1000;
        int choice;
        int count;
        int tempBet;
        int tempNum;
        int random = 0;
        int randomC = 0;
        String randomCo;
        boolean again = true;
        //boolean a = true;
        int counter = 0;
        boolean betGood;
        ArrayList<Integer> totalBets = new ArrayList<Integer>();
        ArrayList<Integer> totalNum = new ArrayList<Integer>();
        ArrayList<Integer> totalColor = new ArrayList<Integer>();
        ArrayList<Integer> totalColorBet = new ArrayList<Integer>();

        ArrayList<String> ColorC = new ArrayList<String>();
        //int[] totalBets = new int[10];
        // int[] totalNum = new int[10];
        boolean numAgain = true;
        String tempColor;
        boolean makeBets =true;
        boolean contBets = true;
        boolean aa = true;

        boolean works1 = true;
        boolean works2 = true;
        boolean works3 = true;
        boolean works4 = true;
        boolean works5 = true;
        boolean works6 = true;
        boolean works7 = true;
        boolean works8 = true;
        boolean works9 = true;
        boolean works10 = true;

        Scanner a = new Scanner(System.in);

        System.out.println("Welcome to Roulette! What is your name?");
        name = a.nextLine();
        System.out.println(name + ",\n\t-Welcome!!-\nYou have $1000 to play with!");
        while(again == true && bankroll>0){
            contBets = true;
            works1 = true;
            works2 = true;
            works3 = true;works4 = true;works5 = true;works6 = true;works7 = true;works8 = true;works9 = true;works10 = true;

            choice = 0;
            count = 0;
            aa = true;
            tempBet = 0;
            totalBets.clear();
            totalNum.clear();
            totalColor.clear();
            totalColorBet.clear();
            ColorC.clear();
            numAgain = true;
            again = true;
            makeBets = true;
            tempColor = "";
            random = 0;
            randomC = 0;
            randomCo="";

            choice = 0;
            betGood = true;
            while (contBets&&bankroll>0){
                numAgain = true;
                if(bankroll > 0){
                    //while(works1){
                    try{
                        choice =0;
                        System.out.println("Would you like to bet on a number(1) or a color(2)");
                        choice = a.nextInt();
                        works1 = false;
                    }
                    catch(Exception e){
                        System.out.println("Please enter in either 1 or 2!");

                    }
                    //}
                }

                System.out.println("\nCHOICE: " + choice);
                System.out.println("BANKROLL: " + bankroll);
                //System.out.println("numAgain: " + numAgain);

                if(choice == 1 && bankroll > 0){
                    random = (int)(Math.random()*37)+1; 
                    //random = 12;

                    while(numAgain ==true &&bankroll>0){
                        System.out.println("What number would you like to choose?(0-36)\nPayout - [1 to 35]");
                        tempNum = a.nextInt();
                        totalNum.add(tempNum);
                        while(betGood){
                            System.out.println("How much would you like to bet on " + tempNum+"?");

                            tempBet = a.nextInt();
                            if(bankroll - tempBet >= 0 && tempBet >0){
                                totalBets.add(tempBet);
                                betGood = false;
                            }
                            else{
                                System.out.println("Please enter a valid number!");
                                betGood = true;
                            }
                        }
                        betGood = true;
                        bankroll-=tempBet;
                        System.out.println("Would you like to choose another number?(True/False)");
                        numAgain = a.nextBoolean();
                        if(numAgain == true && bankroll ==0){
                            System.out.println("Sorry you do not have the money :(");
                            numAgain = false;
                            aa = true;
                        }

                        if(numAgain==false && aa == false){

                            System.out.println("Would you like to make any more bets?(True/False)");
                            again = a.nextBoolean();
                            contBets = again;
                            if(again == true && bankroll ==0){
                                System.out.println("Sorry you do not have the money :(");
                            }
                        }
                        tempNum = 0;
                        tempBet = 0;
                    }
                }
                if(choice == 2){
                    randomC = (int)(Math.random()*2)+1;
                    if(randomC ==1){
                        randomCo = "Red";
                    }
                    if(randomC == 2){
                        randomCo = "Black";
                    }
                    numAgain = true;
                    while(numAgain==true && bankroll >0){
                        tempBet = 0;
                        a.nextLine();
                        System.out.println("What color would you like to choose? Red or Black?");
                        tempColor = a.nextLine();
                        while(betGood == true){
                            System.out.println("How much would like to bet on " + tempColor+"?");

                            tempBet = a.nextInt();
                            if(bankroll - tempBet >=0){
                                bankroll -= tempBet;
                                totalColorBet.add(tempBet);
                                betGood = false;
                            }
                            else{
                                System.out.println("Please enter a valid number!");
                            }
                        }
                        betGood = true;     
                        if(tempColor.equalsIgnoreCase("Red")){
                            ColorC.add("Red");
                        }
                        if(tempColor.equalsIgnoreCase("Black")){
                            ColorC.add("Black");
                        }

                        System.out.println("Would you like to choose another color?(True/False)");
                        numAgain = a.nextBoolean();
                        if(numAgain == true && bankroll ==0){
                            System.out.println("Sorry you do not have the money :(");
                        }
                        if(numAgain==false){
                            System.out.println("Would you like to make any more bets?(True/False)");
                            makeBets = a.nextBoolean();
                            contBets = makeBets;
                            if(makeBets == true && bankroll ==0){
                                System.out.println("Sorry you do not have the money :(");
                            }
                        }
                    }
                }
            }
            Thread.sleep(1000);
            System.out.print("Rolling");
            for(int i = 0; i<3;i++){
                System.out.print(".");
                Thread.sleep(500);
            }
            System.out.println();
            if(randomC ==1){
                for(int i =0; i < ColorC.size(); i++){
                    if(ColorC.get(i).equals("Red")){
                        System.out.println("-Congrats!!\tYou won with Red!!\n-You won $" + totalColorBet.get(i));
                        bankroll+=2*totalColorBet.get(i);
                    }

                }
            }
            Thread.sleep(500);
            if(randomC ==1){
                for(int i =0; i < ColorC.size(); i++){
                    if(!(ColorC.get(i).equals("Red"))){
                        System.out.println("-You lost $" + totalColorBet.get(i)+" when you bet on " + ColorC.get(i));

                    }

                }
            }
            Thread.sleep(500);
            if(randomC ==2){
                for(int i =0; i < ColorC.size(); i++){
                    if(ColorC.get(i).equals("Black")){
                        System.out.println("-Congrats!!\t-You won with Black!! -You won $" + totalColorBet.get(i));
                        bankroll+=2*totalColorBet.get(i);
                    }

                }
            }
            Thread.sleep(500);
            if(randomC ==2){
                for(int i =0; i < ColorC.size(); i++){
                    if(!(ColorC.get(i).equals("Black"))){
                        System.out.println("-You lost $" + totalColorBet.get(i) + " when you bet on " + ColorC.get(i));

                    }

                }
            }
            Thread.sleep(500);
            //NUMBER CHECKER
            for(int i = 0; i<totalNum.size();i++){
                if(random==totalNum.get(i)){
                    System.out.println("-Congrats!!\tYou won with #"+totalNum.get(i)+"!\n\t-You won $"+totalBets.get(i)*35);
                    bankroll+=35*totalBets.get(i);
                    //System.out.println("Your new bankroll is $"+bankroll);
                    System.out.println("The winning number was...\n\n"+random+"!!!\n\n");
                }
            }
            Thread.sleep(500);
            for(int i = 0; i<totalNum.size();i++){
                if(random!= totalNum.get(i)){
                    System.out.println("-You lost $" + totalBets.get(i) + " on #" + totalNum.get(i));

                    //System.out.println("Your new bankroll is $"+bankroll);
                    System.out.println("The winning number was...\n\n"+random+"!!!\n\n");
                }
            }
            Thread.sleep(500);
            again = true;
            System.out.println("Your current bankroll is $"+bankroll);
            if(bankroll>0){
                System.out.println(name + ", would you like to play again or cash out?(True/False)");
                again = a.nextBoolean();
            }
            Thread.sleep(500);
        }
        if(bankroll == 0 || again == false){
            System.out.println("Thanks for playing you finished with $" + bankroll+"!!");   
        }
    }

}

