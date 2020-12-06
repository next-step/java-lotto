package calculator;

import calculator.exception.NumberOutOfRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("숫자(Number) 테스트")
class NumberTest {

    @DisplayName("0과 양수의 값을 허용한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 10, 100})
    void create(int value) {
        // when
        Number number = Number.valueOf(value);

        // then
        assertThat(number).isNotNull();
    }

    @DisplayName("음수로 생성하려는 경우 예외처리(RuntimeException)를 한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, -10})
    void createLess(final int value) {
        // when / then
        assertThrows(NumberOutOfRangeException.class, () -> Number.valueOf(value),
                String.format("숫자는 " + Number.MIN_VALUE + "이상이어야 합니다 (입력 값: %d)", value));
    }

    @DisplayName("같은 숫자일 경우 동등성을 보장한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 10, 100})
    void equals(int value) {
        // when
        Number number = Number.valueOf(value);
        Number other = Number.valueOf(value);

        // then
        assertThat(number).isEqualTo(other);
    }

    @DisplayName("캐싱을 통해 같은 객체를 보장한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 10, 100})
    void cache(int value) {
        // when
        Number number = Number.valueOf(value);
        Number other = Number.valueOf(value);

        // then
        assertThat(number).isSameAs(other);
    }
}
