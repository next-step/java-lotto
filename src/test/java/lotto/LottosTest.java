package lotto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LottosTest {
    @Test
    void 로또_컬렉션_객체_생성() {
        // given, when, then
        assertDoesNotThrow(() -> new Lottos());
    }
}
