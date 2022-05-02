package step2.domain;


import java.util.Objects;

public class LottoNumber {

    private final int value;

    public LottoNumber(String text) {
        int input = Integer.parseInt(text);
        validate(input);
        this.value = input;
    }

    private void validate(int input) {
        if (input < 1 || input > 45) {
            throw new IllegalArgumentException("범위를 벗어나는 번호입니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
