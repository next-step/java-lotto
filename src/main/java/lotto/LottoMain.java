package lotto;

import lotto.domain.Lottos;
import lotto.domain.Winner;
import lotto.ui.LottoScanner;

public class LottoMain {
    public static void main(String[] args) {
        int purchaseAmount = LottoScanner.insertPurchaseAmount();
        Lottos lottos = Lottos.of(purchaseAmount/1000);

        String s = LottoScanner.insertWinningNumbers();
        Winner winner = Winner.of(s);
    }
}
