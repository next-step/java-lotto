package lotto.controller;

import lotto.domain.LottoManager;
import lotto.domain.WinningTicket;
import lotto.dto.LottoNumbersDto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public static void main(String[] args) {
        LottoManager lottoManager = new LottoManager();
        int purchaseAmount = InputView.inputPurchaseAmount();
        int bonusBallNumber = InputView.inputBonusBallNumber();
        lottoManager.createLottoNumbers(purchaseAmount);
        OutputView.outputLottoCount(lottoManager.getLottoCount());
        OutputView.outputLottoNumbers(LottoNumbersDto.of(lottoManager.getLottoNumbers()));

        WinningTicket winningTicket
                = new WinningTicket(InputView.inputLastWinningNumber(), bonusBallNumber);
        OutputView.outputLottoStatistics(lottoManager.calculateLottoStatistics(winningTicket));
    }
}
