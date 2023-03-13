package domain;

import java.math.BigDecimal;
import java.util.List;

import domain.type.LottoPrice;
import domain.type.LottoRankAmount;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void calculateLottoRank(FirstPlaceLotto firstPlaceLotto) {
        for (Lotto lotto : lottos) {
            lotto.calculateLottoRank(firstPlaceLotto);
        }
    }

    public int getLottoRankCount(LottoRankAmount lottoRankAmount) {
        return lottos.stream()
                .filter(lotto -> lotto.getLottoRankAmount() == lottoRankAmount)
                .toArray().length;
    }

    public BigDecimal getProfitRate() {
        return LottoProfit.getProfitRate(this);
    }

    public int size() {
        return lottos.size();
    }
}
