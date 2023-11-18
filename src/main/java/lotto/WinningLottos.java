package lotto;

import java.util.HashMap;
import java.util.Map;

public class WinningLottos {

    private Map<Integer, Integer> winningLottos = new HashMap<>();


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

}
