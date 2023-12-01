package lotto.controller;

import lotto.domain.Buyer;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;

public class LottoController {
    public static void main(String[] args) {
        Buyer buyer = new Buyer();
        WinningNumbers winningNumbers;
        int inputMoney = InputView.inputMoney();

        buyer.purchaseLottoTicket(inputMoney);

        String inputWinningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumbers();
        winningNumbers = new WinningNumbers(inputWinningNumbers, bonusNumber);

        buyer.checkLottoWinningNumbers(buyer.purchasedLottoTicket, winningNumbers);
    }
}
