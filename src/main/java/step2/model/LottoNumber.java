package step2.model;

import java.util.Objects;

import static step2.model.LottoValidator.*;

public class LottoNumber {
    private final int lottoNumber;

    private static final int MIN = 1;
    private static final int MAX = 45;

    public LottoNumber(String number) {
        isBlank(number);
        isDigit(number);
        isInRange(changeToInt(number));
        this.lottoNumber = changeToInt(number);
    }

    public LottoNumber(int lottoNumber) {
        isInRange(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    private void isInRange(int input) {
        if (input < MIN || input > MAX) {
            throw new IllegalArgumentException("1~45 사이 숫자를 입력해주세요");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
