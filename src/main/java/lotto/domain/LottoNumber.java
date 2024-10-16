package lotto.domain;

public class LottoNumber {
    private Integer value;

    public LottoNumber(Integer value) {
        validate(value);
        this.value = value;
    }

    private void validate(Integer value) {
        if (value > 0 && value < 46) {
            return ;
        }
        throw new IllegalArgumentException("로또 번호는 1~45 사이의 번호입니다.");
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
