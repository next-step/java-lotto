package step4.controller;

import step4.domain.*;
import step4.dto.ManualLottoNumberDTO;
import step4.dto.TicketDTO;
import step4.view.InputView;
import step4.view.OutputView;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class LottoGameController {

    public TicketDTO prepareLottoTicket() {
        final int purchasePrice = InputView.inputPrice();
        final int countOfManualTicket = InputView.inputManualLottoCount();
        return TicketDTO.of(purchasePrice, countOfManualTicket);
    }

    public void playLotto(final TicketDTO ticketDTO) {
        Ticket manualTicket = ticketDTO.toManualTicket();
        Ticket autoTicket = ticketDTO.toAutoTicket();
        int purchasePrice = ticketDTO.getPurchasePrice();

        List<ManualLottoNumberDTO> manualLottoNumbers = InputView.inputManualLottoNumbers(manualTicket);
        OutputView.printPurchaseResult(ticketDTO);
        final LottoGame lottoGame = LottoGame.newInstance();
        final List<LottoNumbers> lottoNumbers = lottoGame.playLotto(autoTicket, manualLottoNumbers);
        OutputView.printLottoNumbers(lottoNumbers);

        final Set<LottoNumber> winningNumbers = InputView.inputWinningNumbers();
        final LottoNumber bonusNumber = LottoNumber.from(InputView.inputBonusBall());
        final LottoResult lottoResult = LottoResult.of(winningNumbers, bonusNumber);

        lottoResult.drawLottoResult(lottoNumbers);
        OutputView.printDrawResult(lottoResult);
        Map<Prize, Integer> drawLottoResult = lottoResult.getLottoResult();
        final int totalIncome = Prize.calculateTotalIncome(drawLottoResult);
        OutputView.printGrossReturn(purchasePrice, totalIncome);
    }
}
