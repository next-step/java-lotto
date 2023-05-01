package step2;

import step2.domain.Lottos;
import step2.view.InputView;

import java.util.List;

public class LottoIssuer {
    public static void main(String[] args) {
        int purchaseAmount = InputView.getInputOfPurchasePrice();
        Lottos lottos = new Lottos(purchaseAmount);
        InputView.printLottos(lottos.toString());

        List<Integer> winningNumbersInput = InputView.getInputOfWinningNumbers();
    }
}
