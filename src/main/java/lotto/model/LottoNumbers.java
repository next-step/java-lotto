package lotto.model;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers {
    public static final int LOTTO_MAX_COUNT = 6;

    private final Set<LottoNumberValidate> lottoNumbers;

    public LottoNumbers(Set<LottoNumberValidate> lottoNumbers) {
        validateSizeAndDistinct(lottoNumbers);
        this.lottoNumbers = lottoNumbers.stream()
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public Set<LottoNumberValidate> lottoNumbers() {
        return this.lottoNumbers;
    }

    private static void validateSizeAndDistinct(Set<LottoNumberValidate> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_MAX_COUNT) {
            throw new IllegalArgumentException("로또 번호가 중복이거나 6개가 아닙니다.");
        }
    }
}
