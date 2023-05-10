package step1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step1.domain.operator.Operator;

import static org.assertj.core.api.Assertions.*;

public class OperatorTest {

    @ParameterizedTest(name = "operator객체 만들기")
    @ValueSource(strings = "2 + 3 * 4 / 2")
    void 연산자_객체_생성(String input) {
        String[] inputs = input.split(" ");

        Operator operator = new Operator(inputs[1]);
        assertThat(operator).isEqualTo(new Operator("+"));
    }

    @ParameterizedTest(name = "operator객체 만들기 허용된 연산자 예외")
    @ValueSource(strings = "2 + 3 * 4 / 2")
    void 연산자_객체_생성_예외(String input) {
        String[] inputs = input.split(" ");
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Operator(inputs[0]))
                .withMessage(inputs[0] + "은(는) 잘못된 연산자 입니다.");
    }

}
