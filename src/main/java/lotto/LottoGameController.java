package lotto;

import lotto.domain.LottoNumberMaker;
import lotto.domain.Lottos;
import lotto.domain.SeedMoney;
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

        SeedMoney seedMoney = InputView.askAndShowLottoGameMoney();

        Lottos lottos = LottoNumberMaker.generate(seedMoney.round());

        WinningNumber winningNumber = ResultView.askWinningNumber();

        WinningStatistics statistics = lottos.winningStatistics(winningNumber);

        ResultView.showResults(statistics, seedMoney.amount());

        SCANNER.close();
    }


}
