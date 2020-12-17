package step2.domain.lotto;

import static step2.LottoNumberGenerator.*;

public class LottoNumber {
    private final Integer number;

    public LottoNumber(Integer number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(MIN_NUMBER + "이상 " + MAX_NUMBER + "이하의 숫자만 가능합니다");
        }
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }
}
