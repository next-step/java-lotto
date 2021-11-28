package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ExpressionTest {

    @DisplayName("주어진 식을 통해 피연사자들의 합을 구할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"//$\n1$2$3", "//#\n1#2#3", "1,2,3", "1,2:3", "//,\n1,2,3"})
    void calculate(String value) {
        // given
        Expression expression = Expression.of(value);

        // when
        int result = expression.calculate();

        // then
        Assertions.assertThat(result).isEqualTo(6);
    }

    @DisplayName("빈 문자열이 들어왔을 때 합을 계산하면 0이 된다.")
    @Test
    void test() {
        Expression expression = Expression.of("");

        System.out.println(expression.calculate());
    }

}
