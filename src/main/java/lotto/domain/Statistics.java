package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistics {

    private Map<String, Integer> rank;
    private WinnigResult winnigResult = new WinnigResult();

    public Statistics() {
        rank = new HashMap<>();
        rank.put(WinnigResult.FIRST, 0);
        rank.put(WinnigResult.SECOND, 0);
        rank.put(WinnigResult.THIRD, 0);
        rank.put(WinnigResult.FOURTH, 0);
        rank.put(WinnigResult.FIFTH, 0);
        rank.put(WinnigResult.MISS, 0);
    }

    private void calculateRank(String status) {
        rank.put(status, rank.getOrDefault(status,0) + 1);
    }

    public int winningCount(String status) {
        return rank.getOrDefault(status, 0);
    }

    public void calculateWinningResult(List<LottoPaper> buyLotto, WinningLottoNumber winningLottoNumber) {
        for (LottoPaper lotto : buyLotto) {
            int matchCount = lotto.checkMatchNumberCount(winningLottoNumber.getWinningNumber());
            calculateRank(winnigResult.getLottoStatus(matchCount));
        }
    }

    public int getEarnMoney() {
        int earnMoney = 0;

        for (String status : WinnigResult.winStatus) {
            earnMoney += winnigResult.getEarnMoney(status, rank.get(status));
        }

        return earnMoney;
    }

}
