package lotto;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LottoResultTest {

    @Test
    void 로또_당첨결과_객체_생성_성공() {
        // given, when, then
        assertDoesNotThrow(() -> new LottoResult(List.of()));
    }
}
