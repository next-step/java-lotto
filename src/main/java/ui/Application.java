package ui;

import lotto.Lotto;
import lotto.LottoFactory;
import lotto.WinningResult;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        WinningResult winningResult = new WinningResult();

        inputView.saveAmount();
        inputView.saveCount();

        List<Lotto> lottos = LottoFactory.generateLottoNumbers(inputView.count);

        for (int i = 0; i < lottos.size(); i++) {
            System.out.println(lottos.get(i));
        }

        inputView.saveWinningNumber();
        winningResult.calculateWinningResult(lottos, inputView.getWinningNumbers());
        ResultView.printResult(winningResult.getWinningResult());

        ResultView.printRatioOfReturn(winningResult.calculateRateOfReturn(inputView.amount));
    }
}
