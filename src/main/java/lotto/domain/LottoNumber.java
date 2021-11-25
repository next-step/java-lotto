package lotto.domain;

import java.util.Objects;

public class LottoNumber {
    private final Integer lottoNumber;

    public static final int BOUND_START = 1;

    public static final int BOUND_END = 45;

    public LottoNumber(int lottoNumber) {
        checkBound(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public LottoNumber(String numberString) {
        checkNumeric(numberString);
        Integer number = Integer.parseInt(numberString);
        checkBound(number);
        this.lottoNumber = number;
    }

    public Integer getLottoNumber() {
        return lottoNumber;
    }

    public void checkNumeric(String numberString) {
        try {
            Integer.parseInt(numberString);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자가 아닙니다");
        }
    }

    private void checkBound(Integer number) {
        if (number > BOUND_END) {
            throw new IllegalArgumentException(BOUND_END + "보다 큰 숫자가 입력될 수 없습니다.");
        }
        if (number < BOUND_START) {
            throw new IllegalArgumentException(BOUND_START + "보다 작은 숫자가 입력될 수 없습니다.");
        }
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
}
