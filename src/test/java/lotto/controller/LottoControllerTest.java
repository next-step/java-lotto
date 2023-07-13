package lotto.controller;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LottoControllerTest {
    @Test
    void 로또_컨트롤러_객체_생성_성공() {
        // given, when, then
        assertDoesNotThrow(LottoController::new);
    }
}
