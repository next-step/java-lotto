package lotto;


import lotto.domain.Lotto;
import lotto.domain.LottoAmount;
import lotto.domain.LottoGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-02 22:36
 */
public class LottoMachine {

    private final LottoAmount lottoAmount;
    private final List<Lotto> lottos;

    public LottoMachine(LottoAmount lottoAmount) {
        this.lottoAmount = lottoAmount;
        this.lottos = new ArrayList<>();
    }

    public void purchase(LottoGenerator lottoGenerator) {
        for (int amount = 0; amount < lottoAmount.amount(); amount++) {
            lottos.add(Lotto.of(lottoGenerator.generate()));
        }
    }
}
