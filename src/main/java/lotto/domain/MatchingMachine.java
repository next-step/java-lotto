package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MatchingMachine {
    private final Lotto lotto;
    private final WinningNumbers winningNumbers;

    public MatchingMachine(Lotto lotto, WinningNumbers winningNumbers) {
        this.lotto = lotto;
        this.winningNumbers = winningNumbers;
    }

    public void match() {
        lotto.match(winningNumbers.numberGroup());
    }

    public Rate rate(Amount lottoAmount) {
        Amount criteriasAmount = matchCriteriasAmount();
        return criteriasAmount.dividedAmount(lottoAmount);
    }

    public Amount matchCriteriasAmount() {
        double sum = Arrays.stream(MatchCriteria.values())
                .mapToDouble(MatchCriteria::calc)
                .sum();
        return new Amount(sum);
    }

    public List<MatchCriteria> matchCriterias() {
        return Arrays.stream(MatchCriteria.values())
                .filter(m -> m != MatchCriteria.NOTING)
                .collect(Collectors.toList());
    }
}
