package lotto;

import lotto.domain.Lottos;

import lotto.domain.Number;
import lotto.domain.WinningNumbers;
import lotto.domain.starategy.GetRandomLottoNumbers;
import lotto.view.Input;
import lotto.view.Output;

public class Main {
    public static void main(String[] args) {
        Integer purchaseAmount = Input.inputPurchaseAmount();
        Lottos lottos = new Lottos(purchaseAmount, new GetRandomLottoNumbers());
        Output.viewPurchasedLotto(lottos);
        WinningNumbers winningNumbers = Input.inputWinningNumbers();
        Number bonus = Input.inputBonusBall();
        Output.viewResult(lottos, purchaseAmount,winningNumbers , bonus);
    }
}
