package calculator;

import calculator.domain.Division;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void 계산() {

        Calculator calculator = new Calculator();

        Assertions.assertThat( calculator.calculate("1 + 3")).isEqualTo(4);
    }

    @Test
    void 숫자_사칙연산_외_허용하지_않는다() {

        assertThatThrownBy(() ->
                new Calculator().calculate("1 + 3 $ 4")
        ).isInstanceOf(IllegalArgumentException.class);

    }
    @Test
    void 시작은_숫자_여야_한다() {

        assertThatThrownBy(() ->
                new Calculator().calculate("+ 3")
        ).isInstanceOf(IllegalArgumentException.class);

    }


    @Test
    void 마지막은_숫자_여야_한다() {

        assertThatThrownBy(() ->
                new Calculator().calculate("1 + 3 -")
        ).isInstanceOf(IllegalArgumentException.class);

    }


    @Test
    void 숫자_와_사칙연산_공백_필수다() {

        assertThatThrownBy(() ->
                new Calculator().calculate("1+3")
        ).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 연속된_사칙연산_허용하지_않는다() {

        assertThatThrownBy(() ->
                new Calculator().calculate("1 + + 3")
        ).isInstanceOf(IllegalArgumentException.class);

    }
}