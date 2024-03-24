package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public enum RankMatches {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private static int MINIMUM_OF_PRIZE = 3;
    private int count;
    private int prize;
    private static final Map<Integer, RankMatches> rankMap = new HashMap<>();

    static{
        rankMap.put(6, FIRST);
        rankMap.put(5, THIRD);
        rankMap.put(4, FOURTH);
        rankMap.put(3, FIFTH);
    }

    RankMatches(int count, int prize){
        this.count = count;
        this.prize = prize;
    }

    public static RankMatches makeRank(int count, boolean bonusNum){
        if (count < MINIMUM_OF_PRIZE) {
            return NONE;
        }
        if (SECOND.count == count && bonusNum) {
            return SECOND;
        }
        return rankMap.getOrDefault(count,NONE);
    }


    public int getCount(){
        return count;
    }

    public int getPrize(){
        return prize;
    }
}
