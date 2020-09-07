package lotto;

import lotto.domain.*;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.List;

public class LottoMachine {

    public static void main(String[] args) {
        List<LottoNumbers> tickets = LottoFactory.buyTickets(InputView.howMuch());
        ResultView.showTickets(tickets);

        WinningLotto winningNumbers = WinningLotto.of(InputView.getWinningNumbers());

        LottoResult result = winningNumbers.drawing(tickets);
        ResultView.showDrawingResult(result);
    }
}
