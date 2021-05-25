package lotto.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Lotto {
    public static final int CANDIDATE_LOTTO_NUMBER_SIZE = 45;
    public static final int CORRECT_LOTTO_NUMBERS_SIZE = 6;
    public static final String NOT_CORRECT_LOTTO_NUMBERS_MESSAGE = "로또번호는 총 6개여야 합니다.";
    public static final String DUPLICATED_LOTTO_NUMBERS_MESSAGE = "로또번호는 중복이 있을 수 없습니다.";

    private final Set<LottoNumber> lottoNumbers;

    public Lotto(Set<LottoNumber> lottoNumbers) {
        this.lottoNumbers = Collections.unmodifiableSet(lottoNumbers);
        validateLottoNumbers(lottoNumbers);
    }

    private void validateLottoNumbers(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.stream().distinct().count() != lottoNumbers.size()) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBERS_MESSAGE);
        }
        if (lottoNumbers.size() != CORRECT_LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(NOT_CORRECT_LOTTO_NUMBERS_MESSAGE);
        }
    }

    public boolean contain(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    public Set<LottoNumber> getLottoNumbers() {
        return new HashSet<>(lottoNumbers);
    }
}
