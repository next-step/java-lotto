package lotto.service;

import lotto.common.type.WinnerRank;
import lotto.common.type.WinnerRankCondition;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.List;

public class LottoJudge {


    public static final int SECOND_PLACE_CORRECT_COUNT = 5;

    public RewardCalculator judge(Lottos lottos, Lotto winningLottoNumbers, String bonusNumberString) {
        int bonusNumber = Integer.parseInt(bonusNumberString);
        RewardCalculator rewardCalculator = new RewardCalculator();
        List<Lotto> lottosToJudge = lottos.getLottos();
        lottosToJudge.forEach(lotto -> {
                    int sameSize = lotto.getSameElements(winningLottoNumbers).size();
                    boolean correctBonus = getCorrectBonus(bonusNumber, lotto, sameSize);
                    rewardCalculator.plusCount(WinnerRank.valueOf(new WinnerRankCondition(sameSize, correctBonus)));
                });
        return rewardCalculator;
    }

    private boolean getCorrectBonus(int bonusNumber, Lotto lotto, int sameSize) {
        return sameSize == SECOND_PLACE_CORRECT_COUNT && lotto.hasSameElement(bonusNumber);
    }

}
