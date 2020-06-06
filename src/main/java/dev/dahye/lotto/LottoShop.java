package dev.dahye.lotto;

import dev.dahye.lotto.domain.LottoResult;
import dev.dahye.lotto.domain.LottoMoney;
import dev.dahye.lotto.service.LottoMachine;
import dev.dahye.lotto.view.InputView;
import dev.dahye.lotto.view.ResultView;

public class LottoShop {
    public static void main(String[] args) {
        int money = InputView.doInputMoney();

        LottoMachine lottoMachine = new LottoMachine(new LottoMoney(money));
        ResultView.printPurchasedLottoTickets(lottoMachine.getLottoTickets());

        String winningNumbers = InputView.doInputWinningNumbers();
        int bonusNumber = InputView.doInputBonusNumber();
        LottoResult lottoResult = new LottoResult(lottoMachine.getLottoTickets(), winningNumbers, bonusNumber);

        ResultView.printWinningStatistics(lottoResult);
        ResultView.printWinningRate(lottoResult.getMyWinningRate(money));
    }
}
