package lotto_auto;

import lotto_auto.model.LottoBundle;
import lotto_auto.model.LottoStore;
import lotto_auto.view.BuyInputView;
import lotto_auto.view.LottoBundleStatusView;

public class Main {
    public static void main(String[] args) {
        int money = BuyInputView.enter();
        LottoBundle lottoBundle = LottoStore.buy(money);
        LottoBundleStatusView.statusPrint(lottoBundle);
    }
}
