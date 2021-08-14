package step2.model;

import java.util.Objects;

public class LottoNumber {
    private final int lottoNumber;

    private static final int MIN = 1;
    private static final int MAX = 45;

    public LottoNumber(String number) {
        isValid(number);
        this.lottoNumber = Integer.parseInt(number.trim());
    }

    public LottoNumber(int lottoNumber) {
        isInRange(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void isValid(String number) {
        isBlank(number);
        number = number.trim();
        isDigit(number);
        isInRange(Integer.parseInt(number));
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    private void isBlank(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("빈값입니다.다시 입력해주세요.");
        }
    }

    private void isDigit(String input) {
        if (!input.matches("[0-9]*")) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
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
