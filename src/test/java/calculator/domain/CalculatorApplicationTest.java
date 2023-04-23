package calculator.domain;

import static calculator.domain.CalculatorApplication.calculate;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorApplicationTest {

    @Test
    @DisplayName("연산자 없이 단일 숫자로만 이루어진 경우 입력된 숫자만 리턴한다.")
    void singleNumberTest() {
        Queue<Integer> numbers = new LinkedList<>(List.of(33));
        Queue<String> operators = new LinkedList<>(List.of());
        assertThat(calculate(numbers, operators)).isEqualTo(33);
    }

    @Test
    @DisplayName("더하기 연산 수행시 정상 결과값을 반환한다.")
    void doubleNumberTest() {
        Queue<Integer> numbers = new LinkedList<>(Arrays.asList(10,20));
        Queue<String> operators = new LinkedList<>(Arrays.asList("+"));
        assertThat(calculate(numbers, operators)).isEqualTo(30);
    }

    @Test
    @DisplayName("최종 연산 결과를 정상적으로 반환한다.")
    void calculateResultTest() {
        Queue<Integer> numbers = new LinkedList<>(Arrays.asList(7, 2, 3, 4, 5));
        Queue<String> operators = new LinkedList<>(Arrays.asList("+", "-", "*", "/"));
        assertThat(calculate(numbers, operators)).isEqualTo(4);
    }

}