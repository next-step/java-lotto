package calculator;

import static calculator.Calculator.*;
import static calculator.ErrorMessage.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.LinkedList;
import java.util.Queue;

class CalculatorTest {
    @DisplayName("공백으로 문자열에서 숫자와 사칙연산 분리")
    @Test
    void 문자열_분리() {
        String input = "4 + 6";
        String calculateArray[] = splitInput(input);
        assertThat(calculateArray[0]).isEqualTo("4");
        assertThat(calculateArray[1]).isEqualTo("+");
        assertThat(calculateArray[2]).isEqualTo("6");
    }

    @DisplayName("입력받은 문자가 빈 공백이거나 null일 경우 에러를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    void 빈공백문자_혹은_null일경우_에러(String input) {
        assertThatThrownBy(() -> {
            splitInput(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BLINK_INPUT_ERROR);
    }

    @DisplayName("분리한 문자를 Queue에 넣는다.")
    @Test
    void 문자_Queue에_넣기() {
        String[] calculateArray = {"4", "+", "6"};
        Queue<String> queue = addArrToQueue(calculateArray);
        assertThat(queue.poll()).isEqualTo(calculateArray[0]);
        assertThat(queue.poll()).isEqualTo(calculateArray[1]);
        assertThat(queue.poll()).isEqualTo(calculateArray[2]);
    }



    @DisplayName("입력받은 문자가 숫자가 아닌 경우 에러를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "hi"})
    void 숫자가_아닌경우_에러(String input) {
        assertThatThrownBy(() -> {
            convertStringToInt(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INPUT_IS_NOT_NUMBER);
    }

    @DisplayName("입력받은 문자가 숫자일 경우 숫자로 변환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "3", "-1", "0"})
    void 문자를_숫자로_변환(String input) {
        assertThat(convertStringToInt(input)).isEqualTo(Integer.parseInt(input));
    }

    @DisplayName("입력받은 문자가 사칙연산 기호가 아닌 경우 에러를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "h"})
    void 사칙연산_기호가_아닌경우_에러(String input) {
        assertThatThrownBy(() -> {
            validateOperationSymbol(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INPUT_IS_NOT_OPERATOR_SYMBOL);
    }

    @DisplayName("숫자 2개 더하기")
    @Test
    void 덧셈() {
        int num1 = 5;
        int num2 = 3;
        assertThat(addNumbers(num1, num2)).isEqualTo(8);
    }

    @DisplayName("숫자 2개 빼기")
    @Test
    void 뺄셈() {
        int num1 = 5;
        int num2 = 3;
        assertThat(subtractNumbers(num1, num2)).isEqualTo(2);
    }

    @DisplayName("숫자 2개 곱하기")
    @Test
    void 곱셈() {
        int num1 = 5;
        int num2 = 3;
        assertThat(multiplyNumbers(num1, num2)).isEqualTo(15);
    }

    @DisplayName("숫자 2개 나누기")
    @Test
    void 나눗셈() {
        int num1 = 5;
        int num2 = 3;
        assertThat(divideNumbers(num1, num2)).isEqualTo(1);
    }

    @DisplayName("0으로 나눌 때 에러발생")
    @Test
    void 나눗셈_에러() {
        int num1 = 5;
        int num2 = 0;
        assertThatThrownBy(() -> {
            divideNumbers(num1, num2);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DIVDE_ZERO_ERROR);
    }


}