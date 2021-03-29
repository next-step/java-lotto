package lotto.controller;

import lotto.domain.*;
import lotto.util.LottoCountDto;
import lotto.util.LottosDto;

import java.util.List;

public class LottoMachine {

    public static final int LOTTO_NUMBER_COUNT = 6;

    private Lottos lottos;
    private int autoCount;
    private int manualCount;

    public void purchaseManualLotto(int manualCount, List<Lotto> lottos) {
        this.manualCount = manualCount;
        this.lottos = new Lottos(lottos);
    }

    public void purchaseAutoLotto(Money money) {
        int lottoCount = money.getLottoCount();
        this.autoCount = lottoCount - this.manualCount;
        this.lottos.addLotto(LottoGenerator.getLotto(autoCount));
    }

    public LottoCountDto getPurchaseLottoCount() {
        return new LottoCountDto(manualCount, autoCount);
    }

    public LottosDto getLottos() {
        return new LottosDto(lottos);
    }

    public ResultGroup getResult(WinningLotto winingLotto) {
        return lottos.getResult(winingLotto);
    }

}
