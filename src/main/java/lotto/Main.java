package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.Lottos;

import lotto.domain.WinningLotto;
import lotto.domain.starategy.GetRandomLottoNumbers;
import lotto.view.Input;
import lotto.view.Output;

public class Main {
    public static void main(String[] args) {
        Integer purchaseAmount = Input.inputPurchaseAmount();
        Lottos lottos = Lottos.createRandomLottos(purchaseAmount, new GetRandomLottoNumbers());
        Output.viewPurchasedLotto(lottos);
        String winningLottoString = Input.inputWinningNumbers();
        LottoNumber bonus = Input.inputBonusBall();
        WinningLotto winningLotto = new WinningLotto(winningLottoString, bonus);
        Output.viewResult(lottos, purchaseAmount, winningLotto, bonus);
    }
}
