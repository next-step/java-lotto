package calculator;

import static org.assertj.core.api.Assertions.assertThat;

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

}
