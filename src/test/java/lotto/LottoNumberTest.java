package lotto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


class LottoNumberTest {

    @Test
    void 넘버_객체_생성_성공() {
        // given, when, then
        assertDoesNotThrow(() -> LottoNumber.of(1));
    }


}
