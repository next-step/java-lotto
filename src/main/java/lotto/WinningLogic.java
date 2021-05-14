package lotto;

import java.util.*;

import static lotto.Reward.*;

public class WinningLogic {
    public static final int INITIALIZE_NUMBER = 0;

    public List<Integer> makeMatchCounts(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        List<Integer> matchCounts = new ArrayList();
        Integer winningCount = INITIALIZE_NUMBER;
        for (int i = 0; i < Lotto.CORRECT_LOTTO_NUMBERS_SIZE; i++) {
            winningCount += countIsSame(lottoNumbers, winningNumbers.get(i));
        }
        matchCounts.add(winningCount);
        matchCounts.add(checkBonusCount(lottoNumbers, winningNumbers.get(Lotto.CORRECT_LOTTO_NUMBERS_SIZE)));

        return matchCounts;
    }

    private int checkBonusCount(List<Integer> lottoNumbers, int bonusNumber) {
        int bonusCount = INITIALIZE_NUMBER;
        if (lottoNumbers.contains(bonusNumber)) {
            bonusCount += 1;
        }
        return bonusCount;
    }

    private Integer countIsSame(List<Integer> lottoNumbers, Integer winningNumber) {
        if (lottoNumbers.contains(winningNumber)) {
            return 1;
        }
        return 0;
    }

    public TreeMap<Integer, Integer> makePrizes(List<Reward> rewards) {
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

    public Integer makePrizeMoney(TreeMap<Integer, Integer> prizes) {
        Integer prizeMoney = INITIALIZE_NUMBER;
        prizeMoney += FIFTH_PRIZE.getPrizeMoney() * prizes.get(FIFTH_PRIZE.getPrizeMoney());
        prizeMoney += FOURTH_PRIZE.getPrizeMoney() * prizes.get(FOURTH_PRIZE.getPrizeMoney());
        prizeMoney += THIRD_PRIZE.getPrizeMoney() * prizes.get(THIRD_PRIZE.getPrizeMoney());
        prizeMoney += SECOND_PRIZE.getPrizeMoney() * prizes.get(SECOND_PRIZE.getPrizeMoney());
        prizeMoney += FIRST_PRIZE.getPrizeMoney() * prizes.get(FIRST_PRIZE.getPrizeMoney());

        return prizeMoney;
    }

    public Double makeYield(Integer purchaseAmount, Integer prizeMoney) {
        return prizeMoney / (double) purchaseAmount;
    }

}
