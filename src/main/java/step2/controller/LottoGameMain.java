package step2.controller;

import step2.domain.LottoGame;
import step2.domain.LottoGenerator;
import step2.view.InputView;
import step2.view.ResultView;

public class LottoGameMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        int price = inputView.inputPrice();
        resultView.printPriceResult(price);

        LottoGenerator lottoGenerator = new LottoGenerator();
        LottoGame lottoGame = new LottoGame(lottoGenerator.generateLottos(price));
        resultView.printLottos(lottoGame.getLottos());

        //String lastWeekWinningNumbers = inputView.inputLastWeekWinningNumbers();

    }
}
