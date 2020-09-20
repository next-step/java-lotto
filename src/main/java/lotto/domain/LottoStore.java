package lotto.domain;

import java.util.List;
import java.util.Map;

public class LottoStore {
    private Lottos purchasedLotto;
    private Map<Rank, Integer> rankInfo = Rank.getInitRankInfo();

    public LottoStore(Lottos lottoList) {
        this.purchasedLotto = lottoList;
    }

    public void matchNumber(Lotto winningLotto) {
        for(Lotto lotto : purchasedLotto) {
            Rank rank = lotto.matchLotto(winningLotto);
            if (rankInfo.containsKey(rank)) {
                rankInfo.replace(rank, rankInfo.get(rank) + 1);
            }
        }
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

    public String statistics(Money money) {
        int revenue = getTotalPrize();
        double yeild = (double) revenue / (double) money.getLottoPrice();
        return String.format("%.2f", yeild);
    }
}
