package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        LottoMachine lottoMachine = new LottoMachine();

        Money money = new Money(inputView.askPurchaseAmount());

        Lotties lotties = lottoMachine.createRandomLotties(money);

        ResultView resultView = new ResultView();
        resultView.printLotties(lotties);

        WinningNumbers winningNumbers = new WinningNumbers(inputView.getWinningNumber());

        lotties.matchLottiesRank(winningNumbers);

        WinningStatistics winningStatistics = lotties.getLottiesRank();

        resultView.printSameNumbers(winningStatistics);
    }
}
