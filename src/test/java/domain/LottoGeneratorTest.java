package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LottoGeneratorTest {

    @Test
    @DisplayName("로또를 자동으로 생성한다.")
    void generateAutomatically() {
        /* given */
        long money = 10_000L;

        /* when & then */
        assertDoesNotThrow(() -> LottoGenerator.generateAutomatically(money));
    }
}
