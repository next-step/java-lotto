package lotto.model;

import java.util.*;

public enum Rank{
    FIRST(6,false, 2_000_000_000),
    SECOND(5,true,3_000_000),
    THIRD(5, false,1_500_000),
    FOURTH(4,false,50_000),
    FIFTH(3,false,5_000),
    NO_MATCH(0,false,0);


    private final int winningCount;
    private final boolean matchBonus;
    private final int money;


    Rank(int winningCount, boolean matchBonus, int money){

        this.winningCount = winningCount;
        this.matchBonus = matchBonus;
        this.money = money;

    }

    public static Map<Rank,Integer> getInitWinningStatics(){
        Map<Rank,Integer> winningStatics = new HashMap<>();

        for(Rank rank : Rank.values()){
            winningStatics.put(rank,0);
        }
        return Collections.unmodifiableMap(winningStatics);
    }

    public static Rank rank(int winningCount, boolean matchBonus){
        if(winningCount < FIFTH.winningCount){
            return NO_MATCH;
        }

        return Arrays.stream(values())
                .filter(rank -> rank.isWinningCount(winningCount, matchBonus))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    private boolean isWinningCount(int winningCount, boolean matchBonus){
        return (this.winningCount == winningCount && this.matchBonus == matchBonus);

    }

    public int getWinningCount(){
        return this.winningCount;
    }

    public int getMoney(){
        return this.money;
    }
}
