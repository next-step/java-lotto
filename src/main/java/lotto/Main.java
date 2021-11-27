package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.Lottos;

import lotto.domain.WinningLotto;
import lotto.domain.starategy.GetRandomLottoNumbers;
import lotto.view.Input;
import lotto.view.Output;

import static lotto.domain.Lotto.PRICE;

public class Main {
    public static void main(String[] args) {
        Integer purchaseAmount = Input.inputPurchaseAmount();
        int manualLottoCount = Input.inputManualLottoCount();
        Lottos manualLottos = Input.inputManualLottos(manualLottoCount);
        int randomLottoCount = purchaseAmount / PRICE - manualLottoCount;
        Lottos randomLottos = Lottos.ofStrategy(randomLottoCount, new GetRandomLottoNumbers());
        Output.viewPurchasedLotto(randomLottos);
        String winningLottoString = Input.inputWinningNumbers();
        LottoNumber bonus = Input.inputBonusBall();
        WinningLotto winningLotto = WinningLotto.ofStringAndBonusBall(winningLottoString, bonus);
        manualLottos.mergeLottos(randomLottos);
        Output.viewResult(manualLottos, purchaseAmount, winningLotto, bonus);
    }
}
