package lotto.domain;

import lotto.common.ErrorCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class LottoTicket {
    public static final int LOTTO_NUMBERS_LENGTH = 6;
    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoNumber[] toArray() {
        return this.lottoNumbers.toArray(new LottoNumber[lottoNumbers.size()]);
    }

    @Override
    public String toString() {
        return this.lottoNumbers.toString();
    }
}
