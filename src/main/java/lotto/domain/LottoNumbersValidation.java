package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public enum LottoNumbersValidation {
    LOTTO_NUMBERS_COUNT_INVALID("로또 숫자 갯수가 다릅니다.") {
        @Override
        boolean isValid(List<Integer> lottoNumbers) {
            return lottoNumbers.size() == LOTTO_NUMBERS_CARDINALITY;
        }
    },
    LOTTO_NUMBERS_IS_OUT_OF_RANGE("로또 숫자가 범위 밖입니다.") {
        @Override
        boolean isValid(List<Integer> lottoNumbers) {
            boolean isOutOfRange = false;
            for (int number : lottoNumbers) {
                isOutOfRange = isOutOfRange || (number < MIN_BOUND || number > MAX_BOUND);
            }
            return !isOutOfRange;
        }
    },
    LOTTO_NUMBERS_HAS_DUPLICATED_NUMBER("중복된 숫자가 존재합니다.") {
        @Override
        boolean isValid(List<Integer> lottoNumbers) {
            Set<Integer> lottoNumbersSet = new HashSet<>(lottoNumbers);
            return lottoNumbersSet.size() == lottoNumbers.size();
        }
    };

    private static final int LOTTO_NUMBERS_CARDINALITY = 6;
    private static final int MAX_BOUND = 45;
    private static final int MIN_BOUND = 1;

    private final String errorMsg;

    LottoNumbersValidation(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    abstract boolean isValid(List<Integer> lottoNumbers);

    public void check(List<Integer> lottoNumbers) {
        if (!isValid(lottoNumbers)) {
            throw new IllegalArgumentException(errorMsg);
        }
    }
}
