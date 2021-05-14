package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Reward;
import lotto.model.WinningLogic;

import java.util.*;

import static lotto.model.Lotto.CANDIDATE_LOTTO_NUMBER_SIZE;
import static lotto.model.Lotto.CORRECT_LOTTO_NUMBERS_SIZE;

import static lotto.view.Input.*;
import static lotto.view.Output.*;
import static lotto.util.TypeConvert.*;

public class LottoMachine {
    public static Integer LOTTERY_PRICE = 1000;

    public void purchaseStart() {
        printStartMessage();
        Integer purchaseAmount = inputMoneyForPurchase();
        Integer purchased = countPurchasable(purchaseAmount);
        printPurchasableMessage(purchased);
        List<Lotto> bunchOfLotto = makeBunchOfLotto(purchaseAmount);

        printBunchOfLottoNumbers(bunchOfLotto);
        printInputWinningNumber();
        WinningLogic winningLogic = new WinningLogic();
        TreeMap<Integer,Integer> prizes = winningLogic.makePrizes(makeRewards(bunchOfLotto, makeWinningNumbers()));

        printWinStatics();
        print3Match(prizes.get(Reward.FIFTH_PRIZE.getPrizeMoney()));
        print4Match(prizes.get(Reward.FOURTH_PRIZE.getPrizeMoney()));
        print5Match(prizes.get(Reward.THIRD_PRIZE.getPrizeMoney()));
        print6MatchWithBonus(prizes.get(Reward.SECOND_PRIZE.getPrizeMoney()));
        print6Match(prizes.get(Reward.FIRST_PRIZE.getPrizeMoney()));

        printYield(winningLogic.makeYield(purchaseAmount, winningLogic.makePrizeMoney(prizes)));
    }

    private List<Reward> makeRewards(List<Lotto> bunchOfLotto, List<Integer> winningNumbers) {
        List<Reward> rewards = new ArrayList<>();
        WinningLogic winningLogic = new WinningLogic();
        for (Lotto lotto : bunchOfLotto) {
            rewards.add(Reward.getReward(winningLogic.makeWinningLotto(lotto.getLottoNumbers(), winningNumbers)));
        }
        return rewards;
    }

    public static List<Integer> makeLottoNumbers() {
        Set<Integer> lottoNumbers = new HashSet<>();
        while (lottoNumbers.size() < CORRECT_LOTTO_NUMBERS_SIZE) {
            lottoNumbers.add(makeLottoNumber());
        }
        List<Integer> lottoNumberList = new ArrayList(lottoNumbers);
        return lottoNumberList;
    }

    private static Integer makeLottoNumber() {
        return (int) (Math.random() * CANDIDATE_LOTTO_NUMBER_SIZE) + 1;
    }

    public List<Lotto> makeBunchOfLotto(int purchaseAmount) {
        List<Lotto> bunchOfLotto = new ArrayList<>();
        int lottoCount = countPurchasable(purchaseAmount);
        for (int i = 0; i < lottoCount; i++) {
            bunchOfLotto.add(new Lotto(makeLottoNumbers()));
        }
        return bunchOfLotto;
    }

    public int countPurchasable(int purchaseAmount) {
        return purchaseAmount / LOTTERY_PRICE;
    }

    public List<Integer> makeWinningNumbers() {
        List<Integer> winningNumbers = convertStringToIntegerList(inputWinningNumbers());
        Collections.sort(winningNumbers);
        winningNumbers.add(Integer.parseInt(inputBonusNumber()));

        return winningNumbers;
    }
}
