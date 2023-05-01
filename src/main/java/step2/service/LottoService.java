package step2.service;

import java.util.List;
import java.util.Map;
import step2.domain.LotteryWin;
import step2.domain.Lotto;

public class LottoService {

    private final LotteryWin lotteryWin;

    public LottoService(LotteryWin lotteryWin) {
        this.lotteryWin = lotteryWin;
    }

    public Map<Integer, Integer> match(List<Lotto> lottoList) {
        lotteryWin.confirm(lottoList);
        return lotteryWin.getResult();
    }

    public String getProfitRate(int money) {
        return lotteryWin.getRateOfReturn(money, lotteryWin.getWinningAmount());
    }
}
