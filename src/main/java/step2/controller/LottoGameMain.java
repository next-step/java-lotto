package step2.controller;

import java.util.List;
import step2.domain.LottoGame;
import step2.domain.LottoSheet;
import step2.domain.UserPrice;
import step2.domain.WinningLotto;
import step2.view.InputView;
import step2.view.ResultView;

public class LottoGameMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        try {
            int price = inputView.inputPrice();
            UserPrice userPrice = new UserPrice(price);

            int manualLottoCount = inputView.inputManualLottoCount();
            LottoSheet manualLottoSheet = new LottoSheet();
            if (manualLottoCount > 0) {
                manualLottoSheet = inputView.inputManualLotto(manualLottoCount);
            }

            LottoGame lottoGame = new LottoGame(userPrice, manualLottoSheet);

            lottoGame.run();

            resultView.printPriceResult(price, manualLottoCount);
            resultView.printLottos(lottoGame.getLottoSheet());

            List<Integer> lastWeekWinningNumbers = inputView.inputLastWeekWinningNumbers();
            int bonusNumber = inputView.inputBonusNumber();

            resultView.printStatistic(
                lottoGame.getGameResult(new WinningLotto(lastWeekWinningNumbers, bonusNumber)));

        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
            return;
        }
    }
}
