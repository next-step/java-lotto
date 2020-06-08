package step2.controller;

import java.util.List;
import step2.domain.LottoGame;
import step2.domain.WinningLotto;
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

            List<Integer> lastWeekWinningNumbers = inputView.inputLastWeekWinningNumbers();
            int bonusNumber = inputView.inputBonusNumber();

            resultView.printStatistic(
                lottoGame.getGameResult(new WinningLotto(lastWeekWinningNumbers, bonusNumber)));

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
    }
}
