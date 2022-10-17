package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.LottoTickets;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    public void start() {
        int totalPrice = InputView.inputTotalPrice();

        LottoTickets lottoTickets = LottoTickets.of(totalPrice);

        int tickets = lottoTickets.getTicketCount();
        ResultView.printTotalCount(tickets);
        ResultView.printResultTickets(lottoTickets.getTickets());

        List<LottoNumber> winningNumbers = InputView.inputLottoNumberLastResult();
        int bonusBall = InputView.inputBonusBall();

        LottoResult lottoResult = lottoTickets.getResult(Lotto.of(winningNumbers), bonusBall);

        ResultView.printStatistics(lottoResult.getStatistics());
        ResultView.printRating(lottoResult.getStatistics(), totalPrice);
    }
}
