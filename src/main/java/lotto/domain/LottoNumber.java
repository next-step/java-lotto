package lotto.domain;

import java.util.HashMap;

public class LottoNumber {
    private static final HashMap<Integer, LottoNumber> lottoNumbers = new HashMap<>();
    private final int number;

    static {
        for (int num = LottoBall.MIN_LOTTO; num <= LottoBall.MAX_LOTTO; num++ ) {
            lottoNumbers.put(num, new LottoNumber(num));
        }
    }

    private LottoNumber(final int number) {
        this.number = number;
    }

    public static LottoNumber of(final int number) {
        LottoNumber lottoNumber = lottoNumbers.get(number);
        if (lottoNumber == null) {
            throw new IllegalArgumentException("로또는 1~45 사이의 값이어야 합니다.");
        }
        return lottoNumber;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof LottoNumber)) return false;
        LottoNumber that = (LottoNumber) object;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return this.number;
    }
}
