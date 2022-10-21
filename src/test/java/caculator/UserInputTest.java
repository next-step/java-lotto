package caculator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class UserInputTest {
    @Test
    void null_또는_blank() {
        UserInput input = new UserInput();
        assertThatIllegalArgumentException()
                .isThrownBy(() -> input.checkBlank(null))
                .withMessageMatching("공백은 허용되지 않습니다.");
    }

    @Test
    void 수식_개수() {
        UserInput input = new UserInput();
        assertThat(input.checkFormula(Arrays.asList("1", "+", "2"))).isTrue();
        assertThatIllegalArgumentException()
                .isThrownBy(() -> input.checkFormula(Arrays.asList("1", "+")))
                .withMessageMatching("수식이 맞는지 확인 바랍니다.");
    }

    @Test
    void 수식() {
        UserInput input = new UserInput();
        assertThat(input.checkFormula(Arrays.asList("1", "+", "2"))).isTrue();
        assertThatIllegalArgumentException()
                .isThrownBy(() -> input.checkFormula(Arrays.asList("1", "2", "+")))
                .withMessageMatching("수식이 맞는지 확인 바랍니다.");
        assertThatIllegalArgumentException()
                .isThrownBy(() -> input.checkFormula(Arrays.asList("+", "1", "2")))
                .withMessageMatching("수식이 맞는지 확인 바랍니다.");
    }

    @Test
    void 사칙연산_기호() {
        UserInput input = new UserInput();
        assertThat(input.checkFormula(Arrays.asList("1", "+", "2"))).isTrue();
        assertThatIllegalArgumentException()
                .isThrownBy(() -> input.checkFormula(Arrays.asList("1", "%", "2")))
                .withMessageMatching("사칙 연산 기호만 입력 가능합니다.");
    }
}