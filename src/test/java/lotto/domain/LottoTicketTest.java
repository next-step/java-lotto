package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class LottoNumbersTest {

    @Test
    void 로또티켓은_1에서45사이의_중복되지_않은_6개의_수이다() {
        assertThrows(IllegalArgumentException.class,
            () -> new LottoTicket(1, 2, 3, 3, 5, 6));
    }
}
