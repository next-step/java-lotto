package calcalator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("빈 문자열 또는 null을 입력할 경우 true 반환")
    void isEmpty(String input) {
        assertThat(Calculator.isEmpty(input)).isTrue();
    }

}