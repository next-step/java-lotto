package lotto;

import lotto.domain.InputManualLotto;
import lotto.domain.LottoGenerator;
import lotto.domain.Lottos;
import lotto.domain.SeedMoney;
import lotto.domain.winning.WinningChecker;
import lotto.domain.winning.WinningNumber;
import lotto.domain.winning.WinningStatistics;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Scanner;

/**
 * Created By mand2 on 2020-11-19.
 */
public class LottoGameController {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

        SeedMoney seedMoney = InputView.askSeedMoney();

        InputManualLotto inputManualLotto = InputView.askManualRoundsAndLottos();

        Lottos lottos = LottoGenerator.generate(seedMoney, inputManualLotto);

        ResultView.showBoughtLottos(lottos);

        WinningNumber winningNumber = InputView.askWinningNumberAndBonus();

        WinningStatistics statistics =
                WinningChecker.of(winningNumber).winningStatistics(lottos);

        ResultView.showResults(statistics, seedMoney.amount());

        SCANNER.close();
    }

}
