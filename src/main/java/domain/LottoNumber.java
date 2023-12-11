package domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static util.LottoNumberGenerator.*;

public class LottoNumber {
    private static final Map<Integer, LottoNumber> lottoNumberCache = new HashMap<>();

    private final int lottoNumber;

    static{
        for (int i = MIN_LOTTO_NUMBER; i < MAX_LOTTO_NUMBER; i++) {
            lottoNumberCache.put(i, new LottoNumber(i));
        }
    }
    public static LottoNumber from(String input) {
        int num = Integer.parseInt(input.trim());
        return LottoNumber.valueOf(num);
    }

    public static LottoNumber valueOf(int num) {
        LottoNumber lottoNumber = lottoNumberCache.get(num);
        validateNumberNull(lottoNumber);
        return lottoNumber;
    }

    private LottoNumber(int lottoNumber) {
        validateNumberRange(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private static void validateNumberNull(LottoNumber lottoNumber) {
        if (lottoNumber == null) {
            throw new IllegalArgumentException(String.format("로또 숫자는 null값을 가질 수 없습니다."));
        }
    }

    private static void validateNumberRange(int lottoNumber) {
        if (lottoNumber < MIN_LOTTO_NUMBER || lottoNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(String.format("로또 숫자는 %d과 %d 사이만 가능합니다.", MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER));
        }
    }

    public int getLottoNumber() {
        return lottoNumber;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
