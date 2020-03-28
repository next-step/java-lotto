package StringAddCalculatorTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import stringAddCalculator.StringAddCalculator;
import stringAddCalculator.model.Expression;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTests {

    @DisplayName("문자열 덧셈 계산기 - null or empty")
    @NullAndEmptySource
    @ParameterizedTest
    public void splitAndSumNullOrEmpty(String input) {
        int result = StringAddCalculator.splitAndSum(Expression.newInstance(input));
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("문자열 덧셈 계산기 - 숫자 하나")
    @Test
    public void splitAndSumSoloNumber() {
        int result = StringAddCalculator.splitAndSum(Expression.newInstance("1"));
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("문자열 덧셈 계산기 - 쉼표 구분자")
    @Test
    public void splitAndSumCommaDelimiter() {
        int result = StringAddCalculator.splitAndSum(Expression.newInstance("1,2"));
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("문자열 덧셈 계산기 - 쉼표 또는 콜론 구분자")
    @Test
    public void splitAndSumCommaColonDelimiter() {
        int result = StringAddCalculator.splitAndSum(Expression.newInstance("1,2:3"));
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("문자열 덧셈 계산기 - 커스텀 구분자")
    @Test
    public void splitAndSumCustomDelimiter() {
        int result = StringAddCalculator.splitAndSum(Expression.newInstance("//;\n1;2;3"));
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("문자열 덧셈 계산기 - 음수 포함")
    @Test
    public void splitAndSumNegativeNumber() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(Expression.newInstance("-1,2,3")))
                .isInstanceOf(RuntimeException.class);
    }
}
