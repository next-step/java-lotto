package lotto.controller;

import lotto.domain.*;
import lotto.util.LottoCountDto;
import lotto.util.LottosDto;

import java.util.List;

public class LottoMachine {

    public static final int LOTTO_NUMBER_COUNT = 6;
    private static final int INVALID_REQUEST_COUNT = 0;

    private Lottos lottos;
    private int autoCount;
    private int manualCount;

    public LottoCountDto getPurchaseLottoCount() {
        return LottoCountDto.of(manualCount, autoCount);
    }

    public LottosDto getLottos() {
        return new LottosDto(lottos);
    }

    public ResultGroup getResult(WinningLotto winingLotto) {
        return lottos.getResult(winingLotto);
    }

    public void purchaseLotto(Money money, List<Lotto> manualLottos) {
        int lottoCount = money.getLottoCount();
        this.manualCount = manualLottos.size();
        this.autoCount = lottoCount - this.manualCount;
        if (this.autoCount < INVALID_REQUEST_COUNT) {
            throw new IllegalArgumentException("금액보다 초과한 매수를 구매할 수 없습니다");
        }
        this.lottos = new Lottos(manualLottos, LottoGenerator.getLotto(autoCount));
    }
}
