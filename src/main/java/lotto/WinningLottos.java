package lotto;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WinningLottos {

    private Map<Rank, Integer> winningLottos = new HashMap<>();
    private Integer totalRewardPrice = 0;

    public WinningLottos() {
    }

    public WinningLottos(Map<Rank, Integer> winningLottos) {
        this.winningLottos = winningLottos;
    }

    public Integer countLottoByWinningNumber(int count) {
        return winningLottos.getOrDefault(Rank.convertRanking(count), 0);
    }

    public void putWinningMatchingNumberLotto(int count) {
        winningLottos.put(Rank.convertRanking(count), countLottoByWinningNumber(count) + 1);
    }

    public Integer rewardWinningLotto(int count) {
        Rank rank = Rank.convertRanking(count);
        return this.countLottoByWinningNumber(count) * rank.rewardPrice();
    }

    private Integer rewardWinningLotto(Rank rank) {
        return this.countLottoByWinningNumber(rank.matchingCount()) * rank.rewardPrice();
    }

    public Integer totalRewardWinningLottos() {
        for (Rank rank : winningLottos.keySet()) {
            totalRewardPrice += rewardWinningLotto(rank);
        }
        return totalRewardPrice;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLottos that = (WinningLottos) o;
        return Objects.equals(winningLottos, that.winningLottos) && Objects.equals(totalRewardPrice, that.totalRewardPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningLottos, totalRewardPrice);
    }
}
