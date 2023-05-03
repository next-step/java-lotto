package step2.service;

import step2.domain.LotteryWin;
import step2.domain.PurchasedLotto;

public class LottoService {

    private final LotteryWin lotteryWin;
    public final PurchasedLotto purchasedLotto;

    public LottoService(LotteryWin lotteryWin, PurchasedLotto purchasedLottoList) {
        this.lotteryWin = lotteryWin;
        this.purchasedLotto = purchasedLottoList;
    }

    public void matchResult() {
        lotteryWin.confirm(purchasedLotto);
    }
}
