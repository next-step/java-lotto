package lotto;

import java.util.Map;
import lotto.WinningNumbers.Rank;

public class LottoMain {

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
