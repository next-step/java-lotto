package lotto.domain;

import lotto.common.type.WinnerRank;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

import static lotto.input.LottoTicket.DEFAULT_TICKET_PRICE;

public class RewardStatistics {

    private final EnumMap<WinnerRank, Integer> winnerCount = new EnumMap<>(WinnerRank.class);

    private final static int DEFAULT_OFFSET = 1;

    public RewardStatistics() {
        winnerCount.put(WinnerRank.FIRST, 0);
        winnerCount.put(WinnerRank.SECOND, 0);
        winnerCount.put(WinnerRank.THIRD, 0);
        winnerCount.put(WinnerRank.FORTH, 0);
        winnerCount.put(WinnerRank.FIFTH, 0);
    }

    public void plusCount(WinnerRank winnerRank) {
        if (!winnerCount.containsKey(winnerRank)) return;
        winnerCount.put(winnerRank, winnerCount.get(winnerRank) + DEFAULT_OFFSET);
    }

    public int getAllProfit() {
        int result = 0;
        for (Map.Entry<WinnerRank, Integer> entry : winnerCount.entrySet()) {
            result += entry.getKey().getReward() * entry.getValue();
        }
        return result;
    }

    public double getProfitRatio(Lottos lottos) {
        return getAllProfit() / (double) (lottos.getLottosAmount() * DEFAULT_TICKET_PRICE);
    }

    public Map<WinnerRank, Integer> getWinnerCount() {
        return winnerCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RewardStatistics that = (RewardStatistics) o;
        return Objects.equals(winnerCount, that.winnerCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winnerCount);
    }
}
