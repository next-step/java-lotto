package lotto.model;

import java.util.Arrays;

public enum Rank{
    FIRST(6,2000000000),
    SECOND(5, 1500000),
    THIRD(4,50000),
    FOURTH(3,5000),
    NO_MATCH(0,0);


    private final int winningCount;
    private final int money;

    Rank(int winningCount, int money){

        this.winningCount = winningCount;
        this.money = money;
    }

    public static Rank rank(int winningCount){
        if(winningCount < FOURTH.winningCount){
            return NO_MATCH;
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
