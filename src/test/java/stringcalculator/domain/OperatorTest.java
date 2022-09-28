package stringcalculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import stringcalculator.domain.calculator.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class OperatorTest {

    @Test
    @DisplayName("+면 더하기 클래스 리턴")
    void get_plus() {
        //given
        String plus = "+";
        //when
        Calculator calculator = Operator.get(plus);
        //then
        assertThat(calculator).isInstanceOf(Plus.class);
    }

    @Test
    @DisplayName("-면 빼기 클래스 리턴")
    void get_subtract() {
        //given
        String subtract = "-";
        //when
        Calculator calculator = Operator.get(subtract);
        //then
        assertThat(calculator).isInstanceOf(Subtract.class);
    }

    @Test
    @DisplayName("*면 곱하기 클래스 리턴")
    void get_multiply() {
        //given
        String multiply = "*";
        //when
        Calculator calculator = Operator.get(multiply);
        //then
        assertThat(calculator).isInstanceOf(Multiply.class);
    }

    @Test
    @DisplayName("/면 나누기 클래스 리턴")
    void get_divide() {
        //given
        String divide = "/";
        //when
        Calculator calculator = Operator.get(divide);
        //then
        assertThat(calculator).isInstanceOf(Divide.class);
    }

    @Test
    @DisplayName("+,*,/,-가 아니면 에러")
    void not_operator() {
        //given
        String input = "{";
        //when
        //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Operator.get(input));


    }

}