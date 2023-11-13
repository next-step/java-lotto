package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static org.assertj.core.api.Assertions.*;

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
        assertThatThrownBy(() -> Parser.numberReverseParsing(expression))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자 순서에 모두 숫자일경우 역순으로 적재된 스택 리턴")
    void 숫자파싱(){
        List<String> expression = Arrays.asList("4", "+", "3", "-", "5");
        Stack<Integer> parsedNumberStack = Parser.numberReverseParsing(expression);
        Stack<Integer> expectedStack = new Stack<>();

        expectedStack.push(5);
        expectedStack.push(3);
        expectedStack.push(4);

        assertThat(parsedNumberStack.size()).isEqualTo(expectedStack.size());

        for (int i = 0; i < expectedStack.size(); i++) {
            assertThat(parsedNumberStack.get(i)).isEqualTo(expectedStack.get(i));
        }
    }

    @Test
    @DisplayName("연산자 순서에 모두 연산자일경우 역순으로 적재된 스택 리턴")
    void 연산자파싱(){
        List<String> expression = Arrays.asList("4", "+", "3", "-", "5");
        Stack<String> parsedOperatorStack = Parser.operatorParsing(expression);
        Stack<String> expectedStack = new Stack<>();

        expectedStack.push("-");
        expectedStack.push("+");

        assertThat(parsedOperatorStack.size()).isEqualTo(expectedStack.size());

        for (int i = 0; i < expectedStack.size(); i++) {
            assertThat(parsedOperatorStack.get(i)).isEqualTo(expectedStack.get(i));
        }
    }
}