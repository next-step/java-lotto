package lotto_auto;

import lotto_auto.model.*;
import lotto_auto.view.LottoBundleStatusView;
import lotto_auto.view.OrderInputView;
import lotto_auto.view.StatisticResultView;
import lotto_auto.view.WinningLottoInputView;

public class Main {
    public static void main(String[] args) {
        Order order = OrderInputView.enterOrder();
        LottoBundle lottoBundle = LottoStore.sell(order);
        LottoBundleStatusView.statusPrint(lottoBundle, order);

        WinningLotto winningLotto = WinningLottoInputView.enter();

        LottoStatistic lottoStatistic = winningLotto.draw(lottoBundle);
        StatisticResultView.printStatistic(lottoStatistic);
    }
}
