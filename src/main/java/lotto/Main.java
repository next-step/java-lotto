package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoStatistics;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class Main {
    static InputView inputView = new InputView();
    static ResultView resultView = new ResultView();
    static Lotto lotto = new Lotto();

    public static void main(String[] args) {
        int lottoQuantity = lotto.lottoQuantity(inputView.inputCost());
        resultView.lottoCountPrint(lottoQuantity);
        List<List<Integer>> purchasedLottery = lotto.getPurchasedLottery(lottoQuantity);
        resultView.printLotto(purchasedLottery);

        LottoStatistics lottoStatistics = new LottoStatistics(inputView.inputWinningNumber());
        resultView.winningResult(lottoStatistics.winningRank(purchasedLottery));
    }
}
