package kr.heesu.lotto.controller;

import kr.heesu.lotto.domain.*;
import kr.heesu.lotto.utils.LottoFactory;
import kr.heesu.lotto.view.ViewResolver;

import java.util.List;

public class LottoController {

    private final ViewResolver viewResolver;

    private LottoController(ViewResolver viewResolver) {
        this.viewResolver = viewResolver;
    }

    public static LottoController of() {
        return new LottoController(ViewResolver.of());
    }

    public void main() {
        try {
            String stringAmount = viewResolver.getPurchaseAmount();
            PurchaseAmount purchaseAmount = makePurchaseAmountFromUserInput(stringAmount);

            stringAmount = viewResolver.getManualAmount();
            ManualCount count = ManualCount.of(stringAmount, purchaseAmount);

            List<String> inputs = viewResolver.getInputForManualLottos(count);
            ManualLottoInputs lottoInputs = ManualLottoInputs.of(inputs);

            viewResolver.printPurchaseAmount(purchaseAmount, count);

            Lottos multipleLotto = LottoFactory.createManualLottos(lottoInputs);
            Lottos autoLottos = LottoFactory.createAutoLottos(purchaseAmount.getSize() - count.getSize());
            multipleLotto.add(autoLottos);

            viewResolver.printMultipleLotto(multipleLotto);

            String stringWinningNumbers = viewResolver.getWinningLotto();
            Lotto lotto = LottoFactory.createLottoFromUserInput(stringWinningNumbers);

            String stringBonusNumber = viewResolver.getBonusNumbers();
            LottoNumber bonusNumber = makeLottoNumber(stringBonusNumber);

            WinningLotto winningLotto = WinningLotto.of(lotto, bonusNumber);

            RankResult matches = multipleLotto.matches(winningLotto);

            LottoStatistics statistics = makeLottoStatistics(matches, purchaseAmount);

            viewResolver.printLottoStatistics(statistics);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
    }

    private LottoNumber makeLottoNumber(String stringBonusNumber) {
        return LottoNumber.of(Integer.parseInt(stringBonusNumber));
    }

    private LottoStatistics makeLottoStatistics(RankResult matches, PurchaseAmount amount) {
        return LottoStatistics.of(matches, amount);
    }

    private PurchaseAmount makePurchaseAmountFromUserInput(String input) {
        return PurchaseAmount.of(Integer.parseInt(input));
    }
}
