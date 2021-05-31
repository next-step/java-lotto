package lotto.controller;

import lotto.model.*;
import lotto.view.Input;
import lotto.view.Output;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static lotto.util.TypeConvert.convertStringToLottoNumberSet;

public class LottoController {
    public void run() {
        PurchaseCalculator purchaseCalculator = new PurchaseCalculator(Input.inputMoneyForPurchase());
        int purchasedLottoCount = purchaseCalculator.CalculatePurchasableCount();

        Output.printPurchasableMessage(purchasedLottoCount);

        BunchOfLotto bunchOfLotto = new BunchOfLotto(purchasedLottoCount);
        Output.printBunchOfLottoNumbers(bunchOfLotto.getBunchOfLotto());

        WinningLotto winningLotto = makeWinningLotto();
        Prizes prizes = new Prizes(makeRewards(bunchOfLotto.getBunchOfLotto(), winningLotto));

        Output.printWinStatics(prizes,purchaseCalculator);
    }

    public WinningLotto makeWinningLotto() {
        Set<LottoNumber> winningNumbers = convertStringToLottoNumberSet(Input.inputWinningNumbers());
        LottoNumber bonusBall = new LottoNumber(Integer.parseInt(Input.inputBonusNumber()));

        return new WinningLotto(winningNumbers, bonusBall);
    }

    private List<Reward> makeRewards(List<Lotto> bunchOfLotto, WinningLotto winningLotto) {
        List<Reward> rewards = new ArrayList<>();
        WinningLogic winningLogic = new WinningLogic();

        for (Lotto lotto : bunchOfLotto) {
            rewards.add(Reward.getReward(winningLogic.makeWinningState(lotto, winningLotto)));
        }

        return rewards;
    }
}
