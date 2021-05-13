package lotto;

import java.util.*;

import static lotto.Reward.*;

public class WinningLogic {
    public static Integer INITIALIZE_NUMBER = 0;

    public static List<Integer> makeMatchCounts(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        List matchCounts = new ArrayList();
        Integer winningCount = INITIALIZE_NUMBER;
        for (int i = 0; i < Lotto.CORRECT_LOTTO_NUMBERS_SIZE; i++) {
            winningCount += countIsSame(lottoNumbers, winningNumbers.get(i));
        }
        matchCounts.add(winningCount);
        matchCounts.add(checkBonusCount(lottoNumbers, winningNumbers.get(Lotto.CORRECT_LOTTO_NUMBERS_SIZE)));

        return matchCounts;
    }

    public static Integer checkBonusCount(List<Integer> lottoNumbers, Integer bonusNumber) {
        Integer bonusCount = INITIALIZE_NUMBER;
        for (int i = INITIALIZE_NUMBER; i < Lotto.CORRECT_LOTTO_NUMBERS_SIZE; i++) {
            bonusCount += countIsSame(lottoNumbers, bonusNumber);
        }
        return bonusCount;
    }

    public static Integer countIsSame(List<Integer> lottoNumbers, Integer winningNumber) {
        if (lottoNumbers.contains(winningNumber)) {
            return 1;
        }
        return 0;
    }

    public static TreeMap<Integer, Integer> makePrizes(List<Reward> rewards) {
        TreeMap<Integer, Integer> prizes = new TreeMap<>();

        for (Reward reward : values()) {
            prizes.put(reward.getPrizeMoney(), INITIALIZE_NUMBER);
        }
        for (Reward reward : rewards) {
            prizes.replace(reward.getPrizeMoney(), prizes.get(reward.getPrizeMoney()) + 1);
        }
        prizes.remove(0);

        return prizes;
    }

    public static Integer makePrizeMoney(TreeMap<Integer, Integer> prizes) {
        Integer prizeMoney = INITIALIZE_NUMBER;
        prizeMoney += MATCH_3.getPrizeMoney() * prizes.get(MATCH_3.getPrizeMoney());
        prizeMoney += MATCH_4.getPrizeMoney() * prizes.get(MATCH_4.getPrizeMoney());
        prizeMoney += MATCH_5.getPrizeMoney() * prizes.get(MATCH_5.getPrizeMoney());
        prizeMoney += MATCH_6_WITH_BONUS.getPrizeMoney() * prizes.get(MATCH_6_WITH_BONUS.getPrizeMoney());
        prizeMoney += MATCH_6.getPrizeMoney() * prizes.get(MATCH_6.getPrizeMoney());

        return prizeMoney;
    }

    public static Double makeYield(Integer purchaseAmount, Integer prizeMoney) {
        return prizeMoney / (double) purchaseAmount;
    }

}
