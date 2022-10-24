package lotto.service;

import lotto.common.type.WinnerRank;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.List;

public class LottoJudge {

    private static final int MIN_CORRECT_COUNT = 3;

    public RewardCalculator judge(Lottos lottos, Lotto winningLottoNumbers) {
        RewardCalculator rewardCalculator = new RewardCalculator();
        List<Lotto> lottosToJudge = lottos.getLottos();
        lottosToJudge.stream()
                .mapToInt(lotto -> lotto.getCorrectCount(winningLottoNumbers))
                .filter(this::isValidCount)
                .forEach(correctCount -> rewardCalculator.plusCount(WinnerRank.fromCount(correctCount)));
        return rewardCalculator;
    }

    private boolean isValidCount(int correctCount) {
        return correctCount >= MIN_CORRECT_COUNT;
    }
}
