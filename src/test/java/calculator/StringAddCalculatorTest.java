package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class StringAddCalculatorTest {

    private StringAddCalculator stringAddCalculator;

    @BeforeEach
    void setUp() {
        stringAddCalculator = new StringAddCalculator();
    }

    @DisplayName(value = "계산기를 생성할 수 있다")
    @Test
    public void canCreate() {
        new StringAddCalculator();
    }

    @DisplayName(value = "빈 문자열 또는 null 값을 입력할 경우 IllegalArgumentException 예외 처리를 한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void emptyOrNull(final String inputText) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> stringAddCalculator.calculate(inputText));
    }

}
