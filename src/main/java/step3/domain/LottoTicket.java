package step3.domain;

import step3.common.ErrorCode;
import step3.common.WinningType;

import java.util.*;

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

    public WinningType findWinningType(int[] inputNumbers) {
        throwInvalidWinningNumbers(inputNumbers);

        int matchCount = 0;
        for (int inputNumber : inputNumbers) {
            matchCount += contains(inputNumber);
        }

        return WinningType.of(matchCount);
    }

    private int contains(int inputNumber) {
        if(lottoNumbers.contains(new LottoNumber(inputNumber))) {
            return 1;
        }
        return 0;
    }

    private void throwInvalidLottoNumbers(List<LottoNumber> inputNumbers) {
        //로또 넘버 길이 체크
        if(inputNumbers.size() != LOTTO_NUMBERS_LENGTH ) {
            throw new IllegalArgumentException(ErrorCode.INVALID_LOTTO_NUMBER_LENGTH.getErrorMessage());
        }

        //로또 넘버 중복 체크
        if(new HashSet<LottoNumber>(inputNumbers).size() < LOTTO_NUMBERS_LENGTH) {
            throw new IllegalArgumentException(ErrorCode.DUPLICATED_LOTTO_NUMBER.getErrorMessage());
        }
    }

    private void throwInvalidWinningNumbers(int[] inputNumbers) {
        if(inputNumbers.length != LOTTO_NUMBERS_LENGTH ) {
            throw new IllegalArgumentException(ErrorCode.INVALID_LOTTO_NUMBER_LENGTH.getErrorMessage());
        }
    }
}
