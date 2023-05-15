package lotto.domain;

import java.util.TreeSet;
import java.util.List;

public class Lotto {

    private Numbers numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = new Numbers(numbers);
    }

    public TreeSet<Integer> getLottoNumbers() {
        return numbers.getLottoNumbers();
    }

    public int countMatch(TreeSet<Integer> winningNumbers) {
        int matchCount = 0;

        matchCount = makeMatchCount(winningNumbers, matchCount);
        return matchCount;
    }

    private int makeMatchCount(final TreeSet<Integer> winningNumbers, int matchCount) {
        for (Integer number : numbers.getLottoNumbers()) {
            matchCount = updateMatchCount(winningNumbers, matchCount, number);
        }
        return matchCount;
    }

    private static int updateMatchCount(final TreeSet<Integer> winningNumbers, int matchCount, final Integer number) {
        if (winningNumbers.contains(number)) {
            matchCount++;
        }
        return matchCount;
    }

    public int countMatchNumbers(WinnerLotto winnerLotto) {
        return Math.toIntExact(
                getLottoNumbers()
                        .stream()
                        .filter(winnerLotto::hasMatchNumber)
                        .count()
        );
    }

    public boolean hasBonusNumber(int bonusNumber) {
        return getLottoNumbers()
                .contains(bonusNumber);
    }

}
