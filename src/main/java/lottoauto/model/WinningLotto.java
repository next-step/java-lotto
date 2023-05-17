package lottoauto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class WinningLotto {

    private final List<Integer> winningLotto;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningLotto, int bonusNumber) {
        LottoNumberValidation.checkWinningLotto(winningLotto, bonusNumber);
        winningLotto.add(bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public WinningReward compare(Lotto lotto) {
        boolean existBonus = lotto.contains(bonusNumber);
        List<Integer> matchNumbers = lotto.getNumbers().stream()
                .filter(number -> winningLotto.stream()
                        .anyMatch(Predicate.isEqual(number)))
                .collect(Collectors.toList());

        if (matchNumbers.size() == WinningReward.MATCH_5.getMatchCount()) {
            return calculateBonus(existBonus);
        }

        return WinningReward.findRewardByMatchCount(matchNumbers.size());

    }

    public LottoResult result(Lottos lottos) {
        List<WinningReward> matchCount = new ArrayList<>();
        for (Lotto lotto : lottos.getLottos()) {
            matchCount.add(compare(lotto));
        }
        return new LottoResult(matchCount);
    }

    private WinningReward calculateBonus(boolean existBonus) {
        if (!existBonus) {
            return WinningReward.MATCH_5;
        }

        return WinningReward.MATCH_5_BONUS;
    }

}
