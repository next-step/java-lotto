package step2.service;

import step2.domain.LotteryWin;
import step2.domain.ManualLotto;
import step2.domain.PurchasedLotto;

public class LottoService {

    private final PurchasedLotto purchasedLottoList;

    public LottoService(PurchasedLotto purchasedLottoList) {
        this.purchasedLottoList = purchasedLottoList;
    }

    public void purchase(ManualLotto manualLotto){
        purchasedLottoList.addManualLottos(manualLotto);
    }

    public void matchResult(LotteryWin lotteryWin) {
        lotteryWin.confirm(purchasedLottoList);
    }
}
