package lotto;

import lotto.lottogenerator.LottoNumGeneratorByAuto;

import java.util.List;

public class MainApplication {
    public static void main(String[] args) {
        LottoNumGeneratorByAuto lottoNumGeneratorByAuto = new LottoNumGeneratorByAuto();
        String inputPrice = InputProcessor.getPurchasePrice();

        LottoGame lottoGame = new LottoGame(InputView.of(inputPrice));
        while (!lottoGame.isEnd()){
            lottoGame.start(lottoNumGeneratorByAuto);
        }
        ResultView.printMyLottos(lottoGame);

        List<Integer> winningLotto = InputProcessor.getWinningLotto();
        ResultView.printResult(lottoGame, winningLotto);
    }
}
