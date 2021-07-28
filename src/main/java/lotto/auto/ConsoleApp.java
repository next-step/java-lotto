package lotto.auto;

import lotto.auto.model.LottoMachine;
import lotto.auto.io.InputView;
import lotto.auto.io.ResultView;
import lotto.auto.model.LottoGame;
import lotto.auto.strategy.AutoLotto;

import java.util.List;

public class ConsoleApp {
    public static void main(String[] args) {
        LottoMachine lottoMachine = LottoMachine.from(AutoLotto.init());

        int money = InputView.inputPayment();
        ResultView.printGameCount(money);

        List<LottoGame> lottoGames = lottoMachine.ticketing(money);
        ResultView.printGame(lottoGames);

        System.out.println();

        int[] numbers = InputView.inputWinningNumbers();
        ResultView.printStatistic(lottoMachine.producingStatistic(numbers, lottoGames));
    }
}
