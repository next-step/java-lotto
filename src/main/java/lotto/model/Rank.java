package lotto.model;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Rank{
    FIRST(6,2_000_000_000),
    SECOND(5,3_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4,50_000),
    FIFTH(3,5_000),
    NO_MATCH(0,0);


    private final int winningCount;
    private final int money;


    Rank(int winningCount, int money){

        this.winningCount = winningCount;
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

        if(winningCount == 6 && matchBonus){
            return SECOND;
        }

        return Arrays.stream(values())
                .filter(rank -> rank.isWinningCount(winningCount))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    private boolean isWinningCount(int winningCount){
        return this.winningCount == winningCount;
    }

    public int getWinningCount(){
        return this.winningCount;
    }

    public int getMoney(){
        return this.money;
    }
}
