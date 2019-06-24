package lotto;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoAplication {

    public static void main(String[] args) {

        Order orderAmount = InputView.inputOrderAmount();
        Lottos lottos = LottoRetailer.buyAutoPick(orderAmount);
        ResultView.printPickedLottoNumbers(lottos);

        WinningNumbers winningNumbers = InputView.inputWinningNumber();

        Aggregate aggregate = lottos.check(winningNumbers);
        ResultView.printResult(aggregate);
    }
}
