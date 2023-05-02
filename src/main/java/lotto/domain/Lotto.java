package lotto.domain;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static lotto.constants.Constants.MAX_NUMBER;
import static lotto.constants.Constants.MIN_NUMBER;
import static lotto.constants.Constants.REQUIRED_LOTTO_NUMBERS;

public class Lotto {

    private Numbers numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = new Numbers(numbers);
    }

    public LinkedHashSet<Integer> getLottoNumbers() {
        return numbers.getLottoNumbers();
    }

    public int countMatch(LinkedHashSet<Integer> winningNumbers) {
        int matchCount = 0;

        matchCount = makeMatchCount(winningNumbers, matchCount);
        return matchCount;
    }

    private int makeMatchCount(final LinkedHashSet<Integer> winningNumbers, int matchCount) {
        for (Integer number : numbers.getLottoNumbers()) {
            matchCount = updateMatchCount(winningNumbers, matchCount, number);
        }
        return matchCount;
    }

    private static int updateMatchCount(final LinkedHashSet<Integer> winningNumbers, int matchCount, final Integer number) {
        if (winningNumbers.contains(number)) {
            matchCount++;
        }
        return matchCount;
    }

}
