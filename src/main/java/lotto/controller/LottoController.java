package lotto.controller;

import lotto.domain.*;
import lotto.view.Input;
import lotto.view.Output;

public class LottoController {
    public static void main(String[] args) {
        Integer purchaseAmount = Input.inputPurchaseAmount();
        int manualLottoCount = Input.inputManualLottoCount();

        LottosBuyer lottosBuyer = new LottosBuyer(purchaseAmount, manualLottoCount);
        Lottos manualLottos = Input.inputManualLottos(manualLottoCount);
        Lottos randomLottos = lottosBuyer.buyRandomLottos();
        Lottos totalLottos = lottosBuyer.getTotalLottos(manualLottos, randomLottos);
        Output.viewPurchasedLotto(totalLottos);

        String winningLottoString = Input.inputWinningNumbers();
        LottoNumber bonus = Input.inputBonusBall();
        WinningLotto winningLotto = WinningLotto.ofStringAndBonusBall(winningLottoString, bonus);

        LottosRecord lottosRecord = LottosRecord.of(totalLottos, winningLotto, bonus, purchaseAmount);

        Output.viewResult(lottosRecord);
    }
}
