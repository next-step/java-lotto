package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        int purchaseAmount = InputView.getPurchaseAmount();
        LottoMachine machine = new LottoMachine();
        List<Lotto> lottoList = machine.buy(purchaseAmount);
        ResultView.printLotto(lottoList);
        List<Integer> winningNumbers = InputView.getWinningNumbers();
        int bonusNumber = InputView.getBonusNumber();
        LottoWinnings lottoWinnings = new LottoWinnings(winningNumbers, bonusNumber);
        LottoCalculator calculator = new LottoCalculator();
        LottoResult result = calculator.calculate(purchaseAmount, lottoList, lottoWinnings);
        ResultView.printResult(result);
    }
}
