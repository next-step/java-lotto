package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class Winning {
    private Map<Rank, Integer> winnerCountMap;

    public Winning() {
        this.winnerCountMap = new HashMap<>();
    }
    public void addWinning(int rightNumber, boolean bonusMatch) {
        if (Rank.isWinning(rightNumber)) {
            final Rank rank = Rank.ofRightNumber(rightNumber, bonusMatch);
            winnerCountMap.put(rank, winnerCountMap.getOrDefault(rank, 0) + 1);
        }
    }

    public int getWinnerCount(Rank rank) {
        return winnerCountMap.getOrDefault(rank, 0);
    }

    public double getReturnRate(final Amount purchaseAmount) {
        Amount sum = Amount.ZERO;
        for (Rank rank : winnerCountMap.keySet()) {
            final Amount rankPrice = rank.getAmount();

            final int count = winnerCountMap.get(rank);
            sum = rankPrice.multiply(count);
        }

        return sum.divide(purchaseAmount);
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
