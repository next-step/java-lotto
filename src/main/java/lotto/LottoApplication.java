package lotto;

import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        long amount = InputView.readPurchaseAmount();

        List<Integer> winningNumbers = InputView.readWinningNumbers();
    }

}
