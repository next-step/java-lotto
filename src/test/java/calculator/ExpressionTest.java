package calculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ExpressionTest {

    @Test
    public void 문자열_콤마_분리() {
        String expression = "1,2,3";
        int[] result = Expression.extractOperands(expression);

        for (int i = 0; i < result.length; i++) {
            assertThat(result[i]).isEqualTo(i+1);
        }
    }

    @Test
    public void 문자열_콜론_분리() {
        String expression = "1:2:3";
        int[] result = Expression.extractOperands(expression);

        for (int i = 0; i < result.length; i++) {
            assertThat(result[i]).isEqualTo(i+1);
        }
    }

    @Test
    public void 입력값이_nullOrEmpty() {
        boolean isNullOrEmpty = Expression.isNullOrEmpty("");
        assertThat(isNullOrEmpty).isEqualTo(true);
    }
}
