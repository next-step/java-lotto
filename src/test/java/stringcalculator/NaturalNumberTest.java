package stringcalculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NaturalNumberTest {

    @Test
    @DisplayName("생성자에 음수를 입력하면 RuntimeException throw")
    void constructor_negative() {
        assertThatThrownBy(() -> NaturalNumber.valueOf(-1))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("생성자 작동")
    void constructor_positive() {
        NaturalNumber naturalNumber = NaturalNumber.valueOf(0);
        assertThat(naturalNumber).isEqualTo(NaturalNumber.valueOf(0));
    }

    @Test
    @DisplayName("팩토리 메서드에 String 값을 인자로 주었을 때")
    void valueOf_input_that_can_be_parsed() {
        NaturalNumber naturalNumber = NaturalNumber.valueOf("3");
        assertThat(naturalNumber).isEqualTo(NaturalNumber.valueOf(3));
    }

    @Test
    @DisplayName("숫자 외의 String 값을 인자로 주었을 때")
    void valueOf_non_numerical_input() {
        assertThatThrownBy(() -> NaturalNumber.valueOf("asdf")).isInstanceOf(
                RuntimeException.class);
    }

    @Test
    @DisplayName("덧셈 구현")
    void add() {
        NaturalNumber one = NaturalNumber.valueOf(1);
        NaturalNumber two = NaturalNumber.valueOf(2);
        assertThat(NaturalNumber.sum(one, two)).isEqualTo(NaturalNumber.valueOf(3));
    }
}
