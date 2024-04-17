package lotto;

import lotto.domain.*;
import lotto.service.Shop;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        InputView input = new InputView();

        int purchasedAmount = input.inputPurchaseAmount();
        SingleOrder lottoPurchase = Shop.createLottoPurchase(purchasedAmount);

        int manualPurchaseCount = input.inputManualPurchaseCount();
        Shop.validateManualPurchaseCount(lottoPurchase, manualPurchaseCount);

        List<Lotto> purchasedLotto = Shop.getLottoList(lottoPurchase, input.inputManualLottoNumber(manualPurchaseCount));

        OutputView.showPurchasedLotto(purchasedLotto, manualPurchaseCount);

        WinningLotto winningLotto = new WinningLotto(
                WinningLotto.getWinningNumbers(input.inputWinningNumbers()),
                WinningLotto.getBonusNumber(input.inputBonusWinningNumber())
        );

        Map<LottoRank, Long> gameResult = LottoGame.getGameResult(purchasedLotto, winningLotto);

        OutputView.showResult(gameResult);
        OutputView.showROR(gameResult, purchasedAmount);
    }
}
