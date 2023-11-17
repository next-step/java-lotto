package lotto.model;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers {
    public static final int LOTTO_MAX_COUNT = 6;
    public static final int LOTTO_MIN_RANGE = 1;
    public static final int LOTTO_MAX_RANGE = 45;
    private final Set<Integer> lottoNumbers;

    public LottoNumbers(Set<Integer> lottoNumbers) {
        validateSizeAndDistinct(lottoNumbers);
        validateNumberRange(lottoNumbers);
        this.lottoNumbers = lottoNumbers.stream().sorted().collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public Set<Integer> lottoNumbers(){
        return this.lottoNumbers;
    }

    static void validateSizeAndDistinct(Set<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_MAX_COUNT) {
            throw new IllegalArgumentException("로또 번호가 중복이거나 6개가 아닙니다.");
        }
    }

    static void validateNumberRange(Set<Integer> lottoNumbers) {
        for (int number : lottoNumbers) {
            validateNumberRange(number);
        }
    }

    static private void validateNumberRange(int number) {
        if (number < LOTTO_MIN_RANGE || number > LOTTO_MAX_RANGE) {
            throw new IllegalArgumentException("로또 번호는 1~45 사이여야 합니다.");
        }
    }
}
