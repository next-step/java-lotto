package lotto.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum RankMatches {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private int count;
    private int prize;
    private static final Map<Integer, RankMatches> rankMap =
            Arrays.stream(RankMatches.values())
                    .filter(rank -> rank != SECOND)
                    .filter(rank -> rank != NONE)
                    .collect(Collectors.toMap(
                            rank -> rank.count,
                            Function.identity()
                    ));

    RankMatches(int count, int prize){
        this.count = count;
        this.prize = prize;
    }

    public static RankMatches makeRank(int count, boolean bonusNum){
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
