package lotto.controller;

import lotto.model.*;
import lotto.view.Input;
import lotto.view.Output;

import java.math.BigDecimal;
import java.util.Set;

import static lotto.util.TypeConvert.convertStringToLottoNumberSet;

public class LottoController {
    public void run() {
        purchaseCalculator purchaseCalculator = new purchaseCalculator(Input.inputMoneyForPurchase());
        int purchasedLottoCount = purchaseCalculator.calculatePurchasableCount();

        Output.printPurchasableMessage(purchasedLottoCount);

        BunchOfLotto bunchOfLotto = new BunchOfLotto(purchasedLottoCount);
        Output.printBunchOfLottoNumbers(bunchOfLotto.getBunchOfLotto());

        WinningLotto winningLotto = makeWinningLotto();
        Prizes prizes = bunchOfLotto.makeRewards(winningLotto);
        BigDecimal yield = prizes.makeYield(purchaseCalculator.getPurchaseAmount());

        Output.printWinStatics(prizes.getPrizes(), yield);
    }

    public WinningLotto makeWinningLotto() {
        Set<LottoNumber> winningNumbers = convertStringToLottoNumberSet(Input.inputWinningNumbers());
        LottoNumber bonusBall = new LottoNumber(Input.inputBonusNumber());

        return new WinningLotto(winningNumbers, bonusBall);
    }
}
