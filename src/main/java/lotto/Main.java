package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoRandomGenerator;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Integer purchaseAmount = InputView.scanPurchaseAmount();
        Lottos lottos = new Lottos(new LottoRandomGenerator(), purchaseAmount);
        ResultView.printPurchase(lottos);

        List<Integer> winningNumbers = InputView.scanWinningNumbers();
        ResultView.printWinningStatistics(lottos, new Lotto(winningNumbers));
    }
}
