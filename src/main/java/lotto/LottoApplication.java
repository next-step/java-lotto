package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoCalculator;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
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
        LottoCalculator calculator = new LottoCalculator();
        LottoResult result = calculator.calculate(purchaseAmount, lottoList, winningNumbers);
        ResultView.printResult(result);
    }
}
