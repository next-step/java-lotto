package lotto.step3.domain;

import lotto.step3.enums.MatchNumber;

import java.util.*;
import java.util.stream.Collectors;

public class WinningNumbers {
    private final Set<Integer> winningNumbers;
    private static final int SECOND_POSITION = 5;

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

    public Map<MatchNumber, Integer> getWinnerStat(Lottos lottos, int bonusNumber) {
        Map<Integer, List<List<Integer>>> resultMap = lottos.getLottos().stream()
                .filter(lotto -> lotto.getLotto().stream().anyMatch(winningNumbers::contains))
                .map(Lotto::getLotto)
                .collect(Collectors.groupingBy(lotto -> (int) lotto.stream().filter(winningNumbers::contains).count()));

        return resultMap.entrySet().stream()
                .filter(e -> MatchNumber.isMatchedSize(e.getKey()).isPresent())
                .collect(Collectors.toMap(
                        entry -> {
                            MatchNumber match = MatchNumber.isMatchedSize(entry.getKey()).get();
                            return makeMatchKey(match, entry, bonusNumber);
                        },
                        entry -> getWinnerNumber(entry, bonusNumber)
                ));
    }

    private MatchNumber makeMatchKey(MatchNumber match, Map.Entry<Integer, List<List<Integer>>> entry, int bonusNumber) {
        int matchKey = entry.getKey();
        List<List<Integer>> lotto = entry.getValue();
        if (matchKey == SECOND_POSITION && lotto.stream().anyMatch(l -> l.contains(bonusNumber))) {
            return MatchNumber.SECOND;
        }
        return match;
    }

    private int getWinnerNumber(Map.Entry<Integer, List<List<Integer>>> entry, int bonusNumber) {
        int matchKey = entry.getKey();
        List<List<Integer>> lotto = entry.getValue();
        if (matchKey == SECOND_POSITION) {
            int secondPositionSize = (int) lotto.stream().filter(l -> l.contains(bonusNumber)).count();
            return secondPositionSize == lotto.size() ? lotto.size() : lotto.size() - secondPositionSize;
        }
        return lotto.size();
    }
}
