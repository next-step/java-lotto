package lotto.domain;

import lotto.common.LottoConstants;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber {
    private final int number;
    private static final Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();

    static {
        for (int i = LottoConstants.MIN_LOTTO_NUMBER; i <= LottoConstants.MAX_LOTTO_NUMBER; i++) {
            lottoNumbers.put(i, new LottoNumber(i));
        }
    }

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber lottoNumber(String number) {
        int lottoNumber;

        try {
            lottoNumber = Integer.parseInt(number);
        } catch (NumberFormatException numberFormatException) {
            throw new NumberFormatException("수동 구매 번호를 잘 못 입력하셨습니다.");
        }

        return lottoNumber(lottoNumber);
    }

    public static LottoNumber lottoNumber(int number){
        LottoNumber lottoNumber = lottoNumbers.get(number);
        if (lottoNumber == null) {
            throw new IllegalArgumentException("로또 번호는 1 ~ 45 까지 입니다.");
        }
        return lottoNumber;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
