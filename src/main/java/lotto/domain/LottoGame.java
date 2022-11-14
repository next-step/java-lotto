package lotto.domain;

import java.util.*;

public class LottoGame {

    private static final int LOTTO_PRICE = 1000;

    private final Lottos lottos;
    private final WinningLotto winningLotto;
    private final LottoResult lottoResult;

    public LottoGame(int money, LottoGenerator lottoGenerator, String winningLotto) {

        this.lottos = lottoGenerator.generate(countTryNumber(money, LOTTO_PRICE));
        this.winningLotto = new WinningLotto(winningLotto);
        this.lottoResult = new LottoResult(lottos, this.winningLotto);
    }

    private int countTryNumber(int money, int lottoPrice) {
            return money/lottoPrice;
    }

    public Lottos getLottos() {
        return lottos;
    }

    public LottoResult getLottoResult() {
        return lottoResult;
    }
}
