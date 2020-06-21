package step2.controller;

import java.util.ArrayList;
import java.util.List;
import step2.domain.LottoGame;
import step2.domain.LottoNumber;
import step2.domain.LottoSheet;
import step2.domain.UserLotto;
import step2.domain.UserPrice;
import step2.domain.WinningLotto;
import step2.util.Utils;
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
            LottoSheet manualLottoSheet = null;
            if (manualLottoCount > 0) {
                List<List<Integer>> manualLottos = inputView.inputManualLotto(manualLottoCount);
                List<UserLotto> manualUserLottos = new ArrayList<>();
                for (List<Integer> manualLotto : manualLottos) {
                    manualUserLottos
                        .add(new UserLotto(Utils.convertIntegerToLottoNumberList(manualLotto)));
                }
                manualLottoSheet = new LottoSheet(manualUserLottos);
            }

            LottoGame lottoGame = new LottoGame(userPrice, manualLottoSheet);

            lottoGame.run();

            resultView.printPriceResult(userPrice, manualLottoCount);
            resultView.printLottos(lottoGame.getLottoSheet());

            List<Integer> lastWeekWinningNumbers = inputView.inputLastWeekWinningNumbers();
            int bonusNumber = inputView.inputBonusNumber();

            List<LottoNumber> lastWeekWinningLottoNumbers = new ArrayList<>();
            lastWeekWinningNumbers
                .forEach(number -> lastWeekWinningLottoNumbers.add(new LottoNumber(number)));

            resultView.printStatistic(
                lottoGame.getGameResult(
                    new WinningLotto(lastWeekWinningLottoNumbers, new LottoNumber(bonusNumber))));

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
    }
}
