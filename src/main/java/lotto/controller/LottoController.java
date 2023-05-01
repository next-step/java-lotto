package lotto.controller;

import lotto.domain.LottoManager;
import lotto.domain.LottoNumber;
import lotto.domain.WinningTicket;
import lotto.dto.LottoNumbersDto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    public static void main(String[] args) {
        LottoManager lottoManager = new LottoManager();
        int purchaseAmount = InputView.inputPurchaseAmount();
        lottoManager.createLottoNumbers(purchaseAmount);
        OutputView.outputLottoCount(lottoManager.getLottoCount());
        OutputView.outputLottoNumbers(LottoNumbersDto.of(lottoManager.getLottoNumbers()));

        List<Integer> winningNumbers = InputView.inputLastWinningNumber();
        LottoNumber bonusBallNumber = new LottoNumber(InputView.inputBonusBallNumber());
        WinningTicket winningTicket
                = new WinningTicket(winningNumbers, bonusBallNumber);
        OutputView.outputLottoStatistics(lottoManager.calculateLottoStatistics(winningTicket));
    }
}
