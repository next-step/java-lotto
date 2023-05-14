package lotto.step4.domain;

import lotto.step4.enums.Rank;

import java.util.Set;
import java.util.stream.Collectors;

public class WinningNumbers extends ValidateNumbers {
    private static final int SECOND_POSITION = 5;
    private final int bonusNumber;
    private final Set<Integer> winningNumbers;

    public Set<Integer> getWinningNumbers() {
        return Set.copyOf(winningNumbers);
    }

    public WinningNumbers(Set<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = validateNumbers(winningNumbers);
        this.bonusNumber = validateBonusNumber(bonusNumber, winningNumbers);
    }

    public Result getWinnerStat(Lottos lottos) {
        return new Result(lottos.getLottos().stream()
                .map(this::matchLotto)
                .collect(Collectors.groupingBy(i -> i, Collectors.counting())));
    }
    private Rank matchLotto(Lotto lotto) {
        int matchCount = lotto.matchCount(winningNumbers);
        boolean matchBonus = lotto.getLotto().contains(bonusNumber);
        return Rank.of(matchCount, matchBonus);
    }
}
