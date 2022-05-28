package lotto.domain;

import java.util.*;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottoList() {
        return Collections.unmodifiableList(lottos);
    }

    public int getCount() {
        return lottos.size();
    }

    public Map<Rank, Integer> getTotalRank(WinningLotto winningLotto) {
        Map<Rank, Integer> totalLottoRank = new HashMap<>();
        for (Rank value : Rank.values()) {
            totalLottoRank.put(value, 0);
        }

        for (Lotto buyingLotto : lottos) {
            Rank rank = buyingLotto.getRank(winningLotto);
            totalLottoRank.put(rank, totalLottoRank.get(rank) + 1);
        }

        return totalLottoRank;
    }

    public int getTotalWinningMoney(WinningLotto winningLotto) {
        return WinningMoneyCalculator.getTotalWinningMoney(winningLotto, this);
    }
}
