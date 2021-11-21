package stringaddcalculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class ExpressionTest {

    @DisplayName("expression에 null 또는 빈 문자열이 주어졌을 때 null or empty 여부를 반환하는지 검증")
    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmptyTest(String input) {
        Expression expression = new Expression(input);
        assertThat(expression.isNullOrEmpty()).isTrue();
    }
}
