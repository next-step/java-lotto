package step2;

import step2.controller.LottoMachine;
import step2.domain.Lottos;
import step2.domain.WinningResult;
import step2.view.InputView;
import step2.view.ResultView;

public class LottoApplication {
    private static final LottoMachine lottoMachine = LottoMachine.create();

    public static void main(String[] args) {
        //input cash
        int price = InputView.inputCash();

        //purchase lotto
        Lottos purchasedLottos = lottoMachine.purchase(price);
        ResultView.showLottoGenerateCount(purchasedLottos);
        ResultView.showAllLottoNumbers(purchasedLottos);
        System.out.println();

        //input last week lotto number
        String winningNumbers = InputView.inputLastWeekLottoNumber();
        WinningResult winningResult = lottoMachine.winningResult(purchasedLottos, winningNumbers);
        System.out.println();

        ResultView.showWinningStatistics(price, winningResult);
    }
}
