package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.LottoTickets;
import lotto.domain.LottoCount;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    public void start() {
        int totalPrice = InputView.inputTotalPrice();
        int manualCount = InputView.inputManualCountNumber();
        List<Lotto> manualLottos = InputView.inputManualLottoNumber(manualCount);

        LottoCount lottoCount = LottoCount.of(totalPrice, manualLottos);
        LottoTickets lottoTickets = LottoTickets.of(lottoCount);

        int tickets = lottoCount.countTotalTickets();
        ResultView.printTotalCount(tickets);
        ResultView.printResultTickets(lottoTickets.getTickets());

        List<Integer> winningNumbers = InputView.inputLottoNumberLastResult();
        int bonusBall = InputView.inputBonusBall();

        LottoResult lottoResult = lottoTickets.getResult(WinningLotto.of(winningNumbers, bonusBall));

        ResultView.printStatistics(lottoResult.getStatistics());
        ResultView.printRating(lottoResult.getStatistics(), totalPrice);
    }
}
