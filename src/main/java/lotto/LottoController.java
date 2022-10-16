package lotto;

import lotto.view.Input;
import lotto.view.Output;

public class LottoController {

    public static void main(String[] args) {
        Output.printPurchaseRequest();
        int inputPrice = Input.inputPrice();

        LottoShop lottoShop = new LottoShop(new RandomNumberStrategy());
        Lottos lottos = lottoShop.buy(new Money(inputPrice));
        Output.printPurchasedLotto(lottos);

        Output.printWinnerNumbersRequest();
        Output.printResult(lottos, Input.inputWinnerNumbers());
    }
}
