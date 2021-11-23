package lotto;

import common.view.InputView;
import common.view.OutputView;
import lotto.application.Constant;
import lotto.factory.LottoNumbersFactory;
import lotto.model.*;

public class Consumer {

    public static void main(String[] args) {
        int purchaseAmount = InputView.nextInt(Constant.INPUT_MESSAGE_PURCHASE_AMOUNT);

        Lotto lotto = LottoStore.ticket(purchaseAmount);
        OutputView.print(lotto);

        String winnerNumbers = InputView.nextLine(Constant.INPUT_MESSAGE_WINNER_NUMBERS);
        LottoWinner lottoWinner = new LottoWinner(LottoNumbersFactory.manualCreateNumberList(winnerNumbers));

        LottoReport report = new LottoReport(lotto, lottoWinner);
        OutputView.print(report, purchaseAmount);
    }

}
