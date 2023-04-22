package calculator.domain;

import static calculator.domain.CalculatorApplication.calculate;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorApplicationTest {

    @Test
    @DisplayName("최종 연산 결과를 정상적으로 반환한다.")
    void calculateResultTest() {
        Queue<Integer> numbers = new LinkedList<>(Arrays.asList(7, 2, 3, 4, 5));
        Queue<String> operators = new LinkedList<>(Arrays.asList("+", "-", "*", "/"));
        assertThat(calculate(numbers, operators)).isEqualTo(4);
    }

}