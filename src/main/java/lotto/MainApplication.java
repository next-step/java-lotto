package lotto;

import lotto.controller.LottoGame;
import lotto.lottogenerator.LottoNumGeneratorByAuto;
import lotto.view.InputScanner;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class MainApplication {
    public static void main(String[] args) {
        LottoNumGeneratorByAuto lottoNumGeneratorByAuto = new LottoNumGeneratorByAuto();
        String inputPrice = InputScanner.getPurchasePrice();

        LottoGame lottoGame = new LottoGame(InputView.of(inputPrice));
        lottoGame.start(lottoNumGeneratorByAuto);
        ResultView.printMyLottos(lottoGame);

        List<Integer> winningLotto = InputScanner.getWinningLotto();
        ResultView.printResult(lottoGame, winningLotto);
    }
}