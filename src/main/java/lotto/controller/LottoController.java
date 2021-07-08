package lotto.controller;

import lotto.model.*;
import lotto.view.Input;
import lotto.view.Output;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static lotto.util.TypeConverter.convertStringToLottoNumberSet;

public class LottoController {

    public void run() {
        PurchaseCalculator purchaseCalculator = new PurchaseCalculator(Input.inputMoneyForPurchase());

        int manualLottoCount = Input.inputManualLottoCount();
        Output.printInputManualLottoNumberMessage();
        purchaseCalculator.purchaseLottos(manualLottoCount);
        Lottos lottos = new Lottos(makeBunchOfManualLotto(manualLottoCount));

        int autoLottoCount = purchaseCalculator.getPurchasableLottoCounts();
        purchaseCalculator.purchaseLottos(autoLottoCount);
        Output.printPurchasedMessage(manualLottoCount, autoLottoCount);
        lottos.addLottos(LottoGenerator.makeBunchOfAutoLotto(autoLottoCount));

        Output.printBunchOfLottoNumbers(lottos.getLottos());

        WinningLotto winningLotto = makeWinningLotto();
        Prizes prizes = lottos.makeRewards(winningLotto);
        BigDecimal yield = prizes.makeYield(purchaseCalculator.getPurchaseAmount());

        Output.printWinStatics(prizes.getPrizes(), yield);
    }

    private List<Lotto>  makeBunchOfManualLotto(int manualLottoCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < manualLottoCount; i++) {
            String inputNumber = Input.inputManualLottoNumber();
            lottos.add(LottoGenerator.makeManualLotto(inputNumber));
        }
        return lottos;
    }

    private WinningLotto makeWinningLotto() {
        Set<LottoNumber> winningNumbers = convertStringToLottoNumberSet(Input.inputWinningNumbers());
        LottoNumber bonusBall = new LottoNumber(Input.inputBonusNumber());

        return new WinningLotto(winningNumbers, bonusBall);
    }
}
