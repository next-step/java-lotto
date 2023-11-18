package lotto.model;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers {
    public static final int LOTTO_MAX_COUNT = 6;

    private final Set<PositiveNumber> lottoNumbers;

    public LottoNumbers(Set<PositiveNumber> lottoNumbers) {
        validateSizeAndDistinct(lottoNumbers);
        this.lottoNumbers = lottoNumbers.stream()
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public Set<PositiveNumber> lottoNumbers() {
        return this.lottoNumbers;
    }

    private static void validateSizeAndDistinct(Set<PositiveNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_MAX_COUNT) {
            throw new IllegalArgumentException("로또 번호가 중복이거나 6개가 아닙니다.");
        }
    }

    public CorrectNumbers matchCountAndBonus(WinnerNumbers winnerNumbers) {
        int count = 0;
        boolean flag = false;
        for (PositiveNumber number : lottoNumbers) {
            if (winnerNumbers.has(number)) {
                count++;
            }
            if (winnerNumbers.correctBonus(number)) {
                flag = true;
            }
        }
        return new CorrectNumbers(count, flag);
    }

}
