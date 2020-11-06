package lotto.controller;

import lotto.domain.WinningStatistics;
import lotto.domain.lotto.Lottos;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class LottoController {
    private LottoController() {
    }

    public static void main(String[] args) {
        PrintWriter output = new PrintWriter(System.out, true);
        InputView inputView = new InputView(new Scanner(System.in), output);
        int money = inputView.getMoney();
        Lottos lottos = Lottos.withMoney(money);
        ResultView resultView = new ResultView(output);
        resultView.showLottos(lottos);
        List<Integer> lastLottoNumbers = inputView.getLastLottoNumbers();
        WinningStatistics winningStatistics = lottos.getWinningStatistics(lastLottoNumbers);
        int revenue = winningStatistics.calculateRevenue();
        double yield = revenue / (double) money;

        resultView.showResult(winningStatistics, yield);

        output.close();
    }
}
