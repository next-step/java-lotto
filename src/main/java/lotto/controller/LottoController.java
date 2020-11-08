package lotto.controller;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.Money;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.winning.WinningStatistics;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.io.PrintWriter;
import java.util.Scanner;

public class LottoController {
    private LottoController() {
    }

    public static void main(String[] args) {
        PrintWriter output = new PrintWriter(System.out, true);
        InputView inputView = new InputView(new Scanner(System.in), output);
        ResultView resultView = new ResultView(output);

        Money money = Money.of(inputView.getMoney());
        int manualLottoCount = inputView.getManualLottoCount();
        Lottos lottos = Lottos.withMoneyAndManualLottoNumbers(money, inputView.getManualLottoNumbers(manualLottoCount));

        resultView.showLottos(lottos, manualLottoCount);
        WinningStatistics winningStatistics = lottos.getWinningStatistics(
                WinningLotto.of(Lotto.ofNumbers(inputView.getLastLottoNumbers()), LottoNumber.of(inputView.getBonusLottoNumber())));
        resultView.showResult(winningStatistics, winningStatistics.calculateYield(money));

        output.close();
    }
}
