import java.util.ArrayList;
import java.lang.Object;
import java.lang.Math;
public class Deck
{
    //Instance Variable - an ArrayList of cards
    
    private ArrayList<Card> deck;
    
   //Ace 2 3 4 .. King of Spades
   //Ace 2 3 4 .. King of Diamonds
   //King Queen .. Ace of Clubs
   //King Queen .. Ace of Hearts
   
   //52 instances of the Card Class
   
   //Constructor()
   public Deck()
   {
       deck = new ArrayList<Card>();
       for(int i = 0; i < 2; i++)
       {
           for(int j = 1; j <= 13; j++)
           {
               deck.add(new Card(i, j));
           }
       }
       for(int i = 2; i < 4; i++)
       {
           for(int j = 13; j > 0; j--)
           {
               deck.add(new Card(i, j));
           }
       }
   }
   
   public ArrayList<Card> getDeck()
   {
       return deck;
   }
   
   public Card drawCard()
   {
       return deck.remove(0);
   }
   
   public void Shuffle()
   {
       ArrayList<Card> a = new ArrayList<Card>();
       ArrayList<Card> b = new ArrayList<Card>();
        
        for(Card d: deck)
        {
            b.add(d);
        }
        while(b.size() > 0)
        {
            int c = (int)(Math.random()*b.size());
            a.add(b.remove(c));
        }
        deck = a;
   }
   
   public String toString()
   {
        String a = "";
           for(Card b : deck)
           {
               a += b.toString() + "\n";
           }
           return a; 
   }
   
   
   //toString() should print entire deck
   
   //save shuffle for later
}
