package lotto.model.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;


class LottoNumberTest {

    @Test
    void 넘버_객체_생성_성공() {
        // given, when, then
        assertDoesNotThrow(() -> LottoNumber.of(1));
    }

    @Test
    void 넘버의_값을_1미만으로_생성하려고_할시_예외발생() {
        // given, when, then
        assertThrows(IllegalArgumentException.class, () -> LottoNumber.of(0));
    }

    @Test
    void 넘버의_값을_45초과로_생성하려고_할시_예외발생() {
        // given, when, then
        assertThrows(IllegalArgumentException.class, () -> LottoNumber.of(46));
    }


}
