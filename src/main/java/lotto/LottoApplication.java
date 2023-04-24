package lotto;

import java.util.Map;
import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningNumbers.Rank;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoApplication {

    public static void main(String[] args) {
        while (!isEnd()) {
        }
    }

    private static boolean isEnd() {
        try {
            run();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private static void run() {
        int amount = InputView.askAmount();
        Lottos lottos = new Lottos(Lottos.lottoList( amount / Lottos.LOTTO_AMOUNT));
        InputView.printPurchaseComplete(lottos);

        WinningNumbers winningNumbers = new WinningNumbers(InputView.askWinningNumbers());
        Map<Rank, Integer> result = winningNumbers.winningResult(lottos);

        OutputView.printRanking(result, amount);
    }

}
