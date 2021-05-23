package step3.domain;

import step3.common.ErrorCode;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class LottoTicket {
    public static final int LOTTO_NUMBERS_LENGTH = 6;
    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        throwInvalidLottoNumbers(lottoNumbers);
        Collections.sort(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public LottoNumber[] toArray() {
        return this.lottoNumbers.toArray(new LottoNumber[lottoNumbers.size()]);
    }

    private int contains(int inputNumber) {
        if (lottoNumbers.contains(new LottoNumber(inputNumber))) {
            return 1;
        }
        return 0;
    }

    private void throwInvalidLottoNumbers(List<LottoNumber> inputNumbers) {
        //로또 넘버 길이 체크
        if (inputNumbers.size() != LOTTO_NUMBERS_LENGTH ) {
            throw new IllegalArgumentException(ErrorCode.INVALID_LOTTO_NUMBER_LENGTH.getErrorMessage());
        }

        //로또 넘버 중복 체크
        if (new HashSet<LottoNumber>(inputNumbers).size() < LOTTO_NUMBERS_LENGTH) {
            throw new IllegalArgumentException(ErrorCode.DUPLICATED_LOTTO_NUMBER.getErrorMessage());
        }
    }

    @Override
    public String toString() {
        return this.lottoNumbers.toString();
    }
}
