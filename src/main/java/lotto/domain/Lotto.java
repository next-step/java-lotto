package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private static final int LOTTO_SIZE = 6;
    public static final String DUPLICATE_EXCEPTION_MESSAGE = "복권에 중복된 숫자가 존재합니다.";
    public static final String LOTTO_SIZE_EXCEPTION_MESSAGE = "복권의 숫자 개수가 유효하지 않습니다.";

    private final List<LottoNumber> lottoNumbers;

    public Lotto(final List<LottoNumber> lottoNumbers) {
        validateNumbersSize(lottoNumbers);
        validateDuplicateNumber(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto() {
        this(LottoAutoGenerator.getInstance().generateLotto());
    }

    private void validateDuplicateNumber(final List<LottoNumber> lotto) {
        Set<LottoNumber> deduplication = new HashSet<>(lotto);
        if (lotto.size() != deduplication.size()) {
            throw new IllegalArgumentException(DUPLICATE_EXCEPTION_MESSAGE);
        }
    }

    private void validateNumbersSize(final List<LottoNumber> lotto) {
        if (lotto.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_SIZE_EXCEPTION_MESSAGE);
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }
}
