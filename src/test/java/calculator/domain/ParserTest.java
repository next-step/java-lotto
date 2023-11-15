package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.*;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class ParserTest {

    @ParameterizedTest(name = "사칙연산할 값을 입력 받는다. 값이 비어있는 경우 예외를 발생한다.")
    @NullAndEmptySource
    void input_string_with_null_or_empty(String input){
        assertThatThrownBy(() -> Parser.emptyValidate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("문자열을 구분자로 나눠서 List로 반환한다")
    void 문자열_분리() {
        String text = "4 + 3 * 1";
        List<String> split = Parser.split(text);
        assertThat(split).containsExactly("4", "+", "3", "*", "1");
    }

    @Test
    @DisplayName("사칙연산 순서에 사칙연산 기호가 아닌경우 예외 발생")
    void 사칙연산_아님(){
        List<String> expression = Arrays.asList("4", "3", "2", "-", "5");
        assertThatThrownBy(() -> Parser.operatorParsing(expression))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자 순서에 숫자가 아닌경우 예외 발생")
    void 숫자_아님(){
        List<String> expression = Arrays.asList("4", "+", "*", "-", "5");
        assertThatThrownBy(() -> Parser.numberParsing(expression))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자 순서에 모두 숫자일경우 숫자가 담긴 deque 리턴")
    void 숫자파싱(){
        List<String> expression = Arrays.asList("4", "+", "3", "-", "5");
        Deque<Integer> parsedNumberDeque = Parser.numberParsing(expression);
        Deque<Integer> expectedDeque = new ArrayDeque<>();

        expectedDeque.addLast(4);
        expectedDeque.addLast(3);
        expectedDeque.addLast(5);

        assertThat(parsedNumberDeque).containsExactlyElementsOf(expectedDeque);
    }

    @Test
    @DisplayName("연산자 순서에 모두 연산자일경우 연산자가 담긴 deque 리턴")
    void 연산자파싱(){
        List<String> expression = Arrays.asList("4", "+", "3", "-", "5");
        Deque<String> parsedOperatorDeque = Parser.operatorParsing(expression);
        Deque<String> expectedDeque = new ArrayDeque<>();

        expectedDeque.addLast("+");
        expectedDeque.addLast("-");

        assertThat(parsedOperatorDeque).containsExactlyElementsOf(expectedDeque);
    }
}