package step2.domain;

import java.math.BigDecimal;
import java.util.List;

public class LottoMachine {

    private static final BigDecimal LOTTO_PRICE = BigDecimal.valueOf(1000);
    private final Lottos lottos = new Lottos();
    private LottoStatistics lottoStatistics;

    public Lottos createLotto(int money) {
        return lottos.createLottoList(getLottoCount(money));
    }

    public int getLottoCount(int money) {
        return BigDecimal.valueOf(money)
                .divide(LOTTO_PRICE)
                .intValue();
    }

    public void statistics(Lottos lottos, List<Integer> winNumber) {
        lottoStatistics.getLottoRank(lottos, winNumber);
    }

}
