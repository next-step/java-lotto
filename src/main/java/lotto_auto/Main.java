package lotto_auto;

import lotto_auto.model.*;
import lotto_auto.view.*;

public class Main {
    public static void main(String[] args) {
        int money = BuyInputView.enter();
        LottoBundle lottoBundle = LottoStore.sell(money);
        LottoBundleStatusView.statusPrint(lottoBundle);
        LottoNumbers winningLottoNumbers = WinningLottoInputView.enter();
        LottoNumber bonusNumber = BonusNumberInputView.enter();
        LottoStatistic lottoStatistic = lottoBundle.draw(winningLottoNumbers, bonusNumber);
        StatisticResultView.printStatistic(lottoStatistic);
    }
}
