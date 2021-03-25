package lotto.controller;

import lotto.domain.*;
import lotto.util.LottosDto;

public class LottoMachine {

    public static final int LOTTO_NUMBER_COUNT = 6;

    private static Lottos lottos;

    public void purchaseLotto(Money money) {
        int lottoCount = money.getLottoCount();
        lottos = LottoGenerator.getLotto(lottoCount);
    }

    public int getPurchaseLottoCount() {
        return lottos.lottoCount();
    }

    public LottosDto getLottos() {
        return new LottosDto(lottos);
    }

    public ResultGroup getResult(WinningLotto winingLotto) {
        return lottos.getResult(winingLotto);
    }
}
