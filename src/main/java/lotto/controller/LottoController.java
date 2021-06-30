package lotto.controller;

import lotto.model.*;
import lotto.view.Input;
import lotto.view.Output;

import java.math.BigDecimal;
import java.util.Set;

import static lotto.util.TypeConverter.convertStringToLottoNumberSet;

public class LottoController {

    public void run() {
        PurchaseCalculator purchaseCalculator = new PurchaseCalculator(Input.inputMoneyForPurchase());

        int manualLottoCount = Input.inputManualLottoCount();
        Output.printInputManualLottoNumberMessage();
        purchaseCalculator.buySomeBunchOfLotto(manualLottoCount);
        BunchOfLotto bunchOfLotto = new BunchOfLotto(makeBunchOfManualLotto(manualLottoCount));

        int autoLottoCount = purchaseCalculator.getPurchasableCount();
        purchaseCalculator.buySomeBunchOfLotto(autoLottoCount);
        Output.printPurchasedMessage(manualLottoCount, autoLottoCount);
        bunchOfLotto.addBunchOfLotto(LottoGenerator.makeBunchOfAutoLotto(autoLottoCount));

        Output.printBunchOfLottoNumbers(bunchOfLotto.getBunchOfLotto());

        WinningLotto winningLotto = makeWinningLotto();
        Prizes prizes = bunchOfLotto.makeRewards(winningLotto);
        BigDecimal yield = prizes.makeYield(purchaseCalculator.getPurchaseAmount());

        Output.printWinStatics(prizes.getPrizes(), yield);
    }

    private BunchOfLotto makeBunchOfManualLotto(int manualLottoCount) {
        BunchOfLotto bunchOfLotto = new BunchOfLotto();

        for (int i = 0; i < manualLottoCount; i++) {
            String inputNumber = Input.inputManualLottoNumber();
            bunchOfLotto.addLotto(LottoGenerator.makeManualLotto(inputNumber));
        }
        return bunchOfLotto;
    }

    private WinningLotto makeWinningLotto() {
        Set<LottoNumber> winningNumbers = convertStringToLottoNumberSet(Input.inputWinningNumbers());
        LottoNumber bonusBall = new LottoNumber(Input.inputBonusNumber());

        return new WinningLotto(winningNumbers, bonusBall);
    }
}
