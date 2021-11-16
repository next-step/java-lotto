package step2.controller;

import step2.domain.Lottos;
import step2.view.InputView;
import step2.view.ResultView;

public class LottoMachine {

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        int price = InputView.inputCash();
        Lottos lottos = Lottos.purchase(price);

        ResultView.showLottoGenerateCount(lottos);
        ResultView.showAllLottoNumbers(lottos);
        System.out.println();

        String numbers = InputView.inputLastWeekLottoNumber();
        System.out.println();

        ResultView.showWinningStatistics();
    }
}
