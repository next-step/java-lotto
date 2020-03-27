package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class StringAddCalculatorTest {
    @DisplayName(value = "계산기를 생성할 수 있다")
    @ParameterizedTest
    @ValueSource(strings = {"1+2"})
    public void canCreate(String inputText) {
        new StringAddCalculator(inputText);
    }

    @DisplayName(value = "빈 문자열 또는 null 값을 입력할 경우 RuntimeException 예외 처리를 한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void emptyOrNull(final String inputText) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> new StringAddCalculator(inputText));
    }



}
