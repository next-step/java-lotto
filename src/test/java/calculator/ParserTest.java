package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.List;

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
    @DisplayName("사칙연산 기호가 아닌경우 예외 발생")
    void 사칙연산_아님(){
        List<String> expression = Arrays.asList("4", "3", "2", "-", "5");
        assertThatThrownBy(() -> Parser.operatorParsing(expression))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자가 아닌경우 예외 발생")
    void 숫자_아님(){
        List<String> expression = Arrays.asList("4", "+", "*", "-", "5");
        assertThatThrownBy(() -> Parser.numberParsing(expression))
                .isInstanceOf(IllegalArgumentException.class);
    }
}