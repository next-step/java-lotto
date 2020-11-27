package lotto.domain;

import lotto.domain.exception.ErrorMessage;
import lotto.domain.exception.NotValidLottoNumberException;

import java.util.Set;

public class LottoNumber {

    private static final int LOTTO_FIX_SIZE = 6;
    private Set<Integer> lottoNumbers;

    private LottoNumber(Set<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumber from(Set<Integer> lottoNumbers) {
        if (!isValidLottoNumber(lottoNumbers)) {
            throw new NotValidLottoNumberException(ErrorMessage.NOT_VALID_LOTTO_NUMBER.getMessage());
        }
        return new LottoNumber(lottoNumbers);
    }

    private static boolean isValidLottoNumber(Set<Integer> lottoNumbers) {
        return lottoNumbers.size() == LOTTO_FIX_SIZE ? !isValidRange(lottoNumbers) : false;
    }

    private static boolean isValidRange(Set<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                    .anyMatch(number ->  number < LottoNumbers.MIN_LOTTO_NUMBER
                                        || number > LottoNumbers.MAX_LOTTO_NUMBER );
    }


    public Set<Integer> getLottoNumber() {
        return lottoNumbers;
    }
}
