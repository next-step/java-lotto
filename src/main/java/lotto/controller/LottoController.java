package lotto.controller;

import lotto.model.*;
import lotto.view.Input;
import lotto.view.Output;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static lotto.util.TypeConvert.convertStringToLottoNumberSet;

public class LottoController {
    public void run() {
        Output.printStartMessage();

        PurchaseCalculator purchaseCalculator = new PurchaseCalculator(Input.inputMoneyForPurchase());
        int purchasedLottoCount = purchaseCalculator.CalculatePurchasableCount();

        Output.printPurchasableMessage(purchasedLottoCount);

        BunchOfLottoGenerator bunchOfLottoGenerator = new BunchOfLottoGenerator(purchasedLottoCount);
        List<Lotto> bunchOfLotto = bunchOfLottoGenerator.getBunchOfLotto();

        Output.printBunchOfLottoNumbers(bunchOfLotto);

        WinningLogic winningLogic = new WinningLogic();
        WinningLotto winningLotto = makeWinningLotto();
        Map<Integer, Integer> prizes = winningLogic.makePrizes(makeRewards(bunchOfLotto, winningLotto));

        Output.printWinStatics();
        Output.printPrize(prizes);
        Output.printYield(winningLogic.makeYield(purchaseCalculator.getPurchaseAmount(), winningLogic.makePrizeMoney(prizes)));
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
