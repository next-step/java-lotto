package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoNumberTest {

    @DisplayName("45보다 큰 수를 넣을 경우 오류가 나는 케이스")
    @Test
    void numberLargerThan45ThrowsException() {
        // given
        int number = 46;

        // when & then
        assertThrows(IllegalArgumentException.class,
                () -> new LottoNumber(number));
    }

    @DisplayName("1보다 작은 수를 넣을 경우 오류가 나는 케이스")
    @Test
    void numberSmallerThan1ThrowsException() {
        // given
        int number = 0;

        // when & then
        assertThrows(IllegalArgumentException.class,
                () -> new LottoNumber(number));
    }
}