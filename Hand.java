import java.util.ArrayList;
public class Hand
{
    private ArrayList<Card> hand;
    public Hand()
    {
        hand = new ArrayList<Card>();
    }

    public void addCard(Card h)
    {
        hand.add(h);
    }

    public boolean checkBust()
    {
        if(getHandValue() > 21)
        {
            return true;
        }
        return false;
    }

    public boolean isBlackjack()
    {
        for(int i = 0; i < 1; i++)
        {
            if(hand.get(i).getValue() + hand.get(i+1).getValue() == 21)
            {
                return true;
            }
        }
        return false;
    }

    public int getHandValue()
    {
        Card a;
        int value = 0;
        for(int i = 0; i < hand.size(); i++)
        {
            a = hand.get(i);
            value += a.getValue();
        }

        if(value > 21)
        {
            if(ace() == true)
            {
                value = getHandValue();
            }
        }
        return value;

    }

    public int cardValue()
    {
        int one = 0;
        int two = 0;
        Card a;
        Card b;
        int value = 0;
        for(int i = 0; i < hand.size(); i++)
        {
            a = hand.get(0);
            one = a.getValue();
            b = hand.get(1);
            two = b.getValue();
        }
        if(one > two)
        {
            return one;
        }
        if(two > one)
        {
            return two;
        }
        else
        {
            return two;
        }

    }

    public boolean tablePair()
    {
        int one = 0;
        int two = 0;
        int three = 0;
        int four = 0;
        int five = 0;
        Card a;
        Card b;
        Card c;
        Card d;
        Card e;

        a = hand.get(0);
        one = a.getRank();
        b = hand.get(1);
        two = b.getRank();
        c = hand.get(2);
        three = c.getRank();
        d = hand.get(3);
        four = d.getRank();
        e = hand.get(4);
        five = e.getRank();

        if(one == two || one == three || one == four || one == five)
        {
            return true;
        }
        if(two == three|| two == four || two == five)
        {
            return true;
        }
        if(three == four|| three == five)
        {
            return true;
        }
        if(four == five)
        {
            return true;
        }

        return false;
    }

    public boolean tableThreeOfAKind()
    {
        int one = 0;
        int two = 0;
        int three = 0;
        int four = 0;
        int five = 0;
        Card a;
        Card b;
        Card c;
        Card d;
        Card e;

        a = hand.get(0);
        one = a.getRank();
        b = hand.get(1);
        two = b.getRank();
        c = hand.get(2);
        three = c.getRank();
        d = hand.get(3);
        four = d.getRank();
        e = hand.get(4);
        five = e.getRank();

        if(one == two && one == three || one == two && one == four || one == two && one == five)
        {
            return true;
        }
        if(two == three && two == four || two == three && two == five)
        {
            return true;
        }
        if(three == four && three == five)
        {
            return true;
        }

        return false;
    }

    public int tablePairValue()
    {
        int one = 0;
        int two = 0;
        int three = 0;
        int four = 0;
        int five = 0;
        int six = 0;
        Card a;
        Card b;
        Card c;
        Card d;
        Card e;

        a = hand.get(0);
        one = a.getRank();
        b = hand.get(1);
        two = b.getRank();
        c = hand.get(2);
        three = c.getRank();
        d = hand.get(3);
        four = d.getRank();
        e = hand.get(4);
        five = e.getRank();

        if(one == two) 
        {
            return one;
        }
        if(one == three)
        {
            return one;
        }
        if(one == four)
        {
            return one;
        }
        if(one == five)
        {
            return one;
        }
        if(two == three)
        {
            return two;
        }
        if(two == four)
        {
            return two;
        }
        if(two == five)
        {
            return two;
        }
        if(three == four)
        {
            return three;
        }
        if(three == five)
        {
            return three;
        }
        if(four == five)
        {
            return four;
        }
        else
        {
            return -1;
        }
    }

    public boolean straightCheck(Hand z)
    {
        int one = 0;
        int two = 0;
        int three = 0;
        int four = 0;
        int five = 0;
        int six = 0;
        int seven = 0;
        Card a;
        Card b;
        Card c;
        Card d;
        Card e;
        Card f;
        Card g;
        a = hand.get(0);
        one = a.getRank();
        b = hand.get(1);
        two = b.getRank();
        c = hand.get(2);
        three = c.getRank();
        d = hand.get(3);
        four = d.getRank();
        e = hand.get(4);
        five = e.getRank();

        for(int i = 0; i < z.getHand().size(); i++)
        {
            f = z.getHand().get(0);
            six = f.getRank();
            g = z.getHand().get(1);
            seven = g.getRank();
        }
        if(one + 1 == two && two + 1 == three && three + 1 == four && four + 1 == five)
        {
            return true;
        }
        if(six + 1 == two && two + 1 == three && three + 1 == four && four + 1 == five)
        {
            return true;
        }
        if(one + 1 == six && six + 1 == three && three + 1 == four && four + 1 == five)
        {
            return true;
        }
        if(one + 1 == two && two + 1 == six && six + 1 == four && four + 1 == five)
        {
            return true;
        }
        if(one + 1 == two && two + 1 == three && three + 1 == six && six + 1 == five)
        {
            return true;
        }
        if(one + 1 == two && two + 1 == three && three + 1 == four && four + 1 == six)
        {
            return true;
        }
        if(seven + 1 == two && two + 1 == three && three + 1 == four && four + 1 == five)
        {
            return true;
        }
        if(one + 1 == seven && seven + 1 == three && three + 1 == four && four + 1 == five)
        {
            return true;
        }
        if(one + 1 == two && two + 1 == seven && seven + 1 == four && four + 1 == five)
        {
            return true;
        }
        if(one + 1 == two && two + 1 == three && three + 1 == seven && seven + 1 == five)
        {
            return true;
        }
        if(one + 1 == two && two + 1 == three && three + 1 == four && four + 1 == seven)
        {
            return true;
        }
        if(six + 1 == seven && seven + 1 == three && three + 1 == four && four + 1 == five)
        {
            return true;
        }
        if(six + 1 == two && two + 1 == seven && seven + 1 == four && four + 1 == five)
        {
            return true;
        }
        if(six + 1 == two && two + 1 == three && three + 1 == seven && seven + 1 == five)
        {
            return true;
        }
        if(six + 1 == two && two + 1 == three && three + 1 == four && four + 1 == seven)
        {
            return true;
        }
        if(one + 1 == six && six + 1 == seven && seven + 1 == four && four + 1 == five)
        {
            return true;
        }
        if(one + 1 == six && six + 1 == three && three + 1 == seven && seven + 1 == five)
        {
            return true;
        }
        if(one + 1 == six && six + 1 == three && three + 1 == four && four + 1 == seven)
        {
            return true;
        }
        if(one + 1 == two && two + 1 == six && six + 1 == seven && seven + 1 == five)
        {
            return true;
        }
        if(one + 1 == two && two + 1 == six && six + 1 == four && four + 1 == seven)
        {
            return true;
        }
        if(one + 1 == two && two + 1 == three && three + 1 == six && six + 1 == seven)
        {
            return true;
        }

        if(seven + 1 == six && six + 1 == three && three + 1 == four && four + 1 == five)
        {
            return true;
        }
        if(seven + 1 == two && two + 1 == six && six + 1 == four && four + 1 == five)
        {
            return true;
        }
        if(seven + 1 == two && two + 1 == three && three + 1 == six && six + 1 == five)
        {
            return true;
        }
        if(seven + 1 == two && two + 1 == three && three + 1 == four && four + 1 == six)
        {
            return true;
        }
        if(one + 1 == seven && seven + 1 == six && six + 1 == four && four + 1 == five)
        {
            return true;
        }
        if(one + 1 == seven && seven + 1 == three && three + 1 == six && six + 1 == five)
        {
            return true;
        }
        if(one + 1 == seven && seven + 1 == three && three + 1 == four && four + 1 == six)
        {
            return true;
        }
        if(one + 1 == two && two + 1 == seven && seven + 1 == six && six + 1 == five)
        {
            return true;
        }
        if(one + 1 == two && two + 1 == seven && seven + 1 == four && four + 1 == six)
        {
            return true;
        }
        if(one + 1 == two && two + 1 == three && three + 1 == seven && seven + 1 == six)
        {
            return true;
        }
        return false;
    }

    public boolean pair()
    {
        int one = 0;
        int two = 0;
        Card a;
        Card b;
        for(int i = 0; i < hand.size(); i++)
        {
            a = hand.get(0);
            one = a.getRank();
            b = hand.get(1);
            two = b.getRank();
        }
        if(one == two)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean pair1(Hand z)
    {
        int one = 0;
        int two = 0;
        int three = 0;
        int four = 0;
        int five = 0;
        int six = 0;
        int seven = 0;
        Card a;
        Card b;
        Card c;
        Card d;
        Card e;
        Card f;
        Card g;
        a = z.getHand().get(0);
        one = a.getRank();
        b = z.getHand().get(1);
        two = b.getRank();
        c = z.getHand().get(2);
        three = c.getRank();
        d = z.getHand().get(3);
        four = d.getRank();
        e = z.getHand().get(4);
        five = e.getRank();
        for(int i = 0; i < z.getHand().size(); i++)
        {
            f = hand.get(0);
            six = f.getRank();
            g = hand.get(1);
            seven = g.getRank();
        }

        if(one == six)
        {
            return true;
        }
        if(one == seven)
        {
            return true;
        }
        if(two == six)
        {
            return true;
        }
        if(two == seven)
        {
            return true;
        }
        if(three == six)
        {
            return true;
        }
        if(three == seven)
        {
            return true;
        }
        if(four == six)
        {
            return true;
        }
        if(four == seven)
        {
            return true;
        }
        if(five == six)
        {
            return true;
        }
        if(five == seven)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean twoPair(Hand a)
    {
        for(int i = 0; i < hand.size(); i++)
        {
            for(int j = 0; j < a.getHand().size(); j++)
            {
                if(hand.get(0).getRank() == a.getHand().get(j).getRank()) 
                {
                    if(hand.get(1).getRank() == a.getHand().get(j).getRank())
                    {
                        return true;
                    }
                }
                if(a.tablePair())
                {
                    if(hand.get(0).getRank() == hand.get(1).getRank())
                    {
                        return true;
                    }
                }
                if(a.tablePair() && hand.get(0).getRank() == a.getHand().get(j).getRank()) 
                {
                    return true;
                }
                if(a.tablePair() && hand.get(1).getRank() == a.getHand().get(j).getRank())
                {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean threeOfAKind(Hand a)
    {
        for(int i = 0; i < hand.size(); i++)
        {
            for(int j = 0; j < a.getHand().size(); j++)
            {
                if(pair())
                {
                    if(hand.get(0).getRank() == a.getHand().get(j).getRank())
                    {
                        return true;
                    }
                }

                if(a.tablePair())
                {
                    if(a.tablePairValue() == hand.get(0).getRank())
                    {
                        return true;
                    }
                }

                if(a.tablePair())
                {
                    if(a.tablePairValue() == hand.get(1).getRank())
                    {
                        return true;
                    }
                }

                if(a.tableThreeOfAKind())
                {
                    return true;
                }

                //if(hand.get(i).getRank() == hand.get(i+1).getRank() && hand.get(i).getRank() == a.getHand().get(j).getRank())
                //{
                //return true;
                //}

            }
        }
        return false;
    }

    public boolean flush(Hand z)
    {
        int one = 0;
        int two = 0;
        int three = 0;
        int four = 0;
        int five = 0;
        int six = 0;
        int seven = 0;
        Card a;
        Card b;
        Card c;
        Card d;
        Card e;
        Card f;
        Card g;
        a = hand.get(0);
        one = a.getRank();
        b = hand.get(1);
        two = b.getRank();
        c = hand.get(2);
        three = c.getRank();
        d = hand.get(3);
        four = d.getRank();
        e = hand.get(4);
        five = e.getRank();

        for(int i = 0; i < z.getHand().size(); i++)
        {
            f = z.getHand().get(0);
            six = f.getRank();
            g = z.getHand().get(1);
            seven = g.getRank();
        }
        if(one == two && one == three && one == four && one == five)
        {
            return true;
        }
        if(one == two && one == three && one == four && one == six)
        {
            return true;
        }
        if(one == two && one == three && one == four && one == seven)
        {
            return true;
        }
        if(one == two && one == three && one == five && one == six)
        {
            return true;
        }
        if(one == two && one == three && one == five && one == seven)
        {
            return true;
        }
        if(one == two && one == four && one == five && one == six)
        {
            return true;
        }
        if(one == two && one == four && one == five && one == seven)
        {
            return true;
        }
        if(one == three && one == four && one == five && one == six)
        {
            return true;
        }
        if(one == three && one == four && one == five && one == seven)
        {
            return true;
        }
        if(two == three && two == four && two == five && two == six)
        {
            return true;
        }
        if(two == three && two == four && two == five && two == seven)
        {
            return true;
        }
        if(three == four && three == five && three == six && three == seven)
        {
            return true;
        }

        return false;
    }

    public boolean fourOfAKind(Hand z)
    {
        int one = 0;
        int two = 0;
        int three = 0;
        int four = 0;
        int five = 0;
        int six = 0;
        int seven = 0;
        Card a;
        Card b;
        Card c;
        Card d;
        Card e;
        Card f;
        Card g;

        for(int i = 0; i < hand.size(); i++)
        {
            a = hand.get(0);
            one = a.getRank();
            b = hand.get(1);
            two = b.getRank();
            c = hand.get(2);
            three = c.getRank();
            d = hand.get(3);
            four = d.getRank();
            e = hand.get(4);
            five = e.getRank();
        }
        for(int i = 0; i < z.getHand().size(); i++)
        {
            f = z.getHand().get(0);
            six = f.getRank();
            g = z.getHand().get(1);
            seven = g.getRank();
        }

        if(one == two && one == three && one == four)
        {
            return true;
        }
        if(one == two && one == three && one == five)
        {
            return true;
        }
        if(one == two && one == three && one == six)
        {
            return true;
        }
        if(one == two && one == three && one == seven)
        {
            return true;
        }
        if(one == two && one == four && one == five)
        {
            return true;
        }
        if(one == two && one == four && one == six)
        {
            return true;
        }
        if(one == two && one == four && one == seven)
        {
            return true;
        }
        if(one == two && one == five && one == six)
        {
            return true;
        }
        if(one == two && one == five && one == seven)
        {
            return true;
        }
        if(one == two && one == six && one == seven)
        {
            return true;
        }
        if(one == three && one == four && one == five)
        {
            return true;
        }
        if(one == three && one == four && one == six)
        {
            return true;
        }
        if(one == three && one == four && one == seven)
        {
            return true;
        }
        if(one == three && one == five && one == six)
        {
            return true;
        }
        if(one == three && one == five && one == seven)
        {
            return true;
        }
        if(one == three && one == six && one == seven)
        {
            return true;
        }
        if(one == four && one == five && one == six)
        {
            return true;
        }
        if(one == four && one == five && one == seven)
        {
            return true;
        }
        if(one == four && one == six && one == seven)
        {
            return true;
        }
        if(one == five && one == six && one == seven)
        {
            return true;
        }

        if(two == three && two == four && two == five)
        {
            return true;
        }
        if(two == three && two == four && two == six)
        {
            return true;
        }
        if(two == three && two == four && two == seven)
        {
            return true;
        }
        if(two == three && two == five && two == six)
        {
            return true;
        }
        if(two == three && two == five && two == seven)
        {
            return true;
        }
        if(two == three && two == six && two == seven)
        {
            return true;
        }
        if(two == four && two == five && two == six)
        {
            return true;
        }
        if(two == four && two == five && two == seven)
        {
            return true;
        }
        if(two == four && two == six && two == seven)
        {
            return true;
        }
        if(two == five && two == six && two == seven)
        {
            return true;
        }

        if(three == four && three == five && three == six)
        {
            return true;
        }
        if(three == four && three == five && three == seven)
        {
            return true;
        }
        if(three == four && three == six && three == seven)
        {
            return true;
        }
        if(three == five && three == six && three == seven)
        {
            return true;
        }

        if(four == five && four == six && four == seven)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean fullHouse(Hand z)
    {
        int one = 0;
        int two = 0;
        int three = 0;
        int four = 0;
        int five = 0;
        int six = 0;
        int seven = 0;
        int num1 = 0;
        int num2 = 0;

        Card a;
        Card b;
        Card c;
        Card d;
        Card e;
        Card f;
        Card g;

        a = hand.get(0);
        one = a.getRank();
        b = hand.get(1);
        two = b.getRank();
        c = hand.get(2);
        three = c.getRank();
        d = hand.get(3);
        four = d.getRank();
        e = hand.get(4);
        five = e.getRank();
        for(int i = 0; i < z.getHand().size(); i++)
        {
            f = z.getHand().get(0);
            six = f.getRank();
            g = z.getHand().get(1);
            seven = g.getRank();
        }

        if(one == two && one == three && four == five)
        {
            return true;
        }
        if(one == two && one == three && four == six)
        {
            return true;
        }
        if(one == two && one == three && four == seven)
        {
            return true;
        }
        if(one == two && one == three && five == six)
        {
            return true;
        }
        if(one == two && one == three && five == seven)
        {
            return true;
        }
        if(one == two && one == three && six == seven)
        {
            return true;
        }
        if(one == two && one == four && three == five)
        {
            return true;
        }
        if(one == two && one == four && three == six)
        {
            return true;
        }
        if(one == two && one == four && five == seven)
        {
            return true;
        }
        if(one == two && one == four && five == six)
        {
            return true;
        }
        if(one == two && one == four && five == seven)
        {
            return true;
        }
        if(one == two && one == four && six == seven)
        {
            return true;
        }
        if(one == two && one == five && three == four)
        {
            return true;
        }
        if(one == two && one == five && three == six)
        {
            return true;
        }
        if(one == two && one == five && three == seven)
        {
            return true;
        }
        if(one == two && one == five && four == six)
        {
            return true;
        }
        if(one == two && one == five && four == seven)
        {
            return true;
        }
        if(one == two && one == five && six == seven)
        {
            return true;
        }
        if(one == two && one == six && three == four)
        {
            return true;
        }
        if(one == two && one == six && three == five)
        {
            return true;
        }
        if(one == two && one == six && three == seven)
        {
            return true;
        }
        if(one == two && one == six && four == five)
        {
            return true;
        }
        if(one == two && one == six && four == seven)
        {
            return true;
        }
        if(one == two && one == six && five == seven)
        {
            return true;
        }
        if(one == two && one == seven && three == four)
        {
            return true;
        }
        if(one == two && one == seven && three == five)
        {
            return true;
        }
        if(one == two && one == seven && three == six)
        {
            return true;
        }
        if(one == two && one == seven && four == five)
        {
            return true;
        }
        if(one == two && one == seven && five == six)
        {
            return true;
        }
        if(one == three && one == four && two == five)
        {
            return true;
        }
        if(one == three && one == four && two == six)
        {
            return true;
        }
        if(one == three && one == four && two == seven)
        {
            return true;
        }
        if(one == three && one == four && five == six)
        {
            return true;
        }
        if(one == three && one == four && five == seven)
        {
            return true;
        }
        if(one == three && one == four && six == seven)
        {
            return true;
        }
        if(one == three && one == five && two == four)
        {
            return true;
        }
        if(one == three && one == five && two == six)
        {
            return true;
        }
        if(one == three && one == five && two == seven)
        {
            return true;
        }
        if(one == three && one == five && four == six)
        {
            return true;
        }
        if(one == three && one == five && four == seven)
        {
            return true;
        }
        if(one == three && one == five && six == seven)
        {
            return true;
        }
        if(one == three && one == six && two == four)
        {
            return true;
        }
        if(one == three && one == six && two == five)
        {
            return true;
        }
        if(one == three && one == six && two == seven)
        {
            return true;
        }
        if(one == three && one == six && four == five)
        {
            return true;
        }
        if(one == three && one == six && four == seven)
        {
            return true;
        }
        if(one == three && one == six && five == seven)
        {
            return true;
        }
        if(one == three && one == seven && two == four)
        {
            return true;
        }
        if(one == three && one == seven && two == five)
        {
            return true;
        }
        if(one == three && one == seven && two == six)
        {
            return true;
        }
        if(one == three && one == seven && four == five)
        {
            return true;
        }
        if(one == three && one == seven && five == six)
        {
            return true;
        }
        if(one == four && one == five && two == six)
        {
            return true;
        }
        if(one == four && one == five && two == seven)
        {
            return true;
        }
        if(one == four && one == five && three == six)
        {
            return true;
        }
        if(one == four && one == five && three == seven)
        {
            return true;
        }
        if(one == four && one == five && six == seven)
        {
            return true;
        }
        if(one == four && one == six && two == four)
        {
            return true;
        }
        if(one == four && one == six && two == five)
        {
            return true;
        }
        if(one == four && one == six && two == seven)
        {
            return true;
        }
        if(one == four && one == six && three == five)
        {
            return true;
        }
        if(one == four && one == six && three == seven)
        {
            return true;
        }
        if(one == four && one == six && five == seven)
        {
            return true;
        }
        if(one == four && one == seven && two == four)
        {
            return true;
        }
        if(one == four && one == seven && two == five)
        {
            return true;
        }
        if(one == four && one == seven && two == six)
        {
            return true;
        }
        if(one == four && one == seven && three == five)
        {
            return true;
        }
        if(one == four && one == seven && five == six)
        {
            return true;
        }
        if(one == five && one == six && two == three)
        {
            return true;
        }
        if(one == five && one == six && two == four)
        {
            return true;
        }
        if(one == five && one == six && two == seven)
        {
            return true;
        }
        if(one == five && one == six && three == four)
        {
            return true;
        }
        if(one == five && one == six && three == seven)
        {
            return true;
        }
        if(one == five && one == six && four == seven)
        {
            return true;
        }
        if(one == five && one == seven && two == three)
        {
            return true;
        }
        if(one == five && one == seven && two == four)
        {
            return true;
        }
        if(one == five && one == seven && two == six)
        {
            return true;
        }
        if(one == five && one == seven && three == four)
        {
            return true;
        }
        if(one == six && one == seven && two == three)
        {
            return true;
        }
        if(one == six && one == seven && two == four)
        {
            return true;
        }
        if(one == six && one == seven && two == five)
        {
            return true;
        }

        if(two == three && two == four && one == five)
        {
            return true;
        }
        if(two == three && two == four && one == six)
        {
            return true;
        }
        if(two == three && two == four && one == seven)
        {
            return true;
        }
        if(two == three && two == four && five == six)
        {
            return true;
        }
        if(two == three && two == four && five == seven)
        {
            return true;
        }
        if(two == three && two == four && six == seven)
        {
            return true;
        }
        if(two == three && two == five && one == four)
        {
            return true;
        }
        if(two == three && two == five && one == six)
        {
            return true;
        }
        if(two == three && two == five && one == seven)
        {
            return true;
        }
        if(two == three && two == five && four == six)
        {
            return true;
        }
        if(two == three && two == five && four == seven)
        {
            return true;
        }
        if(two == three && two == five && six == seven)
        {
            return true;
        }
        if(two == three && two == six && one == four)
        {
            return true;
        }
        if(two == three && two == six && one == five)
        {
            return true;
        }
        if(two == three && two == six && one == seven)
        {
            return true;
        }
        if(two == three && two == six && four == five)
        {
            return true;
        }
        if(two == three && two == six && four == seven)
        {
            return true;
        }
        if(two == three && two == six && five == seven)
        {
            return true;
        }
        if(two == three && two == seven && one == four)
        {
            return true;
        }
        if(two == three && two == seven && one == five)
        {
            return true;
        }
        if(two == three && two == seven && two == six)
        {
            return true;
        }
        if(two == three && two == seven && four == five)
        {
            return true;
        }
        if(two == three && two == seven && five == six)
        {
            return true;
        }
        if(two == four && two == five && one == six)
        {
            return true;
        }
        if(two == four && two == five && one == seven)
        {
            return true;
        }
        if(two == four && two == five && three == six)
        {
            return true;
        }
        if(two == four && two == five && three == seven)
        {
            return true;
        }
        if(two == four && two == five && six == seven)
        {
            return true;
        }
        if(two == four && two == six && one == four)
        {
            return true;
        }
        if(two == four && two == six && one == five)
        {
            return true;
        }
        if(two == four && two == six && one == seven)
        {
            return true;
        }
        if(two == four && two == six && three == five)
        {
            return true;
        }
        if(two == four && two == six && three == seven)
        {
            return true;
        }
        if(two == four && two == six && five == seven)
        {
            return true;
        }
        if(two == four && two == seven && one == four)
        {
            return true;
        }
        if(two == four && two == seven && one == five)
        {
            return true;
        }
        if(two == four && two == seven && one == six)
        {
            return true;
        }
        if(two == four && two == seven && three == five)
        {
            return true;
        }
        if(two == four && two == seven && five == six)
        {
            return true;
        }
        if(two == five && two == six && one == three)
        {
            return true;
        }
        if(two == five && two == six && one == four)
        {
            return true;
        }
        if(two == five && two == six && one == seven)
        {
            return true;
        }
        if(two == five && two == six && three == four)
        {
            return true;
        }
        if(two == five && two == six && three == seven)
        {
            return true;
        }
        if(two == five && two == six && four == seven)
        {
            return true;
        }
        if(two == five && two == seven && one == three)
        {
            return true;
        }
        if(two == five && two == seven && one == four)
        {
            return true;
        }
        if(two == five && two == seven && one == six)
        {
            return true;
        }
        if(two == five && two == seven && three == four)
        {
            return true;
        }
        if(two == six && two == seven && one == three)
        {
            return true;
        }
        if(two == six && two == seven && one == four)
        {
            return true;
        }
        if(two == six && two == seven && one == five)
        {
            return true;
        }

        if(three == four && three == five && one == six)
        {
            return true;
        }
        if(three == four && three == five && one == seven)
        {
            return true;
        }
        if(three == four && three == five && two == six)
        {
            return true;
        }
        if(three == four && three == five && two == seven)
        {
            return true;
        }
        if(three == four && three == five && six == seven)
        {
            return true;
        }
        if(three == four && three == six && one == four)
        {
            return true;
        }
        if(three == four && three == six && one == five)
        {
            return true;
        }
        if(three == four && three == six && one == seven)
        {
            return true;
        }
        if(three == four && three == six && two == five)
        {
            return true;
        }
        if(three == four && three == six && two == seven)
        {
            return true;
        }
        if(three == four && three == six && five == seven)
        {
            return true;
        }
        if(three == four && three == seven && one == four)
        {
            return true;
        }
        if(three == four && three == seven && one == five)
        {
            return true;
        }
        if(three == four && three == seven && one == six)
        {
            return true;
        }
        if(three == four && three == seven && two == five)
        {
            return true;
        }
        if(three == four && three == seven && five == six)
        {
            return true;
        }
        if(three == five && three == six && one == two)
        {
            return true;
        }
        if(three == five && three == six && one == four)
        {
            return true;
        }
        if(three == five && three == six && one == seven)
        {
            return true;
        }
        if(three == five && three == six && two == four)
        {
            return true;
        }
        if(three == five && three == six && two == seven)
        {
            return true;
        }
        if(three == five && three == six && four == seven)
        {
            return true;
        }
        if(three == five && three == seven && one == two)
        {
            return true;
        }
        if(three == five && three == seven && one == four)
        {
            return true;
        }
        if(three == five && three == seven && one == six)
        {
            return true;
        }
        if(three == five && three == seven && two == four)
        {
            return true;
        }
        if(three == six && three == seven && one == two)
        {
            return true;
        }
        if(three == six && three == seven && one == four)
        {
            return true;
        }
        if(three == six && three == seven && one == five)
        {
            return true;
        }

        if(four == five && four == six && one == two)
        {
            return true;
        }
        if(four == five && four == six && one == three)
        {
            return true;
        }
        if(four == five && four == six && one == seven)
        {
            return true;
        }
        if(four == five && four == six && two == three)
        {
            return true;
        }
        if(four == five && four == six && two == seven)
        {
            return true;
        }
        if(four == five && four == six && three == seven)
        {
            return true;
        }
        if(four == five && four == seven && one == two)
        {
            return true;
        }
        if(four == five && four == seven && one == three)
        {
            return true;
        }
        if(four == five && four == seven && one == six)
        {
            return true;
        }
        if(four == five && four == seven && two == three)
        {
            return true;
        }
        if(four == six && four == seven && one == two)
        {
            return true;
        }
        if(four == six && four == seven && one == three)
        {
            return true;
        }
        if(four == six && four == seven && one == five)
        {
            return true;
        }

        if(five == six && five == seven && one == two)
        {
            return true;
        }
        if(five == six && five == seven && one == three)
        {
            return true;
        }
        if(five == six && five == seven && one == four)
        {
            return true;
        }

        else
        {
            return false;
        }
    }

    public boolean straightFlush(Hand a)
    {
        if(straightCheck(a) && flush(a))
        {
            return true;
        }
        return false;
    }

    public boolean royalFlush(Hand a)
    {
        if(straightCheck(a) && flush(a)  && royalCheck(a))
        {
            return true;
        }
        return false;
    } 

    public boolean royalCheck(Hand z)
    {
        int one = 0;
        int two = 0;
        int three = 0;
        int four = 0;
        int five = 0;
        int six = 0;
        int seven = 0;
        int num1 = 0;
        int num2 = 0;

        Card a;
        Card b;
        Card c;
        Card d;
        Card e;
        Card f;
        Card g;

        a = hand.get(0);
        one = a.getRank();
        b = hand.get(1);
        two = b.getRank();
        c = hand.get(2);
        three = c.getRank();
        d = hand.get(3);
        four = d.getRank();
        e = hand.get(4);
        five = e.getRank();

        for(int i = 0; i < z.getHand().size(); i++)
        {
            f = z.getHand().get(0);
            six = f.getRank();
            g = z.getHand().get(1);
            seven = g.getRank();
        }

        for(int j = 0; j < getHand().size(); j++)
        {
            for(int i = 0; i < z.getHand().size(); i++)
            {
                if(getHand().get(j).getRank() == 10 || getHand().get(i).getRank() == 10 && getHand().get(j).getRank() == 11 || getHand().get(i).getRank() == 11 && getHand().get(j).getRank() == 12 || getHand().get(i).getRank() == 12 && getHand().get(j).getRank() == 13 || getHand().get(i).getRank() == 13 && getHand().get(j).getRank() == 14 || getHand().get(i).getRank() == 14)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean sameSuit()
    {
        for(int i = 0; i < 1; i++)
        {
            if(hand.get(i).getSuit() == hand.get(i+1).getSuit())
            {
                return true;
            }
        }
        return false;
    }

    public boolean ace()
    {
        for(int i = 0; i < hand.size(); i++)
        {
            if(hand.get(i).getValue() == 11)
            {
                hand.get(i).switchAce();
                return true;
            }
        }
        return false;
    }

    public ArrayList<Card> getHand()
    {
        return hand;
    }

    public void clearHand()
    {
        for(int i = hand.size() - 1; i >= 0; i--)
        {
            hand.remove(i);
        }
    }

    public int getSize()
    {
        return hand.size();
    }

    public String toString()
    {
        String a = "";
        for(Card b : hand)
        {
            a += b.toString() + "\n";
        }
        return a; 
    }
}
