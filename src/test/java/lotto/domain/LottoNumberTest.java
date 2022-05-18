package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

    @Test
    void lotto_최대값초과_argumentException() {
        assertThrows(IllegalArgumentException.class, () -> new LottoNumber(LottoNumber.MAX_NUM + 1));
    }


    @Test
    void lotto_최소값미만_argumentException() {
        assertThrows(IllegalArgumentException.class, () -> new LottoNumber(LottoNumber.MIN_NUM - 1));
    }
}
