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
        int manualCount = InputView.inputManualCountNumber();
        List<Lotto> manualLottos = InputView.inputManualLottoNumber(manualCount);

        LottoTickets lottoTickets = LottoTickets.of(totalPrice);

        int tickets = lottoTickets.getTicketCount();
        ResultView.printTotalCount(tickets);
        ResultView.printResultTickets(lottoTickets.getTickets());

        List<Integer> winningNumbers = InputView.inputLottoNumberLastResult();
        int bonusBall = InputView.inputBonusBall();

        LottoResult lottoResult = lottoTickets.getResult(Lotto.of(winningNumbers), LottoNumber.from(bonusBall));

        ResultView.printStatistics(lottoResult.getStatistics());
        ResultView.printRating(lottoResult.getStatistics(), totalPrice);
    }
}
