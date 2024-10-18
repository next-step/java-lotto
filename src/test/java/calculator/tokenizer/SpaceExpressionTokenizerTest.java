package calculator.tokenizer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import calculator.tokenizer.ExpressionTokenizer;
import calculator.tokenizer.SpaceExpressionTokenizer;
import java.util.List;
import org.junit.jupiter.api.Test;

public class SpaceExpressionTokenizerTest {

    @Test
    public void 공백으로_토큰화_테스트() {
        String input = "1 3 4 5";
        ExpressionTokenizer expressionTokenizer = new SpaceExpressionTokenizer();

        List<String> tokenize = expressionTokenizer.tokenize(input);

        assertThat(tokenize).containsSequence("1", "3", "4", "5");
    }

    @Test
    public void 빈문자_예외_테스트() {
        ExpressionTokenizer expressionTokenizer = new SpaceExpressionTokenizer();

        assertThatIllegalArgumentException().isThrownBy(()->expressionTokenizer.tokenize(" "));
    }


    @Test
    public void null값_예외_테스트() {
        ExpressionTokenizer expressionTokenizer = new SpaceExpressionTokenizer();

        assertThatIllegalArgumentException().isThrownBy(()->expressionTokenizer.tokenize(null));
    }

}
