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

    public static Map<String, Integer> lotteryRewards() {
        Map<String, Integer> map = new HashMap<>();
        map.put(Rank.FIRST.getGrade(), first);
        map.put(Rank.SECOND.getGrade(), second);
        map.put(Rank.THIRD.getGrade(), third);
        map.put(Rank.FORTH.getGrade(), forth);
        map.put(Rank.FIFTH.getGrade(), fifth);
        return map;
    }
}
