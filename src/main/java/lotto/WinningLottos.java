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

    public Integer countLottoByWinningNumber(int count, boolean matchBonus) {
        return this.countLottoByWinningNumber(Rank.convertRanking(count, matchBonus));
    }

    public Integer countLottoByWinningNumber(Rank rank) {
        return winningLottos.getOrDefault(rank, 0);
    }

    public void putWinningMatchingNumberLotto(int count, boolean matchBonus) {
        winningLottos.put(Rank.convertRanking(count, matchBonus), countLottoByWinningNumber(count, matchBonus) + 1);
    }

    public Integer rewardWinningLotto(int count, boolean matchBonus) {
        Rank rank = Rank.convertRanking(count, matchBonus);
        return this.countLottoByWinningNumber(count, matchBonus) * rank.rewardPrice();
    }

    private Integer rewardWinningLotto(Rank rank) {
        return this.countLottoByWinningNumber(rank) * rank.rewardPrice();
    }

    public Integer totalRewardWinningLottos() {
        for (Rank rank : winningLottos.keySet()) {
            totalRewardPrice += rewardWinningLotto(rank);
        }
        return totalRewardPrice;
    }

    public double investingPercent(int price) {
        return (double) this.totalRewardWinningLottos() / price;
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
