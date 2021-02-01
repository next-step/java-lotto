package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoNumberTest {

    @DisplayName("45보다 큰 수로 생성시 exception 발생")
    @Test
    void numberLargerThan45ThrowsException() {
        // given
        int number = 46;

        // when & then
        assertThrows(IllegalArgumentException.class,
                () -> new LottoNumber(number));
    }

    @DisplayName("1보다 작은 수로 생성시 exception 발생")
    @Test
    void numberSmallerThan1ThrowsException() {
        // given
        int number = 0;

        // when & then
        assertThrows(IllegalArgumentException.class,
                () -> new LottoNumber(number));
    }
}