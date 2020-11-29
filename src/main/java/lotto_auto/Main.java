package lotto_auto;

import lotto_auto.model.*;
import lotto_auto.view.*;

public class Main {
    public static void main(String[] args) {
        Order order = OrderInputView.enterOrder();
        LottoBundle lottoBundle = LottoStore.sell(order);
        LottoBundleStatusView.statusPrint(lottoBundle, order);
        LottoNumbers winningLottoNumbers = WinningLottoInputView.enter();
        LottoNumber bonusNumber = BonusNumberInputView.enter();
        LottoStatistic lottoStatistic = lottoBundle.draw(winningLottoNumbers, bonusNumber);
        StatisticResultView.printStatistic(lottoStatistic);
    }
}
