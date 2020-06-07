package dev.dahye.lotto;

import dev.dahye.lotto.domain.LottoResult;
import dev.dahye.lotto.domain.LottoMoney;
import dev.dahye.lotto.service.LottoMachine;
import dev.dahye.lotto.util.ConvertUtils;
import dev.dahye.lotto.view.InputView;
import dev.dahye.lotto.view.ResultView;

import java.util.List;

public class LottoShop {
    public static void main(String[] args) {
        int money = InputView.doInputMoney();

        LottoMachine lottoMachine = new LottoMachine(new LottoMoney(money));
        ResultView.printPurchasedLottoTickets(lottoMachine.getLottoTickets());

        String winningNumberInput = InputView.doInputWinningNumbers();
        int bonusNumber = InputView.doInputBonusNumber();

        List<Integer> winningNumbers = ConvertUtils.convertStringToIntegerList(winningNumberInput);
        LottoResult lottoResult = new LottoResult(lottoMachine.getLottoTickets(), winningNumbers, bonusNumber);

        ResultView.printWinningStatistics(lottoResult);
        ResultView.printWinningRate(lottoResult.getMyWinningRate(money));
    }
}
