package step4.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;
import step4.domain.LottoGame;
import step4.domain.LottoNumbers;
import step4.domain.LottoResult;
import step4.domain.Prize;
import step4.domain.Ticket;
import step4.dto.TicketDTO;
import step4.view.InputView;
import step4.view.OutputView;

public class LottoGameController {

    public TicketDTO prepareLottoTicket() {
        final int purchasePrice = InputView.inputPrice();
        final int countOfManualTicket = InputView.inputManualLottoCount();
        return TicketDTO.of(purchasePrice, countOfManualTicket);
    }

    public Ticket prepareManualLottoTicket() {
        Ticket manualLottoTicket = Ticket.from(InputView.inputManualLottoCount() * 1000);
        return manualLottoTicket;
    }

    public void playLotto(final TicketDTO ticketDTO) {
        Ticket manualTicket = ticketDTO.toManualTicket();
        Ticket autoTicket = ticketDTO.toAutoTicket();
        int purchasePrice = ticketDTO.getPurchasePrice();

        List<Set<Integer>> manualLottoNumbers = InputView.inputManualLottoNumbers(manualTicket);
        OutputView.printPurchaseResult(ticketDTO);
        final LottoGame lottoGame = LottoGame.newInstance();
        final List<LottoNumbers> lottoNumbers = lottoGame.playLotto(autoTicket, manualLottoNumbers);
        OutputView.printLottoNumbers(lottoNumbers);

        final LottoResult lottoResult = LottoResult.from(InputView.inputWinningNumbers());
        int bonusBall = InputView.inputBonusBall();

        final Map<Prize, Integer> drawLottoResult = lottoResult.drawLottoResult(lottoNumbers, bonusBall);
        OutputView.printDrawResult(drawLottoResult);
        final int totalIncome = Prize.calculateTotalIncome(drawLottoResult);
        OutputView.printGrossReturn(purchasePrice, totalIncome);
    }
}
