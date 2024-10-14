package lotto;

import lotto.domain.LottoShuffleGenerator;
import lotto.domain.Lottos;
import lotto.domain.WinningCheck;
import lotto.domain.WinningNumber;
import lotto.service.WinningStatistic;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Main {
    public static void main(String[] args) {


        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        WinningNumber winningNumber = new WinningNumber();
        Lottos lottos = new Lottos();

        int amount = inputView.inputPurchaseAmountGuide();

        lottos.buyLotto(amount,LottoShuffleGenerator.getLottoShuffleGenerator());

        resultView.NumberOfLotto(lottos.getNumberOfLotto());
        resultView.printPurchasedLottos(lottos);
        winningNumber.convertStringToIntList(inputView.inputWinnerNumber());
        WinningCheck winningCheck = new WinningCheck(lottos,winningNumber);
        WinningStatistic winningStatistic = new WinningStatistic();
        int prize = winningCheck.getWinningPrize();
        winningStatistic.calculateStatistic(prize);
        resultView.printResult(winningStatistic.getStatistic());
        resultView.printProfit(winningStatistic.calculateProfit(1000*lottos.getNumberOfLotto(),prize));
    }
}
