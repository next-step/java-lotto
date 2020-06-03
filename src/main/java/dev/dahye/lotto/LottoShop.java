package dev.dahye.lotto;

import dev.dahye.lotto.domain.LottoResult;
import dev.dahye.lotto.service.LottoMachine;
import dev.dahye.lotto.view.InputView;
import dev.dahye.lotto.view.ResultView;

public class LottoShop {
    public static void main(String[] args) {
        int money = InputView.doInputMoney();

        LottoMachine lottoMachine = new LottoMachine(money);
        ResultView.printPurchasedLottoTickets(lottoMachine.getLottoTickets());

        String winningNumbers = InputView.doInputWinningNumbers();
        LottoResult lottoResult = new LottoResult(lottoMachine.getLottoTickets(), winningNumbers);

        ResultView.printWinningStatistics(lottoResult);
        ResultView.printWinningRate(lottoResult.getMyWinningRate(money));
    }
}
