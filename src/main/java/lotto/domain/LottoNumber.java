package lotto.domain;

public class LottoNumber {
    private int value;

    public LottoNumber(String value) {
        this(Integer.parseInt(value));
    }
    public LottoNumber(int value) {
        validate(value);
        this.value = value;
    }


    private void validate(int value) {
        if (value > 0 && value < 46) {
            return ;
        }
        throw new IllegalArgumentException("로또 번호는 1~45 사이의 번호입니다.");
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
