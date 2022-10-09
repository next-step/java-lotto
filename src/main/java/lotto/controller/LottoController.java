package lotto.controller;

import java.util.List;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoResult;
import lotto.domain.LottoTickets;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    public LottoController() {
        int totalPrice = InputView.inputTotalPrice();
        ResultView.printTotalCount(totalPrice);
        LottoTickets lottoTickets = LottoTickets.from(totalPrice);
        ResultView.printResultTickets(lottoTickets.createTickets());
        List<LottoNumber> winningNumbers = InputView.inputLottoNumberLastResult();
        ResultView.printWinningNumber(winningNumbers);
        LottoResult result = lottoTickets.result(LottoNumbers.of(winningNumbers));
        ResultView.printStatistics(result.result());

        ResultView.printRating(result.result(), totalPrice);
    }
}
