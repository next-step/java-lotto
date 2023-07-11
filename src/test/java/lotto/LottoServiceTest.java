package lotto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {

    @Test
    void 로또_서비스_객체_생성_성공() {
        // given, when, then
        assertDoesNotThrow(() -> new LottoService());
    }
}
