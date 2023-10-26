import java.util.ArrayList;
public class Shoe
{
    private ArrayList<Card> shoe;
    
    public Shoe()
    {
        Deck d = new Deck();
        shoe = new ArrayList<Card>();
        
        for(int i = 0; i < 2; i++)
        {
        for(Card c : d.getDeck())
        {
            shoe.add(c);
        }
        }
        
        Shuffle();
    }
    
    //size method
    public int getSize()
    {
        return shoe.size();
    }
    
    //getShoe method
    public ArrayList<Card> getShoe()
    {
        return shoe;
    }
    
    //drawCard method
    public Card drawCard()
    {
        return shoe.remove(0);
    }
    
    public void Shuffle()
   {
       ArrayList<Card> a = new ArrayList<Card>();
       ArrayList<Card> b = new ArrayList<Card>();
        
        for(Card d: shoe)
        {
            b.add(d);
        }
        while(b.size() > 0)
        {
            int c = (int)(Math.random()*b.size());
            a.add(b.remove(c));
        }
        shoe = a;
   }
    
    //toString
    public String toString()
    {
        String a = "";
           for(Card b : shoe)
           {
               a += b.toString() + "\n";
           }
           return a;
    }
     
}
