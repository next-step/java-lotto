package lotto;

import lotto.domian.*;
import lotto.ui.InputView;
import lotto.ui.OutputView;

public class LottoApplicationMain {

    public static void main(String[] args) {
        int purchaseMoney = InputView.questionOrder();
        LottoBundle lottoBundle = Store.order(new Money(purchaseMoney));
        OutputView.showLottoBundle(lottoBundle);
        WinNumber winNumber = new WinNumber(Store.pickWinNumber(InputView.questionWinnerNumber()));
        Record record = Store.extractRecord(lottoBundle, winNumber);
        OutputView.showRecord(record);
    }
}
