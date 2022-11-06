package lotto.domain;

import java.util.EnumMap;

import static lotto.domain.Rank.*;

public class RankCount {
    private static final int ZERO = 0;

    private EnumMap<Rank, Integer> rankCount = new EnumMap<>(Rank.class);

    public RankCount() {
        rankCount.put(FIRST, 0);
        rankCount.put(SECOND, 0);
        rankCount.put(THIRD, 0);
        rankCount.put(FOURTH, 0);
        rankCount.put(FIFTH, 0);
        rankCount.put(MISS, 0);
    }

    public void countRank(Lotto lotto, WinningNumbers winningNumbers) {
        int countOfMatch = ZERO;
        boolean bonusBallMatch = false;

        for (int number : lotto.numbers()) {
            countOfMatch = countOfMatch(winningNumbers, number, countOfMatch);
            bonusBallMatch = matchBonusBall(winningNumbers, number);
        }

        plusRank(countOfMatch, bonusBallMatch);
    }

    private void plusRank(int countOfMatch, boolean bonusBallMatch) {
        Rank rank = Rank.valueOf(countOfMatch, bonusBallMatch);
        int count = rankCount.get(rank);
        rankCount.put(rank, count + 1);
    }

    private boolean matchBonusBall(WinningNumbers winningNumbers, int number) {
        if (number == winningNumbers.bonusNumber()) {
            return true;
        }
        return false;
    }

    private int countOfMatch(WinningNumbers winningNumbers, int number, int countOfMatch) {
        if (winningNumbers.numbers().contains(number)) {
            countOfMatch = countOfMatch + 1;
        }
        return countOfMatch;
    }

    public long winningAmount() {
        long totalWinningMoney = ZERO;
        for (Rank rank : Rank.values()) {
            totalWinningMoney += rank.winningMoney() * rankCount.get(rank);
        }
        return totalWinningMoney;
    }

    public int numberOfRank(Rank rank) {
        return rankCount.get(rank);
    }

}
