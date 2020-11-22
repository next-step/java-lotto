package lotto_auto;

import lotto_auto.model.LottoBundle;
import lotto_auto.model.LottoStatistic;
import lotto_auto.model.LottoStore;
import lotto_auto.model.LottoTicket;
import lotto_auto.view.BuyInputView;
import lotto_auto.view.LottoBundleStatusView;
import lotto_auto.view.StatisticResultView;
import lotto_auto.view.WinningLottoInputView;

public class Main {
    public static void main(String[] args) {
        int money = BuyInputView.enter();
        LottoBundle lottoBundle = LottoStore.sell(money);
        LottoBundleStatusView.statusPrint(lottoBundle);
        LottoTicket winningLottoTicket = WinningLottoInputView.enter();
        LottoStatistic lottoStatistic = lottoBundle.draw(winningLottoTicket);
        StatisticResultView.printStatistic(lottoStatistic);
    }
}
