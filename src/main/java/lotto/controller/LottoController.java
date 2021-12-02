package lotto.controller;

import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.LottosBuyer;
import lotto.domain.WinningLotto;
import lotto.view.Input;
import lotto.view.Output;

public class LottoController {
    public static void main(String[] args) {
        Integer purchaseAmount = Input.inputPurchaseAmount();
        int manualLottoCount = Input.inputManualLottoCount();

        LottosBuyer lottosBuyer = LottosBuyer.of(purchaseAmount, manualLottoCount);
        lottosBuyer.buyManualLottos(Input.inputManualLottos(manualLottoCount));
        Lottos randomLottos = lottosBuyer.buyRandomLottos();
        Output.viewPurchasedLotto(randomLottos);

        String winningLottoString = Input.inputWinningNumbers();
        LottoNumber bonus = Input.inputBonusBall();
        WinningLotto winningLotto = WinningLotto.ofStringAndBonusBall(winningLottoString, bonus);

        Lottos allLottos = lottosBuyer.getLottos();
        Output.viewResult(allLottos, purchaseAmount, winningLotto, bonus);
    }
}
