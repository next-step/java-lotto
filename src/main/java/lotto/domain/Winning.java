package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Winning {
    private Map<Rank, Integer> winnerCountMap;

    public Winning() {
        this.winnerCountMap = new HashMap<>();
    }

    public Winning(final Map<Rank, Integer> winnerCountMap) {
        this.winnerCountMap = winnerCountMap;
    }

    public void addWinning(int rightNumber, boolean bonusMatch) {
        if (Rank.isRank(rightNumber)) {
            final Rank rank = Rank.rank(rightNumber, bonusMatch);
            winnerCountMap.put(rank, winnerCountMap.getOrDefault(rank, 0) + 1);
        }
    }

    public int getWinnerCount(Rank rank) {
        return winnerCountMap.getOrDefault(rank, 0);
    }

    public double getReturnRate(final Amount purchaseAmount) {
        Amount sum = Amount.ZERO;
        for (Rank rank : winnerCountMap.keySet()) {
            sum = sum.plus(rank.multiply(winnerCountMap.get(rank)));
        }

        return sum.divide(purchaseAmount);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Winning winning = (Winning) o;
        return Objects.equals(winnerCountMap, winning.winnerCountMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winnerCountMap);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("당첨 통계\n---------\n");
        stringBuilder.append(String.format("3개 일치 (%d원)- %d개\n", Rank.FIFTH.getAmount().get(), getWinnerCount(Rank.FIFTH)));
        stringBuilder.append(String.format("4개 일치 (%d원)- %d개\n", Rank.FOURTH.getAmount().get(), getWinnerCount(Rank.FOURTH)));
        stringBuilder.append(String.format("5개 일치 (%d원)- %d개\n", Rank.THIRD.getAmount().get(), getWinnerCount(Rank.THIRD)));
        stringBuilder.append(String.format("5개 일치, 보너스 볼 일치(%d원) %d개\n", Rank.SECOND.getAmount().get(), getWinnerCount(Rank.SECOND)));
        stringBuilder.append(String.format("6개 일치 (%d원)- %d개\n", Rank.FIRST.getAmount().get(), getWinnerCount(Rank.FIRST)));

        return stringBuilder.toString();
    }
}
