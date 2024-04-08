package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

    @Test
    @DisplayName("로또 숫자의 범위가 1보다 작거나 45보다 크면 예외가 발생한다")
    void range_exception_test() {
        assertThrows(IllegalArgumentException.class, () -> new LottoNumber(0));
        assertThrows(IllegalArgumentException.class, () -> new LottoNumber(46));
    }
}
