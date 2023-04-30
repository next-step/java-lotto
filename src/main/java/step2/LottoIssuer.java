package step2;

import step2.domain.Lottos;
import step2.view.InputView;

public class LottoIssuer {

    public static void main(String[] args) {
        int purchaseAmount = InputView.getInputOfPurchasePrice();
        Lottos lottos = new Lottos(purchaseAmount);
        String winningNumbersInput = InputView.getInputOfWinningNumbers();
    }
}
