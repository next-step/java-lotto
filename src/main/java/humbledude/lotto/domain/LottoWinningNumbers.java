package humbledude.lotto.domain;

import java.util.HashSet;
import java.util.Set;

public class LottoWinningNumbers {

    private final LottoNumberSet winningNumbers;

    public LottoWinningNumbers(LottoNumberSet numbers) {
        winningNumbers = numbers;
    }

    public int getMatchedCountWith(LottoNumberSet numbers) {
        Set<LottoNumber> intersection = winningNumbers.intersection(numbers);

        return intersection.size();
    }
}
