package kr.heesu.lotto.controller;

import kr.heesu.lotto.domain.LottoResult;
import kr.heesu.lotto.domain.MultipleLotto;
import kr.heesu.lotto.domain.PurchaseAmount;
import kr.heesu.lotto.domain.WinningNumbers;
import kr.heesu.lotto.utils.LottoFactory;
import kr.heesu.lotto.view.ViewResolver;

public class LottoController {

    private final ViewResolver viewResolver;

    private LottoController() {
        this.viewResolver = ViewResolver.of();
    }

    public void main() {
        try {
            PurchaseAmount amount = viewResolver.getPurchaseAmount();
            viewResolver.printPurchaseAmount(amount);

            MultipleLotto multipleLotto = LottoFactory.createMultipleLottos(amount);
            viewResolver.printMultipleLotto(multipleLotto);

            WinningNumbers winningNumbers = viewResolver.getWinningNumbers();

            LottoResult result = multipleLotto.matches(winningNumbers);

            viewResolver.printLottoResult(result);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
    }

    public static LottoController of() {
        return new LottoController();
    }
}
