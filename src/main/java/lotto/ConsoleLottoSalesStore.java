package lotto;

import lotto.domain.LottoBill;
import lotto.domain.LottoBundle;
import lotto.view.InputView;

public class ConsoleLottoSalesStore {

    public static void main(String[] args) {
        LottoBill bill = new InputView().sell();
        LottoBundle lottoBundle = LottoBundle.of(bill.quantity());
        System.out.println(lottoBundle);
    }
}
