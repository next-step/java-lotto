package lotto.controller;

import java.util.List;
import lotto.domain.LottoNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.LottoTickets;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    public void start() {
        int totalPrice = InputView.inputTotalPrice();

        LottoTickets lottoTickets = LottoTickets.from(totalPrice);

        ResultView.printTotalCount(lottoTickets.countTicket());
        ResultView.printResultTickets(lottoTickets.createTickets());

        List<LottoNumber> winningNumbers = InputView.inputLottoNumberLastResult();

        ResultView.printWinningNumber(winningNumbers);

        LottoResult lottoResult = lottoTickets.calculate(Lotto.of(winningNumbers));

        ResultView.printStatistics(lottoResult.getStatistics());
        ResultView.printRating(lottoResult.getStatistics(), totalPrice);
    }
}
