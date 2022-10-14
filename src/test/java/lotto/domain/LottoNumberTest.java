package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

    @Test
    public void 랜덤숫자범위_1_45_아닐시_예외발생() {
        assertThrows(IllegalArgumentException.class, () -> {
            LottoNumber.from(46);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            LottoNumber.from(0);
        });
    }

}