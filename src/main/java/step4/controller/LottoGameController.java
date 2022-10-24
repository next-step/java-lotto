package step4.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;
import step4.domain.LottoGame;
import step4.domain.LottoNumbers;
import step4.domain.LottoResult;
import step4.domain.Prize;
import step4.domain.Ticket;
import step4.view.InputView;
import step4.view.OutputView;

public class LottoGameController {

    public Ticket prepareLottoTicket() {
        final Ticket ticket = Ticket.from(InputView.inputPrice());
        return ticket;
    }

    public Ticket prepareManualLottoTicket() {
        Ticket manualLottoTicket = Ticket.from(InputView.inputManualLottoCount() * 1000);
        return manualLottoTicket;
    }

    public void playLotto(final Ticket ticket, final Ticket manualLottoTicket) {
        List<Set<Integer>> manualLottoNumbers = InputView.inputManualLottoNumbers(manualLottoTicket);
        OutputView.printPurchaseResult(ticket, manualLottoTicket);
        final LottoGame lottoGame = LottoGame.newInstance();
        final List<LottoNumbers> lottoNumbers = lottoGame.playLotto(ticket, manualLottoNumbers);
        OutputView.printLottoNumbers(lottoNumbers);

        final LottoResult lottoResult = LottoResult.from(InputView.inputWinningNumbers());
        int bonusBall = InputView.inputBonusBall();

        final Map<Prize, Integer> drawLottoResult = lottoResult.drawLottoResult(lottoNumbers, bonusBall);
        OutputView.printDrawResult(drawLottoResult);
        final int totalIncome = Prize.calculateTotalIncome(drawLottoResult);
        OutputView.printGrossReturn(ticket, totalIncome);
    }
}
