package lotto.service;

import lotto.common.type.WinnerRank;
import lotto.common.type.WinnerRankCondition;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;

import java.util.List;

public class LottoJudge {

    public static final int SECOND_PLACE_CORRECT_COUNT = 5;

    public RewardCalculator judge(Lottos lottos, WinningLotto winningLotto) {
        RewardCalculator rewardCalculator = new RewardCalculator();
        List<Lotto> lottosToJudge = lottos.getLottos();
        lottosToJudge.forEach(lotto -> {
            int sameSize = lotto.getSameElementsSize(winningLotto.getWinningLotto());
            boolean correctBonus = getCorrectBonus(winningLotto.getBonusWinningNumber(), lotto, sameSize);
            rewardCalculator.plusCount(WinnerRank.valueOf(WinnerRankCondition.missCountFrom(sameSize, correctBonus)));
        });
        return rewardCalculator;
    }

    private boolean getCorrectBonus(int bonusNumber, Lotto lotto, int sameSize) {
        return sameSize == SECOND_PLACE_CORRECT_COUNT && lotto.hasSameElement(bonusNumber);
    }

}
