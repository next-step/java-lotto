package stringcalculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NaturalNumberTest {

    @Test
    @DisplayName("생성자에 음수를 전달하면 RuntimeException 이 발생한다.")
    void constructor_negative() {
        assertThatThrownBy(() -> NaturalNumber.valueOf(-1))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("양수를 생성자에 전달하면 생성자가 작동한다.")
    void constructor_positive() {
        NaturalNumber naturalNumber = NaturalNumber.valueOf(0);
        assertThat(naturalNumber).isEqualTo(NaturalNumber.valueOf(0));
    }

    @Test
    @DisplayName("문자열을 팩토리 메서드에 인자로 전달할 수 있다.")
    void valueOf_input_that_can_be_parsed() {
        NaturalNumber naturalNumber = NaturalNumber.valueOf("3");
        assertThat(naturalNumber).isEqualTo(NaturalNumber.valueOf(3));
    }

    @Test
    @DisplayName("숫자 이외의 문자열이 팩토리 메서드에 전달되면 RuntimeException 이 발생한다.")
    void valueOf_non_numerical_input() {
        assertThatThrownBy(() -> NaturalNumber.valueOf("asdf")).isInstanceOf(
                RuntimeException.class);
    }

    @Test
    @DisplayName("덧셈을 할 수 있다.")
    void add() {
        NaturalNumber one = NaturalNumber.valueOf(1);
        NaturalNumber two = NaturalNumber.valueOf(2);
        assertThat(NaturalNumber.sum(one, two)).isEqualTo(NaturalNumber.valueOf(3));
    }
}
