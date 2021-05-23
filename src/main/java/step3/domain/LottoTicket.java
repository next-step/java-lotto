package step3.domain;

import step3.common.ErrorCode;
import step3.common.WinningType;

import java.util.Set;

public class LottoTicket {
    public static final int LOTTO_NUMBERS_LENGTH = 6;
    private Set<LottoNumber> lottoNumbers;

    public LottoTicket(Set<LottoNumber> lottoNumbers) {
        throwInvalidLottoNumbersLength(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public WinningType findWinningType(Set<LottoNumber> inputNumbers) {
        throwInvalidLottoNumbersLength(inputNumbers);

        int matchCount = 0;
        for (LottoNumber userLottoNumber : this.lottoNumbers) {
            matchCount += countMatching(inputNumbers, userLottoNumber);
        }

        return WinningType.of(matchCount);
    }

    private int countMatching(Set<LottoNumber> inputNumbers, LottoNumber userLottoNumber) {
        if(inputNumbers.contains(userLottoNumber)) {
            return 1;
        }
        return 0;
    }

    private void throwInvalidLottoNumbersLength(Set<LottoNumber> inputNumbers) {
        if(inputNumbers.size() != LOTTO_NUMBERS_LENGTH ) {
            throw new IllegalArgumentException(ErrorCode.INVALID_LOTTO_NUMEBRS_LENGTH.getErrorMessage());
        }
    }
}
