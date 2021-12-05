package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber {
    public static final int BOUND_START = 1;
    public static final int BOUND_END = 45;
    private static final Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();

    static {
        for (int i = 1; i < 46; i++) {
            lottoNumbers.put(i, new LottoNumber(i));
        }
    }

    private final int lottoNumber;

    private LottoNumber(int lottoNumber) {
        checkBound(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber ofInt(int lottoNumber) {
        return lottoNumbers.get(lottoNumber);
    }

    public static LottoNumber ofString(String lottoNumber) {
        checkNumeric(lottoNumber);
        return new LottoNumber(Integer.parseInt(lottoNumber));
    }

    private static void checkNumeric(String numberString) {
        try {
            Integer.parseInt(numberString);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자가 아닙니다");
        }
    }

    public Integer getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber lottoNumber1 = (LottoNumber) o;
        return Objects.equals(lottoNumber, lottoNumber1.lottoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    private void checkBound(Integer number) {
        if (number > BOUND_END) {
            throw new IllegalArgumentException(BOUND_END + "보다 큰 숫자가 입력될 수 없습니다.");
        }
        if (number < BOUND_START) {
            throw new IllegalArgumentException(BOUND_START + "보다 작은 숫자가 입력될 수 없습니다.");
        }
    }
}
