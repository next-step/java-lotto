package step01Test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step01.StringAddCalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class calculatorTest {

    private StringAddCalculator stringAddCalculator;

    @Test
    @DisplayName(", 구분자 덧셈 테스트")
    void sum() {
        stringAddCalculator = new StringAddCalculator("3,4,7");
        assertThat(stringAddCalculator.sum()).isEqualTo("14");
    }

    @Test
    @DisplayName("구분자 테스트")
    void sumSeparator() {
        stringAddCalculator = new StringAddCalculator("3,4:7");
        assertThat(stringAddCalculator.sum()).isEqualTo("14");
    }

    @Test
    @DisplayName("하나의 숫자 sum 테스트")
    void sumOneNumber() {
        stringAddCalculator = new StringAddCalculator("1");
        assertThat(stringAddCalculator.sum()).isEqualTo("1");
    }

    @Test
    @DisplayName("0입력시 리턴 값 테스트")
    void sumInputValueIsZero() {
        stringAddCalculator = new StringAddCalculator("0");
        assertThat(stringAddCalculator.sum()).isEqualTo("0");
    }

    @Test
    @DisplayName("빈칸 입력시 리턴 값 테스트")
    void sumInputValueIsEmpty() {
        stringAddCalculator = new StringAddCalculator("");
        assertThat(stringAddCalculator.sum()).isEqualTo("0");
    }

    @Test
    @DisplayName("음수를 입력했을 때 RuntimeException 테스트")
    void sumNegativeRuntimeException() {
        stringAddCalculator = new StringAddCalculator("-1,2,3");
        assertThatThrownBy(() ->
            stringAddCalculator.sum())
        .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("커스텀 구분자 테스트")
    void sumCustomSeparator() {
        stringAddCalculator = new StringAddCalculator("//;\n1;2;3");
        assertThat(stringAddCalculator.sum()).isEqualTo("6");

    }
}
