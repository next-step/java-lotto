package lotto;

import lotto.domain.Lottos;
import lotto.domain.Numbers;
import lotto.domain.Rank;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Map;

public class LottoApplication {

    private static final InputView inputView = InputView.getInstance();
    private static final ResultView resultView = ResultView.getInstance();

    public static void main(String[] args) {
        LottoController lottoController = new LottoController();

        int cash = inputView.inputPurchaseAmount();
        Lottos lottos = lottoController.createAutoLotto(cash);
        resultView.printLottos(lottoController.findLottos(lottos));

        Numbers winnerNumbers = new Numbers(inputView.inputWinnerNumbers());
        Numbers bonusNumbers = new Numbers(inputView.inputBonusNumber());

        Map<Rank, Integer> rankInfo = lottos.findRanks(winnerNumbers, bonusNumbers);
        resultView.printWinners(rankInfo);
        resultView.printProfitRate(lottoController.findLottoSize(lottos), rankInfo);
    }
}
