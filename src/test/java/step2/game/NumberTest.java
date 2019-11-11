package step2.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step2.numbers.Number;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    @DisplayName("범위의 맞는 숫자가 나오는 지 확인")
    void verifyOf(int num) {
        assertThat(Number.valueOf(num).toString()).isEqualTo(String.valueOf(num));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    @DisplayName("범위의 맞지 않는 숫자는 에러 출력")
    void verifyOfWithException(int num) {
        assertThrows(IllegalArgumentException.class, () -> Number.valueOf(num));
    }


}