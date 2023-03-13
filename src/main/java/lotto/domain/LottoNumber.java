package lotto.domain;

import java.util.Objects;

public class LottoNumber {

    private final Integer number;

    public LottoNumber(Integer number) {
        validateLottoNumber(number);
        this.number = number;
    }

    private void validateLottoNumber(Integer number) {
        if (number <= 0 || number > 45) {
            throw new IllegalArgumentException("로또 번호는 1 ~ 45까지 숫자만 선택 가능합니다.");
        }
    }

    public boolean match(final LottoNumber other) {
        return Objects.equals(number, other.number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
