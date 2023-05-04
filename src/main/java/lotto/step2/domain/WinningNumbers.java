package lotto.step2.domain;

import lotto.step2.enums.MatchNumber;

import java.util.*;
import java.util.stream.Collectors;

public class WinningNumbers {
    private final Set<Integer> winningNumbers;

    public Set<Integer> getWinningNumbers() {
        return Set.copyOf(winningNumbers);
    }

    public WinningNumbers(Set<Integer> winningNumbers) {
        this.winningNumbers = validateWinningNumbers(winningNumbers);
    }

    private Set<Integer> validateWinningNumbers(Set<Integer> winningNumbers) {
        if (size(winningNumbers)) {
            throw new IllegalArgumentException("당첨 번호는 6개만 가능합니다.");
        }
        if (isInRange(winningNumbers)) {
            throw new IllegalArgumentException("당첨 번호는 1 ~ 45까지만 가능합니다.");
        }
        return winningNumbers;
    }

    private boolean size(Set<Integer> winningNumbers) {
        return winningNumbers.size() != 6;
    }

    private boolean isInRange(Set<Integer> winningNumbers) {
        return Collections.max(winningNumbers) > 45 || Collections.min(winningNumbers) < 1;
    }


    public Map<MatchNumber, Long> getWinnerStat(Lottos lottos) {
        Map<Integer, Long> stat = lottos.getLottos().stream()
                .map(lotto -> lotto.getLotto().stream().filter(winningNumbers::contains).collect(Collectors.toList()))
                .collect(Collectors.groupingBy(List::size, Collectors.counting()));

        return stat.entrySet().stream()
                .filter(e -> MatchNumber.isMatchedSize(e.getKey()).isPresent())
                .collect(Collectors.toMap(
                        e -> MatchNumber.isMatchedSize(e.getKey()).get(),
                        Map.Entry::getValue
                ));
    }
}
