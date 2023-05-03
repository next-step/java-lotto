package ui;

import lotto.LottoFactory;
import lotto.WinningResult;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        WinningResult winningResult = new WinningResult();

        inputView.saveAmount();
        inputView.saveCount();

        Map<Integer, List<Integer>> lottoNumbers = LottoFactory.generateLottoNumbers(inputView.count);

        for (int i = 0; i < lottoNumbers.size(); i++) {
            System.out.println(lottoNumbers.get(i));
        }

        inputView.saveWinningNumber();
        winningResult.calculateWinningResult(lottoNumbers, inputView.getWinningNumbers());
        ResultView.printResult(winningResult.getWinningResult());

        ResultView.printRatioOfReturn(winningResult.calculateRateOfReturn(inputView.amount));
    }
}
