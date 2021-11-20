package lotto;

import lotto.domain.Lottos;
import lotto.domain.RandomNumberGenerator;
import lotto.view.Input;
import lotto.view.Output;

public class Application {
    public static void main(String[] args) {
        int purchaseAmount = Input.askPurchaseAmount();

        Lottos lottos = Lottos.from(purchaseAmount, new RandomNumberGenerator());

        Output.printLottosCount(lottos);
        Output.printLottos(lottos);
    }
}
