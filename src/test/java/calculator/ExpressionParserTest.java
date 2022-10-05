package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExpressionParserTest {

    @Test
    void 입력값이_null_또는_빈_공백은_에러() {
        assertThatThrownBy(() -> new ExpressionParser(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사칙연산_기호가_아닌_경우_에러() {
        assertThatThrownBy(() -> new ExpressionParser("2 % 3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 연산자만_분리() {
        ExpressionParser parser = new ExpressionParser("2 + 3 * 4 / 2");
        Assertions.assertThat(parser.getOperators()).isEqualTo(new ArrayList<>(Arrays.asList(Operator.PLUS,Operator.MULTIPLY,Operator.DIVIDE)));
    }

    @Test
    void 피연산자만_분리() {
        ExpressionParser parser = new ExpressionParser("2 + 3 * 4 / 2");
        Assertions.assertThat(parser.getOperands()).isEqualTo(new ArrayList<Integer>(Arrays.asList(2,3,4,2)));
    }
}
