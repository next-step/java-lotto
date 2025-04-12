package lotto;

import lotto.model.LottoNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoNumberTest {


    @Test
    void verifyRange() {
        assertDoesNotThrow(() -> new LottoNumber(1));
        assertDoesNotThrow(() -> new LottoNumber(45));

        assertThrows(IllegalArgumentException.class, () -> new LottoNumber(46));
        assertThrows(IllegalArgumentException.class, () -> new LottoNumber(0));
    }
}
