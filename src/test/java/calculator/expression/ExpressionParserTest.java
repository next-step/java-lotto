package calculator.expression;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.Test;

public class ExpressionParserTest {

    @Test
    void 입력문자열_공백_예외처리(){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            ExpressionParser.parse("");
        });
    }

    @Test
    void 입력문자열_null_예외처리(){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            ExpressionParser.parse(null);
        });
    }

    @Test
    void 입력문자열_나누기(){
        List<String> token = ExpressionParser.split("2 + 13 * 4 / 2");

        assertThat(Objects.requireNonNull(token)).hasSize(7);
        assertThat(token.get(0)).isEqualTo("2");
        assertThat(token.get(1)).isEqualTo("+");
        assertThat(token.get(2)).isEqualTo("13");
        assertThat(token.get(3)).isEqualTo("*");
        assertThat(token.get(5)).isEqualTo("/");
        assertThat(token.get(6)).isEqualTo("2");
    }

    @Test
    void 입력문자열_파싱(){
        List<ExpressionComponent> parse = ExpressionParser.parse("2 + 13 * 4 / 2");

        assertThat(Objects.requireNonNull(parse)).hasSize(7);
        assertThat(parse.get(0)).isInstanceOf(Operand.class);
        assertThat(parse.get(1)).isInstanceOf(AddOperator.class);
        assertThat(parse.get(3)).isInstanceOf(MultiplyOperator.class);
        assertThat(parse.get(5)).isInstanceOf(DivideOperator.class);
    }

}
