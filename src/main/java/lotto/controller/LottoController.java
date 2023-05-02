package lotto.controller;

import lotto.domain.LottoTicketMachine;
import lotto.domain.LottoNumber;
import lotto.domain.WinningTicket;
import lotto.dto.LottoNumbersDto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    public static void main(String[] args) {
        LottoTicketMachine lottoTicketMachine = new LottoTicketMachine();
        int purchaseAmount = InputView.inputPurchaseAmount();
        lottoTicketMachine.createLottoNumbers(purchaseAmount);
        OutputView.outputLottoCount(lottoTicketMachine.getLottoCount());
        OutputView.outputLottoNumbers(LottoNumbersDto.of(lottoTicketMachine.getLottoNumbers()));

        List<Integer> winningNumbers = InputView.inputLastWinningNumber();
        LottoNumber bonusBallNumber = new LottoNumber(InputView.inputBonusBallNumber());
        WinningTicket winningTicket
                = new WinningTicket(winningNumbers, bonusBallNumber);
        OutputView.outputLottoStatistics(lottoTicketMachine.calculateLottoStatistics(winningTicket));
    }
}
