package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public class LottoStore {
    private Lottos purchasedLotto;
    private Map<Rank, Integer> rankInfo = Rank.getInitRankInfo();

    public LottoStore(Lottos lottoList) {
        this.purchasedLotto = lottoList;
    }

    public void matchNumber(WinningLotto winningLotto) {
        purchasedLotto.getLottoList().stream()
                .filter(lotto -> {
                    Rank rank = lotto.matchLotto(winningLotto);
                    return rankInfo.containsKey(rank);
                }).forEach(lotto -> {
                    Rank rank = lotto.matchLotto(winningLotto);
                    rankInfo.replace(rank, rankInfo.get(rank) + 1);
                });
    }

    public Map<Rank, Integer> getRankInfo() {
        return rankInfo;
    }

    public int getTotalPrize() {
        return rankInfo.keySet()
                .stream()
                .mapToInt(rank -> rank.getPrize() * rankInfo.get(rank))
                .reduce((beforePrize, newPrize) -> beforePrize + newPrize)
                .getAsInt();
    }

    public BigDecimal statistics(Money money) {
        int revenue = getTotalPrize();
        double yeild = (double) revenue / (double) money.getLottoPrice();
        BigDecimal yeildDecimal = new BigDecimal(yeild);
        return yeildDecimal.setScale(2, RoundingMode.DOWN);
    }
}
