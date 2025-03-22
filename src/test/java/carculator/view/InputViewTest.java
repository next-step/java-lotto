package carculator.view;

import carculator.domain.token.ExpressionParser;
import carculator.domain.token.Operator;
import carculator.domain.token.Token;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InputViewTest {

    public static final String INPUT = "2 + 3 * 4 / 2";

    @Test
    @DisplayName("사용자는 연산할 문자열을 입력을 할 수 있다.")
    public void inputTest() {
        FakeInputView input = new FakeInputView(INPUT);
        assertThat(input.read()).isEqualTo(INPUT);
    }

    @Test
    @DisplayName("연산할 문자열을 빈 공백 문자열을 기준으로 나눈다.")
    public void splitByBlank() {
        FakeInputView input = new FakeInputView(INPUT);

        List<Token> tokens = ExpressionParser.parseTokens(input.read());
        assertThat(tokens.size())
                .isEqualTo(INPUT.split(" ").length);
    }

    @Test
    @DisplayName("연산 기호는 사칙 연산이 아닌 경우 예외가 발생한다.")
    public void validateOperator() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Operator.from("~"));
    }
}
