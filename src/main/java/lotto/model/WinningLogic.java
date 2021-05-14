package lotto.model;

import lotto.model.Lotto;
import lotto.model.Reward;
import lotto.model.WinningLotto;

import java.util.*;

import static lotto.model.Reward.*;

public class WinningLogic {
    public static final int INITIALIZE_NUMBER = 0;

    public WinningLotto makeWinningLotto(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int winningCount = INITIALIZE_NUMBER;

        for (int i = 0; i < Lotto.CORRECT_LOTTO_NUMBERS_SIZE; i++) {
            winningCount += countIsSame(lottoNumbers, winningNumbers.get(i));
        }

        int bonusBallNumber = winningNumbers.get(Lotto.CORRECT_LOTTO_NUMBERS_SIZE);
        WinningLotto winningLotto = new WinningLotto(winningCount, checkBonusCount(lottoNumbers, bonusBallNumber));

        return winningLotto;
    }

    private boolean checkBonusCount(List<Integer> lottoNumbers, int bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            return true;
        }
        return false;
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
