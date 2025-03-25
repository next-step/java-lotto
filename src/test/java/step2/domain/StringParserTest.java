package step2.domain;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StringParserTest {

    private final StringParser parser = new StringParser();

    @Test
    public void testSplitExpression_ValidInput() {
        ExpressionElement result = parser.splitExpression("10 + 20 * 3");

        List<Integer> expectedNumbers = List.of(10, 20, 3);
        List<String> expectedOperators = List.of("+", "*");

        assertThat(result.getElements()).isEqualTo(expectedNumbers);
        assertThat(result.getOperators()).isEqualTo(expectedOperators);
    }

    @Test
    public void testSplitExpression_InvalidInput_Null() {
        assertThatIllegalArgumentException().isThrownBy(() -> parser.splitExpression(null))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testSplitExpression_InvalidInput_EmptyString() {
        assertThatIllegalArgumentException().isThrownBy(() -> parser.splitExpression(""))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
