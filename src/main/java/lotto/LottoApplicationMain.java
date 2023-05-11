package lotto;

import lotto.domian.*;
import lotto.ui.InputView;
import lotto.ui.OutputView;

public class LottoApplicationMain {

    public static void main(String[] args) {
        int purchaseMoney = InputView.questionOrder();
        LottoBundle lottoBundle = Store.order(new Money(purchaseMoney));
        OutputView.showLottoBundle(lottoBundle);

        String answerNumbers = InputView.questionWinnerNumber();
        String bonusWinNumber = InputView.questionBonusNumber();

        WinNumber winNumber = LottoCompany.announce(answerNumbers, bonusWinNumber);
        Record record = Record.extractRecord(lottoBundle, winNumber);
        OutputView.showRecord(record);

        ProfitRate profitRate = record.calculateProfit(purchaseMoney);
        OutputView.showProfitRate(profitRate);
    }
}