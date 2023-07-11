package lotto;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoMoneyTest {

    @Test
    void 돈_객체_생성() {
        // given, when, then
        assertDoesNotThrow(() -> new LottoMoney(1000));
    }

    @Test
    void 돈_객체_값_반환_성공() {
        // given, when, then
        assertThat(new LottoMoney(1000).getValue()).isEqualTo(1000);
    }

    @Test
    void 로또_가격_이하의_돈_객체_생성시_예외_발생() {
        // given, when, then
        assertThrows(IllegalArgumentException.class, () -> new LottoMoney(999));
    }

}
