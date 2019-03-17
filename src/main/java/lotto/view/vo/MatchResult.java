package lotto.view.vo;

import lotto.enums.Rank;

public class MatchResult {
    private static int[] result = new int[Rank.FIRST.getCountOfMatch() + 1];

    public static void addMatchCount(int number) {
        result[number]++;
    }

    public static int getMatchCount(int number) {
        return result[number];
    }
}
