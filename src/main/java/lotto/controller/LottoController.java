package lotto.controller;

import lotto.model.*;
import lotto.util.LottoGenerator;
import lotto.view.Input;
import lotto.view.Output;

import java.math.BigDecimal;
import java.util.Set;

import static lotto.util.TypeConvert.convertStringToLottoNumberSet;

public class LottoController {
    private static final String CAN_NOT_PURCHASE_MESSAGE = "구입가능한 금액을 초과했습니다";
    private static final int PURCHASABLE_COUNT = 0;

    public void run() {
        purchaseCalculator purchaseCalculator = new purchaseCalculator(Input.inputMoneyForPurchase());
        int purchasableLottoCount = purchaseCalculator.calculatePurchasableCount();

        int manualLottoCount = Input.inputManualLottoCount();
        Output.printInputManualLottoNumberMessage();
        validateManualLottoCount(purchasableLottoCount, manualLottoCount);

        BunchOfLotto bunchOfLotto = new BunchOfLotto();
        addSeveralManualLotto(bunchOfLotto, manualLottoCount);

        int autoLottoCount = purchasableLottoCount - manualLottoCount;

        Output.printPurchasedMessage(manualLottoCount, autoLottoCount);
        bunchOfLotto.addBunchOfLotto(new BunchOfLotto(autoLottoCount).getBunchOfLotto());

        Output.printBunchOfLottoNumbers(bunchOfLotto.getBunchOfLotto());

        WinningLotto winningLotto = makeWinningLotto();
        Prizes prizes = bunchOfLotto.makeRewards(winningLotto);
        BigDecimal yield = prizes.makeYield(purchaseCalculator.getPurchaseAmount());

        Output.printWinStatics(prizes.getPrizes(), yield);
    }

    private void addSeveralManualLotto(BunchOfLotto bunchOfLotto, int autoLottoCount) {
        for (int i = 0; i < autoLottoCount; i++) {
            String inputNumber = Input.inputManualLottoNumber();
            bunchOfLotto.addLotto(LottoGenerator.makeManualLotto(inputNumber));
        }
    }

    private void validateManualLottoCount(int purchasableLottoCount, int manualLottoCount) {
        if (purchasableLottoCount - manualLottoCount < PURCHASABLE_COUNT) {
            throw new IllegalArgumentException(CAN_NOT_PURCHASE_MESSAGE);
        }
    }

    private WinningLotto makeWinningLotto() {
        Set<LottoNumber> winningNumbers = convertStringToLottoNumberSet(Input.inputWinningNumbers());
        LottoNumber bonusBall = new LottoNumber(Input.inputBonusNumber());

        return new WinningLotto(winningNumbers, bonusBall);
    }
}
