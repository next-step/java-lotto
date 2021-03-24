package lotto.domain;

import java.util.Objects;

public class Number{
    private final String ERROR_LOTTO_NUM_MSG = "[오류] Lotto 번호가 45이상 입니다.";
    int num;

    public Number(int num) {
        this.num = num;
        isLottoNumber();
    }

    private void isLottoNumber() {
        if (num > 45) {
            throw new IllegalArgumentException(ERROR_LOTTO_NUM_MSG);
        }
    }

    public int getNum() {
        return num;
    }

}
