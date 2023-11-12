package step1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputParserTest {

    private final InputParser inputParser = new InputParser();

    @Test
    public void 널_값_입력_시_에러_반환_테스트() {
        String userInput = null;

        assertThatThrownBy(() -> inputParser.splitUserInput(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "\n", "\t", "\t\n", "\n   \t "})
    public void 빈_문자열_입력_시_에러_반환_테스트(String userInput) {
        assertThatThrownBy(() -> inputParser.splitUserInput(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 숫자_리스트_반환_테스트() {
        List<String> tokens = makeTokens();

        List<Integer> numbers = inputParser.parseFromTokenToNumber(tokens);

        assertThat(numbers).hasSize(3);
        assertThat(numbers).containsExactly(1, 2, 3);
    }

    @Test
    public void 연산기호_리스트_정상_반환_테스트() {
        List<String> tokens = makeTokens();

        List<Operator> operators = inputParser.parseFromTokenToOperator(tokens);

        assertThat(operators).hasSize(2);
        assertThat(operators).containsExactly(Operator.PLUS, Operator.MULTIPLICATION);
    }

    @Test
    public void 연산기호가_아닌_다른_문자_입력_시_에러_반환_테스트() {
        List<String> tokens = makeTokens();
        tokens.add("a");
        tokens.add("3");

        assertThatThrownBy(() -> inputParser.parseFromTokenToOperator(tokens))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static List<String> makeTokens() {
        List<String> tokens = new ArrayList<>();
        tokens.add("1");
        tokens.add("+");
        tokens.add("2");
        tokens.add("*");
        tokens.add("3");
        return tokens;
    }
}
