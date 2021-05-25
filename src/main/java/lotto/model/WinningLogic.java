package lotto.model;

import java.util.*;

public class WinningLogic {
    public static final int INITIALIZE_NUMBER = 0;

    public Map<Integer, Integer> makePrizes(List<Reward> rewards) {
        TreeMap<Integer, Integer> prizes = new TreeMap<>();

        for (Reward reward : Reward.values()) {
            prizes.put(reward.getPrizeMoney(), INITIALIZE_NUMBER);
        }

        for (Reward reward : rewards) {
            prizes.replace(reward.getPrizeMoney(), prizes.get(reward.getPrizeMoney()) + 1);
        }

        return prizes;
    }

    public Integer makePrizeMoney(Map<Integer, Integer> prizes) {
        Integer prizeMoney = INITIALIZE_NUMBER;

        for (Reward reward : Reward.values()) {
            prizeMoney += reward.getPrizeMoney() * prizes.get(reward.getPrizeMoney());
        }

        return prizeMoney;
    }

    public Double makeYield(Integer purchaseAmount, Integer prizeMoney) {
        return prizeMoney / (double) purchaseAmount;
    }

    public WinningState makeWinningState(Lotto lotto, WinningLotto winningLotto) {
        int winningCount = makeWinningCount(lotto.getLottoNumbers(), winningLotto.getLottoNumbers());
        LottoNumber bonusBallNumber = winningLotto.getBonusBall();
        WinningState winningState = new WinningState(winningCount, checkBonusCount(lotto, bonusBallNumber));

        return winningState;
    }

    private int makeWinningCount(Set<LottoNumber> lottoNumbers, Set<LottoNumber> winningLotto) {
        int winningCount = 0;

        for (LottoNumber winningNumber : winningLotto) {
            winningCount += compareWithWinningLotto(lottoNumbers, winningNumber);
        }

        return winningCount;
    }

    private int compareWithWinningLotto(Set<LottoNumber> lottoNumbers, LottoNumber winningLotto) {
        if (lottoNumbers.contains(winningLotto)) {
            return 1;
        }
        return 0;
    }

    private boolean checkBonusCount(Lotto lotto, LottoNumber bonusNumber) {
        return lotto.contain(bonusNumber);
    }
}
