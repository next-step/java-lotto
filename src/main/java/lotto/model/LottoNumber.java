package lotto.model;

import java.util.ArrayList;
import java.util.List;

import static lotto.util.MessageUtil.WARNING_LOTTO_NUMBER_RANGE;

public class LottoNumber {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private static List<Integer> lottoPool = new ArrayList<>();

    static {
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            lottoPool.add(i);
        }
    }

    private int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateLottoNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validateLottoNumber(int lottoNumber) {
        if (!lottoPool.contains(lottoNumber)) {
            throw new IllegalArgumentException(WARNING_LOTTO_NUMBER_RANGE);
        }
    }
}
