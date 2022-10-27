package step4.controller;

import step4.domain.*;
import step4.dto.ManualLottoNumberDTO;
import step4.dto.TicketDTO;
import step4.view.InputView;
import step4.view.OutputView;

import java.util.List;
import java.util.Map;

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
;
        final LottoResult lottoResult = LottoResult.from(InputView.inputWinningNumbers());
        LottoNumber bonusBall = LottoNumber.from(InputView.inputBonusBall());

        final Map<Prize, Integer> drawLottoResult = lottoResult.drawLottoResult(lottoNumbers, bonusBall);
        OutputView.printDrawResult(drawLottoResult);
        final int totalIncome = Prize.calculateTotalIncome(drawLottoResult);
        OutputView.printGrossReturn(purchasePrice, totalIncome);
    }
}
