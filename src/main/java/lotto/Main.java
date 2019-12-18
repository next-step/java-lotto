package lotto;

import lotto.domain.LottoShop;

import static lotto.io.InputView.InputPayment;
import static lotto.io.InputView.InputSelfLottoCount;

public class Main {

    public static void main(String[] args) {

        int payment = InputPayment();

        InputSelfLottoCount();

        System.out.println(LottoShop.sell(payment).getLottosCount());
    }
}
