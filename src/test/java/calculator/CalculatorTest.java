package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    @Test
    @DisplayName("숫자와 연산자를 통해 계산기 정상적으로 객체를 생성한다")
    void createTest() {
        //given
        List<Number> numbers = List.of(new Number(1), new Number(2), new Number(3));
        List<Operator> operators = List.of(Operator.ADD, Operator.SUBTRACT);
        Calculator calculator = new Calculator(numbers, operators);

        //when
        Number resultNumber = calculator.calculate();

        //then
        assertThat(resultNumber).isEqualTo(new Number(0));
    }

    @Test
    @DisplayName("숫자가 하나일 경우 정상적으로 결과를 반환한다")
    void calculateWhenNumberSizeIsOne() {
        //given
        List<Number> numbers = List.of(new Number(1));
        ArrayList<Operator> operators = new ArrayList<>();
        Calculator calculator = new Calculator(numbers, operators);

        //when
        Number resultNumber = calculator.calculate();

        //then
        assertThat(resultNumber).isEqualTo(new Number(1));
    }

    @Test
    @DisplayName("숫자 갯수와 연산자 갯수의 검증이 실패했을 경우 예외를 발생시킨다")
    void invalidSizeWithNumbersAndOperatorsTest() {
        //given
        List<Number> numbers = List.of(new Number(0), new Number(1), new Number(2));
        List<Operator> operators = List.of(Operator.ADD);

        //when, then
        assertThatThrownBy(() -> new Calculator(numbers, operators)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자가 없을 경우 예외를 발생시킨다")
    void isEmptyNumberTest() {
        //given
        List<Number> numbers = new ArrayList<>();
        List<Operator> operators = new ArrayList<>();

        //when, then
        assertThatThrownBy(() -> new Calculator(numbers, operators)).isInstanceOf(IllegalArgumentException.class);
    }

}