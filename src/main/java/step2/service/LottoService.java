package step2.service;

import java.util.List;
import step2.domain.LotteryWin;
import step2.domain.Lotto;

public class LottoService {

    private final LotteryWin lotteryWin;

    public LottoService(LotteryWin lotteryWin) {
        this.lotteryWin = lotteryWin;
    }

    public void matchResult(List<Lotto> lottoList) {
        lotteryWin.confirm(lottoList);
    }

    public String getProfitRate(int money, int totalWinningMoney) {
        return lotteryWin.getRateOfReturn(money, totalWinningMoney);
    }
}
