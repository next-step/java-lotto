package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.RandomNumberCreation;
import lotto.domain.WinningNumber;
import lotto.dto.LottoNumbersDto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public static void main(String[] args) {
        Lotto lotto = new Lotto();
        int purchaseAmount = InputView.inputPurchaseAmount();
        lotto.createLottoNumbers(purchaseAmount);
        OutputView.outputLottoCount(lotto.getLottoCount());
        OutputView.outputLottoNumbers(LottoNumbersDto.of(lotto.getLottoNumbers()));

        WinningNumber winningNumber
                = new WinningNumber(InputView.inputLastWinningNumber());

        OutputView.outputLottoStatistics(lotto.calculateLottoStatistics(winningNumber));
    }
}
