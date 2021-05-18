package calculator;

import calculator.domain.StringAddCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {
    @Test
    @DisplayName("SplitAndSum null 또는 빈문자")
    public void splitAndSum_null_또는_빈문자() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("SplitAndSum 숫자하나")
    public void splitAndSum_숫자하나() {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @ParameterizedTest
    @MethodSource(value = "calculatorResultsFixture")
    @DisplayName("SplitAndSum 기본구분자 및 커스텀 구분자")
    public void splitAndSum_기본구분자_및_커스텀구분자(CalculatorResult expressionWithExceptSum) {
        int result = StringAddCalculator.splitAndSum(expressionWithExceptSum.getExpression());
        assertThat(result).isEqualTo(expressionWithExceptSum.getExceptSum());
    }

    @Test
    @DisplayName("SplitAndSum 음수")
    public void splitAndSum_negative() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

    public static List<CalculatorResult> calculatorResultsFixture() {
        return Arrays.asList(
                new CalculatorResult("1,2", 3),
                new CalculatorResult("1,2:3", 6),
                new CalculatorResult("//;\n1;2;3", 6),
                new CalculatorResult("//@\n1@2@3", 6)
        );
    }

    static class CalculatorResult {
        private String expression;
        private int exceptSum;

        public CalculatorResult(String expression, int exceptSum) {
            this.expression = expression;
            this.exceptSum = exceptSum;
        }

        public String getExpression() {
            return expression;
        }

        public int getExceptSum() {
            return exceptSum;
        }
    }
}