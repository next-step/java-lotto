package lotto;

import lotto.domian.*;
import lotto.ui.InputView;
import lotto.ui.OutputView;

public class LottoApplicationMain {

    public static void main(String[] args) {
        int purchaseMoney = InputView.questionOrder();
        LottoBundle bundle = Store.order(new Money(purchaseMoney));
        OutputView.showLottoBundle(bundle);
        WinNumber winNumber = new WinNumber(Store.pickWinNumber(InputView.questionWinnerNumber()));
        
    }

}
