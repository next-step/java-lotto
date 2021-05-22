package step3.domain;

import step3.common.ErrorCode;

import java.util.List;

public class LottoTicket {
    public static final int LOTTO_NUMBERS_LENGTH = 6;
    private List<LottoNumber> lottoNumbers;

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        if(lottoNumbers.size() != LOTTO_NUMBERS_LENGTH ) {
            throw new IllegalArgumentException(ErrorCode.INVALID_LOTTO_NUMEBRS_LENGTH.getErrorMessage());
        }
        this.lottoNumbers = lottoNumbers;
    }

    public LottoNumber[] toArray() {
        return this.lottoNumbers.toArray(new LottoNumber[lottoNumbers.size()]);
    }
}
