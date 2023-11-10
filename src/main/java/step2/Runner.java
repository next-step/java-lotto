package step2;

import step2.view.InputView;
import step2.view.ResultView;

import static step2.domain.LottoStore.priceToNumberOfLotto;
import static step2.util.BigDecimalUtil.stringToBigDecimal;

public class Runner {

    public static void main(String[] args) {
        String price = InputView.price();
        int numberOfLotto = priceToNumberOfLotto(stringToBigDecimal(price));
        ResultView.printPurchaseMessage(numberOfLotto);
    }

}
