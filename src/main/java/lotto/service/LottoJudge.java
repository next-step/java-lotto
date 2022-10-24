package lotto.service;

import lotto.common.type.WinnerRank;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.List;

public class LottoJudge {

    private static final int MIN_CORRECT_COUNT = 3;

    public RewardCalculator judge(Lottos lottos, Lotto winningLottoNumbers, String bonusNumberString) {
        int bonusNumber = Integer.parseInt(bonusNumberString);
        RewardCalculator rewardCalculator = new RewardCalculator();
        List<Lotto> lottosToJudge = lottos.getLottos();
        lottosToJudge.stream()
                .map(lotto -> lotto.getSameElements(winningLottoNumbers))
                .filter(this::isValidCount)
                .forEach(correctNumbers -> {
                    if(correctNumbers.size() == 5 && correctNumbers.contains(bonusNumber)){
                        rewardCalculator.plusCount(WinnerRank.SECOND);
                        return;
                    }
                    rewardCalculator.plusCount(WinnerRank.fromCount(correctNumbers.size()));
                });
        return rewardCalculator;
    }

    private boolean isValidCount(List<Integer> correctNumbers) {
        return correctNumbers.size() >= MIN_CORRECT_COUNT;
    }
}
