package lotto.controller;

import lotto.model.*;

import java.util.*;

import static lotto.view.Input.*;
import static lotto.view.Output.*;
import static lotto.util.TypeConvert.*;

public class LottoController {
    public void run() {
        printStartMessage();

        Integer purchaseAmount = inputMoneyForPurchase();
        Integer purchasedLottoCount = PurchaseCalculator.countPurchasable(purchaseAmount);

        printPurchasableMessage(purchasedLottoCount);

        Set<Lotto> bunchOfLotto = makeBunchOfLotto(purchasedLottoCount);

        printBunchOfLottoNumbers(bunchOfLotto);

        WinningLogic winningLogic = new WinningLogic();
        WinningLotto winningLotto = makeWinningLotto();
        Map<Integer, Integer> prizes = winningLogic.makePrizes(makeRewards(bunchOfLotto, winningLotto));

        printWinStatics();
        printPrize(prizes);
        printYield(winningLogic.makeYield(purchaseAmount, winningLogic.makePrizeMoney(prizes)));
    }

    public Set<Lotto> makeBunchOfLotto(int purchasedLottoCount) {
        List<Lotto> bunchOfLottoList = new ArrayList<>();

        for (int i = 0; i < purchasedLottoCount; i++) {
            bunchOfLottoList.add(new Lotto(LottoNumberGenerator.makeLottoNumber()));
        }

        Set<Lotto> bunchOfLotto = new HashSet<>();
        bunchOfLotto.addAll(bunchOfLottoList);
        return bunchOfLotto;
    }

    public WinningLotto makeWinningLotto() {
        Set<LottoNumber> winningNumbers = convertStringToLottoNumberSet(inputWinningNumbers());
        LottoNumber bonusBall = new LottoNumber(Integer.parseInt(inputBonusNumber()));

        return new WinningLotto(winningNumbers, bonusBall);
    }

    private List<Reward> makeRewards(Set<Lotto> bunchOfLotto, WinningLotto winningLotto) {
        List<Reward> rewards = new ArrayList<>();
        WinningLogic winningLogic = new WinningLogic();

        for (Lotto lotto : bunchOfLotto) {
            rewards.add(Reward.getReward(winningLogic.makeWinningState(lotto, winningLotto)));
        }

        return rewards;
    }
}
