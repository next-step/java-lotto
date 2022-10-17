package step3.controller;

import java.util.List;
import java.util.Map;
import step3.domain.LottoGame;
import step3.domain.LottoNumbers;
import step3.domain.LottoResult;
import step3.domain.Prize;
import step3.domain.Ticket;
import step3.view.InputView;
import step3.view.OutputView;

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
        int bonusBall = InputView.inputBonusBall();

        final Map<Prize, Integer> drawLottoResult = lottoResult.drawLottoResult(lottoNumbers, bonusBall);
        OutputView.printDrawResult(drawLottoResult);
        final int totalIncome = Prize.calculateTotalIncome(drawLottoResult);
        OutputView.printGrossReturn(ticket, totalIncome);
    }
}
