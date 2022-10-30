package lotto.controller;

import lotto.domain.*;
import lotto.domain.Number;
import lotto.view.Input;
import lotto.view.Output;

import java.util.Set;

public class LottoController {

    public static void main(String[] args) {
        Money money = Input.inputPrice();
        Lottos manualLottos = Input.inputManualLotto(Input.inputManuallyPurchaseCount());
        money.minus(manualLottos.totalPrice());

        LottoShop lottoShop = new LottoShop(new RandomNumberStrategy());
        Lottos lottos = lottoShop.buy(money);

        Lottos mergedLotto = manualLottos.merge(lottos);
        Output.printPurchasedLotto(mergedLotto);

        Set<Number> winnerNumbers = Input.inputWinnersNumber();
        Number bonusNumber = Input.inputBonusNumber();
        Output.printResult(mergedLotto.getResult(new WinnerNumbers(winnerNumbers, bonusNumber)));
    }
}
