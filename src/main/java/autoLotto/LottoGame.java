package autoLotto;

import java.util.List;
import java.util.Set;

public class LottoGame {
    private LottoGenerator lottoGenerator = new LottoGenerator();
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private LottoValidator lottoValidator = new LottoValidator();

    void play() {
        int budget = inputView.getLottoBudget();
        outputView.printLottoCount(budget);

        LottoResult lottoResult = new LottoResult(budget);

        List<List<Integer>> boughtLottos = lottoGenerator.generateLottos(lottoResult.getPurchasedLottoCount());
        boughtLottos.forEach(outputView::printLotto);

        Set<Integer> winningNumber = inputView.getLottoWinningNumber();
        lottoValidator.validateInputLotto(winningNumber);

        boughtLottos.forEach(boughtLotto -> processLottoResult(lottoResult, boughtLotto, winningNumber));

        outputView.printLottoResult(lottoResult);
    }

    private void processLottoResult(LottoResult lottoResult, List<Integer> boughtLotto, Set<Integer> winningNumber) {
        boughtLotto.retainAll(winningNumber);
        lottoResult.addMatchCount(LottoPrize.valueOf(boughtLotto.size()));
    }


    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        lottoGame.play();
    }
}
