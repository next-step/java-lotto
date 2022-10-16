package step2.controller;

import java.util.List;
import java.util.Map;
import step2.domain.LottoGame;
import step2.domain.LottoNumberGenerator;
import step2.domain.LottoNumbers;
import step2.domain.LottoResult;
import step2.domain.Prize;
import step2.domain.Ticket;
import step2.view.InputView;
import step2.view.OutputView;

public class LottoGameController {

    public Ticket prepareLottoTicket() {
        final Ticket ticket = Ticket.from(InputView.inputPrice());
        OutputView.printPurchaseResult(ticket);
        return ticket;
    }

    public void playLotto(final Ticket ticket) {
        final LottoGame lottoGame = LottoGame.newInstance();
        final List<LottoNumbers> lottoNumbers = lottoGame.playLotto(ticket);
        OutputView.printLottoNumbers(lottoNumbers);

        final LottoResult lottoResult = LottoResult.from(InputView.inputWinningNumbers());

        final Map<Integer, Integer> drawLottoResult = lottoResult.drawLottoResult(lottoNumbers);
        OutputView.printDrawResult(drawLottoResult);
        final int totalIncome = Prize.calculateTotalIncome(drawLottoResult);
        OutputView.printGrossReturn(ticket, totalIncome);
    }
}
