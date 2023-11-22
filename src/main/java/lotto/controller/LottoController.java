package lotto.controller;

import lotto.domain.Buyer;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;

public class LottoController {
    public static void main(String[] args) {
        Buyer buyer = new Buyer();
        WinningNumbers winningNumbers;
        String inputMoney = InputView.inputMoney();

        buyer.purchaseLotto(Integer.parseInt(inputMoney));

        String inputWinningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumbers();
        winningNumbers = new WinningNumbers(inputWinningNumbers, bonusNumber);

        buyer.checkLottoWinningNumbers(buyer, winningNumbers);
    }
}
