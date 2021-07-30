package lotto.domain.matchcase;

import lotto.domain.Rank;

import java.util.HashMap;
import java.util.Map;

public abstract class Case {
    protected static int first = 0;
    protected static int second = 0;
    protected static int third = 0;
    protected static int forth = 0;
    protected static int fifth = 0;

    public abstract void addMatchCount();

    public static Map<Rank, Integer> lotteryRewards() {
        Map<Rank, Integer> map = new HashMap<>();
        map.put(Rank.FIRST, first);
        map.put(Rank.SECOND, second);
        map.put(Rank.THIRD, third);
        map.put(Rank.FORTH, forth);
        map.put(Rank.FIFTH, fifth);
        return map;
    }
}
