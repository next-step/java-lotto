package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Buyer {
    private static final BigDecimal UNIT_AMOUNT = new BigDecimal(1000);
    private Lottos lottos;

    public Buyer(Lottos lottos) {
        this.lottos = lottos;
    }
    public Buyer(int count, LottoNumberGenerator generator) {
        this(initLottes(generator.genLottoNumbers(count)));
    }

    private static Lottos initLottes(List<List<Integer>> lists) {
        List<Lotto> lottos = new ArrayList<>();
        for (List<Integer> lottoNum : lists) {
            lottos.add(new Lotto(lottoNum));
        }
        return new Lottos(lottos);
    }

    public BigDecimal getRateOfReturn(Lotto winningLotto) {

        return lottos.getWinningAmount(winningLotto.getLottoNumbers()).divide(lottos.getTotalPaymentAmount(), 2, RoundingMode.DOWN);
    }

    public Map<LottoRankingEnum, Integer> getWinningResult(Lotto winningLotto) {
        return lottos.getWinningResult(winningLotto.getLottoNumbers());
    }

    public List<List<Integer>> getLottoNumbers() {
        return lottos.getLottoNumbers();
    }

    public int getBuyCount() {
        return lottos.getSize();
    }

}
