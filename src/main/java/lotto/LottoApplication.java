package lotto;

import calculator.Operator;
import view.InputView;
import view.OutputView;

public class LottoApplication {

    public static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {

        Integer lottoPurchaseAmount = InputView.showLottoPurchaseAmountInput();
        Integer lottoQuantity = Operator.DIVIDE.formula.apply(lottoPurchaseAmount, LOTTO_PRICE);
        OutputView.showLottoQuantity(lottoQuantity);
    }
}
