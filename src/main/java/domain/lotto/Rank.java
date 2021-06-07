package domain.lotto;

import java.util.ArrayList;

public enum Rank{//class Rank {
    FIRST(6,false, 10_000),
    SECOND(5,true, 5_000);
    //private static final Rank FIRST = new Rank(6,false,10_000);
    private final int matchCount;
    private final boolean matchBonus;
    private final int price;
    private Rank(final int matchCount, final boolean matchBonus, final int price){
        this.matchCount  = matchCount;
        this.matchBonus = matchBonus;
        this.price  =price;
    }
    public int getMatchCount(){
        return this.matchCount;
    }


}
