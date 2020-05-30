package step2.controller;

import step2.domain.LottoGame;
import step2.view.InputView;
import step2.view.ResultView;

public class LottoGameMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        int userPrice = inputView.inputPrice();

        LottoGame lottoGame = new LottoGame(userPrice);

        try {
            lottoGame.run();

            resultView.printPriceResult(userPrice);
            resultView.printLottos(lottoGame.getLottos());

            String lastWeekWinningNumbers = inputView.inputLastWeekWinningNumbers();

            resultView.printStatistic(lottoGame.getGameResult(lastWeekWinningNumbers));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
    }
}
