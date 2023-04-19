package lotto;

import java.util.List;
import java.util.Map;

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
        int cnt = amount / Lottos.LOTTO_AMOUNT;
        Lottos lottos = new Lottos(Lottos.lottoList(cnt), cnt);
        InputView.printPurchaseComplete(lottos);
        List<Number> numbers = InputView.askWinningNumbers();
        WinningNumbers winningNumbers = new WinningNumbers(numbers);
        Map<String, Integer> result = winningNumbers.winningResult(lottos);
        OutputView.printRanking(result, amount);
    }

}
