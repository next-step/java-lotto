package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoNumber {
    static final int LOTTO_NUM_LIMIT = 45;

    static final Map<Integer, LottoNumber> LOTTO_NUMBER_MAP = new HashMap<>();

    static {
        for (int i = 1; i <= LOTTO_NUM_LIMIT; i++) {
            LOTTO_NUMBER_MAP.put(i, new LottoNumber(i));
        }
    }

    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber from(int lottoNumber) {
        return LOTTO_NUMBER_MAP.get(lottoNumber);
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    public int addCountIfContain(int count, WinningNumbers winningNumbers) {
        if (winningNumbers.contains(lottoNumber)) {
            count++;
        }
        return count;
    }

    public boolean isSameNumber(int number) {
        return lottoNumber == number;
    }
}
