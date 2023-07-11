package lotto;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class MoneyTest {

    @Test
    void 돈_객체_생성() {
        // given, when, then
        assertDoesNotThrow(() -> new Money(1000));
    }

    @Test
    void 돈_객체_값_반환_성공() {
        // given, when, then
        assertThat(new Money(1000).getValue()).isEqualTo(1000);
    }

}
