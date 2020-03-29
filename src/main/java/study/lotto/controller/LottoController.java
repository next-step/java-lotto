package study.lotto.controller;


import study.lotto.domain.Lotto;
import study.lotto.domain.LottoResult;
import study.lotto.domain.LottoWinningNumber;
import study.lotto.view.InputView;
import study.lotto.view.ResultView;

import java.util.List;

public class LottoController {
    public static void run() {
        int amount = InputView.getAmount();
        Lotto lotto = new Lotto(amount, new RandomLottoTicketIssuer());
        ResultView.displayBuyingLotto(lotto.getLottoTickets());

        List<Integer> winningNumbers = InputView.getWinningNumber();
        LottoResult lottoResult =
                lotto.setWinningNumber(new LottoWinningNumber(winningNumbers));
        ResultView.displayResult(lottoResult);
    }
}
