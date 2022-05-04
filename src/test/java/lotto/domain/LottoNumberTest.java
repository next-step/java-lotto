package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {
    @Test
    void 로또번호_객체_불변성_테스트() {
        assertTrue(LottoNumber.valueOf(1) == LottoNumber.valueOf(1));
        assertTrue(LottoNumber.valueOf(12) == LottoNumber.valueOf(12));
    }
}