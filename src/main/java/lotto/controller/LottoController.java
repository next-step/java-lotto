package lotto.controller;

import lotto.model.*;

import java.util.*;

import static lotto.view.Input.*;
import static lotto.view.Output.*;
import static lotto.util.TypeConvert.*;

public class LottoController {
    public void run() {
        printStartMessage();

        PurchaseCalculator purchaseCalculator = new PurchaseCalculator(inputMoneyForPurchase());
        int purchasedLottoCount = purchaseCalculator.CalculatePurchasableCount();

        printPurchasableMessage(purchasedLottoCount);

        BunchOfLottoGenerator bunchOfLottoGenerator = new BunchOfLottoGenerator(purchasedLottoCount);
        List<Lotto> bunchOfLotto = bunchOfLottoGenerator.getBunchOfLotto();

        printBunchOfLottoNumbers(bunchOfLotto);

        WinningLogic winningLogic = new WinningLogic();
        WinningLotto winningLotto = makeWinningLotto();
        Map<Integer, Integer> prizes = winningLogic.makePrizes(makeRewards(bunchOfLotto, winningLotto));

        printWinStatics();
        printPrize(prizes);
        printYield(winningLogic.makeYield(purchaseCalculator.getPurchaseAmount(), winningLogic.makePrizeMoney(prizes)));
    }

    public List<Lotto> makeBunchOfLotto(int purchasedLottoCount) {
        List<Lotto> bunchOfLotto = new ArrayList<>();

        for (int i = 0; i < purchasedLottoCount; i++) {
            bunchOfLotto.add(new Lotto(LottoNumberGenerator.makeLottoNumber()));
        }

        return bunchOfLotto;
    }

    public WinningLotto makeWinningLotto() {
        Set<LottoNumber> winningNumbers = convertStringToLottoNumberSet(inputWinningNumbers());
        LottoNumber bonusBall = new LottoNumber(Integer.parseInt(inputBonusNumber()));

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
