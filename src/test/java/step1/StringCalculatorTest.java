package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class StringCalculatorTest {

    @Test
    @DisplayName("문자열을 입력하면 적절한 Operators 혹은 Numbers 에 값을 추가해준다.")
    void addElement() {
        // given
        String numberInput = "-2";
        String operatorInput = "/";
        StringCalculator stringCalculator = new StringCalculator();
        // when
        stringCalculator.addElement(numberInput);
        stringCalculator.addElement(operatorInput);
        // then
        assertThat(stringCalculator).isEqualTo(
                new StringCalculator(new Operators(List.of(Operator.DIVIDE)), new Numbers(List.of(-2)))
        );
    }

    @Test
    @DisplayName("내부 Operators 와 Numbers 를 이용하여 문자열 연산을 진행합니다.")
    void calculate() {
        // given
        StringCalculator stringCalculator = new StringCalculator(
                new Operators(List.of(Operator.PLUS, Operator.MULTIPLE, Operator.DIVIDE)),
                new Numbers(List.of(2, 3, 4, 2))
        );
        // when
        int result = stringCalculator.calculate();
        // then
        assertThat(result).isEqualTo(10);
    }

    @Test
    @DisplayName("내부 Operators 혹은 Numbers 가 빈 리스트라면 RuntimeException을 던집니다.")
    void calculateNull() {
        // given
        StringCalculator stringCalculator = new StringCalculator();
        // when
        // then
        assertThatThrownBy(stringCalculator::calculate)
                .isInstanceOf(RuntimeException.class)
                .hasMessage("초기 연산자와 숫자 세팅이 이루어지지 않았습니다.");
    }
}