import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class ExpressionParserTest {

    @Test
    @Description("null이 입력되면 IllegalArgumentException 발생")
    void parse_null() {
        assertThatThrownBy(() -> {
            ExpressionParser.parse(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @Description("사칙연산 기호가 아닌 기호가 입력되면 IllegalArgumentException 발생")
    void parse_invalid_operator() {
        assertThatThrownBy(() -> {
            ExpressionParser.parse("1 # 2");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @Description("올바른 수식이 입력되면 공백을 기준으로 분리")
    void parse_valid_expression() {
        String[] result = ExpressionParser.parse("1 / 2 + 3");
        assertThat(result).containsExactly("1", "/", "2", "+", "3");
    }
}
