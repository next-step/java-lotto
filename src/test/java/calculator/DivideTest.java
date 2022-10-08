package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DivideTest {
    @Test
    void 나누기() {
        //given
        Number one = new Number("1");
        Number two = new Number("2");

        //when
        ArithmeticOperation divide = new Divide();
        Number result = divide.calculate(two, one);

        //then
        assertThat(result).isEqualTo(new Number("2"));
    }

    @Test
    void 정수로_떨어지지_않는_값을_가지는_나누기() {
        //given
        Number one = new Number("2");
        Number two = new Number("3");

        //when
        ArithmeticOperation divide = new Divide();

        //then
        assertThatThrownBy(() -> {
            divide.calculate(two, one);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
