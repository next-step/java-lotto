package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @DisplayName("숫자 확인 테스트")
    @Test
    void isNumber() {
        assertThat(Calculator.isNumber("3")).isTrue();
        assertThat(Calculator.isNumber("-")).isFalse();
    }

    @DisplayName("계산 테스트")
    @Test
    void calculation() {
        assertThat(Calculator.calculation("51", "+", 9)).isEqualTo(60);
    }

    @DisplayName("결과 테스트")
    @ParameterizedTest
    @ValueSource(strings = "2 + 3 * 4 / 2")
    void start(String input) {
        String[] values = input.split(" ");
        Calculator.start(values);
        assertThat("결과 : 10").isEqualTo(outputStreamCaptor.toString().trim());
    }

    @DisplayName("입력 값이 null이거나 빈 공백 문자 검사 테스트")
    @Test
    void validateValue() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator.validateValue("");
        }).withMessageMatching("입력 값이 null이거나 빈 공백 문자입니다.");
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator.validateValue(null);
        }).withMessageMatching("입력 값이 null이거나 빈 공백 문자입니다.");
    }

}
