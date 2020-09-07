package lotto;

import lotto.domain.*;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class LottoMachine {

    public static void main(String[] args) {
        LottoBundle bundle = LottoFactory.buyTickets(InputView.howMuch());
        ResultView.showTickets(bundle);

        WinningLotto winningNumbers = WinningLotto.of(InputView.getWinningNumbers());

        LottoResult result = bundle.drawing(winningNumbers);
        ResultView.showDrawingResult(result);
    }
}
