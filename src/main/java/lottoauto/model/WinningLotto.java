package lottoauto.model;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class WinningLotto {

    private final List<Integer> winningLotto;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningLotto, int bonusNumber) {
        winningNumberValidation(winningLotto, bonusNumber);
        winningLotto.add(bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public WinningReward compare(Lotto lotto) {

        boolean existBonus = lotto.getNumbers().contains(bonusNumber);
        List<Integer> matchNumbers = lotto.getNumbers().stream()
                .filter(number -> winningLotto.stream()
                        .anyMatch(Predicate.isEqual(number)))
                .collect(Collectors.toList());

        if (matchNumbers.size() == 5) {
            return calculateBonus(existBonus);
        }

        return WinningReward.findRewardByMatches(matchNumbers.size());

    }

    private WinningReward calculateBonus(boolean existBonus) {
        if (!existBonus) {
            return WinningReward.MATCH_5;
        }

        return WinningReward.MATCH_5_BONUS;
    }

    private void winningNumberValidation(List<Integer> winningNumber, int bonusNumber) {
        if (winningNumber.size() != 6) {
            throw new IllegalArgumentException("당첨 숫자는 6개를 입력해야 합니다.");
        }

        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 숫자가 당첨 숫자에 포함되어 있습니다.");
        }


        if (!Lotto.LOTTO_NUMBER_RANGE.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 숫자는 1~45까지의 숫자를 입력해야 합니다.");
        }
    }

}
