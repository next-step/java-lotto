package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public enum LottoNumbersValidation {
    LOTTO_NUMBERS_COUNT_INVALID("로또 숫자 갯수가 다릅니다.") {
        @Override
        boolean isValid(List<Integer> lottoNumbers) {
            return lottoNumbers.size() == Lotto.LOTTO_NUMBERS_CARDINALITY;
        }
    },
    LOTTO_NUMBERS_IS_OUT_OF_RANGE("로또 숫자가 범위 밖입니다.") {
        @Override
        boolean isValid(List<Integer> lottoNumbers) {
            boolean isOutOfRange = false;
            for (int number : lottoNumbers) {
                isOutOfRange = isOutOfRange || (number < LottoNumber.MIN_BOUND || number > LottoNumber.MAX_BOUND);
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
