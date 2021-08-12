package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoNumbers {

    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static final String DISTINCT_LOTTO_NUMBER_EXCEPTION_MESSAGE_FORMAT = "중복 된 로또 숫자가 존재합니다. lottoNumbers: %s";
    private static final String INVALID_LIST_SIZE_EXCEPTION_MESSAGE_FORMAT = "로또 숫자의 개수가 6개가 아닙니다. lottoNumbers: %s";

    private final List<LottoNumber> lottoNumbers;

    private LottoNumbers(List<LottoNumber> lottoNumbers) {
        validateSize(lottoNumbers);
        validateDistinct(lottoNumbers);
        this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
    }

    private void validateSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(String.format(INVALID_LIST_SIZE_EXCEPTION_MESSAGE_FORMAT, lottoNumbers.toString()));
        }
    }

    private void validateDistinct(List<LottoNumber> lottoNumbers) {
        long distinctCount = lottoNumbers.stream().distinct().count();
        if (distinctCount != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(String.format(DISTINCT_LOTTO_NUMBER_EXCEPTION_MESSAGE_FORMAT, lottoNumbers.toString()));
        }
    }

    public static LottoNumbers of(List<LottoNumber> lottoNumbers) {
        return new LottoNumbers(lottoNumbers);
    }

    public static int requiredSize() {
        return LOTTO_NUMBERS_SIZE;
    }

    public MatchCount match(LottoNumbers other) {
        long count = lottoNumbers.stream()
                        .filter(other::contains)
                        .count();
        return MatchCount.valueOf((int) count);
    }

    private boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
