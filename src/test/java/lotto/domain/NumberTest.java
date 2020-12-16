package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.domain.Number.MAX_NUMBER;
import static lotto.domain.Number.MIN_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("로또를 구성하는 각 번호 `Number`에 대한 테스트")
class NumberTest {

    @DisplayName("`Number` 생성")
    @ParameterizedTest
    @ValueSource(ints = {MIN_NUMBER, MAX_NUMBER})
    void createNumberTest(int expected) {
        // When
        Number number = new Number(expected);
        // Then
        assertAll(
                () -> assertThat(number).isNotNull(),
                () -> assertThat(number.getNumber()).isEqualTo(expected)
        );
    }

    @DisplayName("`Number` 생성시, 유효하지 않는 값 전달로 예외 발생 확인")
    @ParameterizedTest
    @ValueSource(ints = {Integer.MIN_VALUE, MIN_NUMBER - 1, MAX_NUMBER + 1, Integer.MAX_VALUE})
    void checkExceptionForInvalidNumberTest(int expected) {
        // When & Then
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Number(expected)
        );
    }
}
