package step2.controller;

import java.util.List;
import java.util.Map;
import step2.domain.LottoGame;
import step2.domain.LottoNumber;
import step2.domain.LottoResult;
import step2.domain.Ticket;
import step2.view.InputView;
import step2.view.OutputView;

public class LottoGameController {

    public Ticket prepareLottoTicket() {
        OutputView.printPriceNotification();
        final Ticket ticket = Ticket.from(InputView.inputPrice());
        OutputView.printPurchaseResult(ticket);
        return ticket;
    }

    public void playLotto(final Ticket ticket) {
        final LottoGame lottoGame = LottoGame.newInstance();
        final List<LottoNumber> lottoNumbers = lottoGame.playLotto(ticket);
        OutputView.printLottoNumbers(lottoNumbers);
        OutputView.printWinningNumberNotification();
        final List<Integer> winningNumbers = InputView.inputWinningNumbers();
        final LottoResult lottoResult = LottoResult.from(winningNumbers);
        final Map<Integer, Integer> drawLottoResult = lottoResult.drawLottoResult(lottoNumbers);
        OutputView.printDrawResult(drawLottoResult);
        OutputView.printGrossReturn(ticket);
    }
}
