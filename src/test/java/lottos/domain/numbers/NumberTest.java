package lottos.domain.numbers;

import lottos.domain.exceptions.LottoNumberRangeIncorrectException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    @DisplayName("로또 숫자 범위가 아닐경우 에러")
    void lotto_range_check_exception(final Integer value) {
        Assertions.assertThrows(LottoNumberRangeIncorrectException.class, () -> Number.valueOf(value));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    @DisplayName("로또 숫자 범위일경우 정상 생성")
    void lotto_range_check(final Integer value) {
        Assertions.assertDoesNotThrow(() -> {
            Number number = Number.valueOf(value);
            Assertions.assertEquals(number.value(), value);
        });
    }

    @Test
    void 숫자_비교() {
        Number number1 = Number.valueOf(5);
        Number number2 = Number.valueOf(5);
        Number number3 = Number.valueOf(4);

        Assertions.assertEquals(number1, number2);
        Assertions.assertNotEquals(number1, number3);
        Assertions.assertNotEquals(number2, number3);
    }
}
