package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoNumber {
    static final int LOTTO_NUM_LIMIT = 45;

    private static final Map<Integer, LottoNumber> LOTTO_NUMBER_MAP = new HashMap<>();

    static {
        for (int i = 1; i <= LOTTO_NUM_LIMIT; i++) {
            LOTTO_NUMBER_MAP.put(i, new LottoNumber(i));
        }
    }

    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber of(int lottoNumber) {
        return LOTTO_NUMBER_MAP.get(lottoNumber);
    }

    public static LottoNumber[] fromIntegers(int[] lottoIntegers) {
        LottoNumber[] lottoNumbers = new LottoNumber[lottoIntegers.length];
        for (int i=0; i < lottoIntegers.length; i++) {
            lottoNumbers[i] = LOTTO_NUMBER_MAP.get(lottoIntegers[i]);
        }
        return lottoNumbers;
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    public int addCountIfContain(int count, List<Integer> winningNumbers) {
        if (winningNumbers.contains(lottoNumber)) {
            count++;
        }
        return count;
    }
}
