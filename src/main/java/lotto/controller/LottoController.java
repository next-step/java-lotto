package lotto.controller;

import lotto.domain.WinningStatistics;
import lotto.domain.lotto.Lottos;
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

        int money = inputView.getMoney();
        Lottos lottos = Lottos.withMoney(money);
        resultView.showLottos(lottos);
        WinningStatistics winningStatistics = lottos.getWinningStatistics(inputView.getLastLottoNumbers());
        resultView.showResult(winningStatistics, getYield(money, winningStatistics.calculateRevenue()));

        output.close();
    }

    private static double getYield(int money, int revenue) {
        if (money == 0) {
            return 0;
        }
        return revenue / (double) money;
    }
}
