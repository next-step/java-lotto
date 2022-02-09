package lotto.model;

import static lotto.model.Rank.getRank;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Statistics {

    private static Map<Rank, Integer> ranks;

    public Statistics() {
        ranks = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            putRank(rank);
        }
    }

    public static void setRanks(WinningNumber winningNumber, List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            int matchCount = getMatchCount(lotto.getNumbers(),
              winningNumber.getWinningNumber());
            boolean bonusScore = winningNumber.isContainBonusBall(lotto);
            Rank rank = getRank(matchCount, bonusScore);
            incrementRank(rank);
        }
    }

    private static void incrementRank(Rank rank) {
        if (rank != Rank.MISS) {
            ranks.put(rank, ranks.get(rank) + 1);
        }
    }

    public static boolean getBonusScore(List<Integer> numbers, int bonusBall) {
        return numbers.contains(bonusBall);
    }

    public static int getMatchCount(List<Integer> numbers, List<Integer> winningNumber) {
        int matchCount = 0;
        for (Integer number : numbers) {
            matchCount += checkContainsNumber(winningNumber, number);
        }
        return matchCount;
    }

    private static int checkContainsNumber(List<Integer> winningNumber, int number) {
        if (winningNumber.contains(number)) {
            return 1;
        }
        return 0;
    }

    public static Map<Rank, Integer> getRanks() {
        return ranks;
    }

    private void putRank(Rank rank) {
        if (rank != Rank.MISS) {
            ranks.put(rank, 0);
        }
    }
}
