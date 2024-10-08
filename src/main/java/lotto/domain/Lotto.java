package lotto.domain;

import java.util.List;

public class Lotto {
    private static final int LOTTO_COUNT = 6;
    private static final String INCORRECT_LOTTO_COUNT_ERROR_MESSAGE = "올바른 로또의 개수가 아닙니다.";
    private static final String DUPLICATE_LOTTO_NUMBER_ERROR_MESSAGE = "중복되는 번호는 가질 수 없습니다.";

    private final List<LottoNumber> lottoNumbers;

    public Lotto(final List<LottoNumber> lottoNumbers) {
        validateLottoCount(lottoNumbers);
        validateDuplicated(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateLottoCount(final List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException(INCORRECT_LOTTO_COUNT_ERROR_MESSAGE);
        }
    }

    private void validateDuplicated(final List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.stream().distinct().count() != LOTTO_COUNT) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER_ERROR_MESSAGE);
        }
    }

}
