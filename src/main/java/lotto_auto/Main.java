package lotto_auto;

import lotto_auto.model.LottoBundle;
import lotto_auto.model.LottoResult;
import lotto_auto.model.LottoStore;
import lotto_auto.model.LottoTicket;
import lotto_auto.view.BuyInputView;
import lotto_auto.view.LottoBundleStatusView;
import lotto_auto.view.StatisticResultView;
import lotto_auto.view.WinningLottoInputView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        int money = BuyInputView.enter();
        LottoBundle lottoBundle = LottoStore.buy(money);
        LottoBundleStatusView.statusPrint(lottoBundle);
        LottoTicket winningLottoTicket = WinningLottoInputView.enter();
        List<LottoResult> statistic = lottoBundle.statistic(winningLottoTicket);
        StatisticResultView.printStatistic(statistic, money);
    }
}
