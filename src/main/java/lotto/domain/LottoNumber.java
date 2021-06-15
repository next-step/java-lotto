package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class LottoNumber {
    private static int lottoNumber;

    public LottoNumber(int lottoNumber) {
        throwIllegalArgumentException_lottoRange(lottoNumber);

        this.lottoNumber = lottoNumber;
    }

    private static void throwIllegalArgumentException_lottoRange(int lottoNumber) {
        if (lottoNumber < LottoConstants.LOTTO_MIN_NUM || lottoNumber > LottoConstants.LOTTO_MAX_NUM) {
            throw new IllegalArgumentException("로또 번호는 1~45 까지 가능합니다.");
        }
    }
}
