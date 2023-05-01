package step2.service;

import step2.domain.LotteryWin;
import step2.domain.PurchasedLotto;

public class LottoService {

    private final LotteryWin lotteryWin;

    public LottoService(LotteryWin lotteryWin) {
        this.lotteryWin = lotteryWin;
    }

    public void matchResult(PurchasedLotto lottoList) {
        lotteryWin.confirm(lottoList.get());
    }

    public String getProfitRate(int money, int totalWinningMoney) {
        return lotteryWin.getRateOfReturn(money, totalWinningMoney);
    }
}
