package lotto;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class MoneyTest {

    @Test
    void 돈_객체_생성() {
        // given, when, then
        assertDoesNotThrow(() -> new Money());
    }

}
