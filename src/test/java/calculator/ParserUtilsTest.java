package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParserUtilsTest {

    @DisplayName("빈 문자열과 null 입력을 확인한다.")
    @ParameterizedTest
    @MethodSource
    public void checkValid(String input, boolean expectedResult){
        boolean result = ParserUtils.checkValid(input);
        assertThat(result).isEqualTo(expectedResult);

    }

    private static Stream<Arguments> checkValid() {
        return Stream.of(
                Arguments.of(null, true),
                Arguments.of("",true),
                Arguments.of("1:2", false)
        );
    }


    @DisplayName("숫자 하나를 입력했을때 해당 숫자 반환")
    @Test
    public void stringToArray() {
        String input = "1";
        List result = ParserUtils.stringToArray(input);
        assertThat(result).contains(1);
    }

    @DisplayName(",포함된 숫자 두개 입력시 리스트로 반환")
    @Test
    public void stringToArrayWithComma() {
        String input = "1,2";
        List result = ParserUtils.stringToArray(input);
        assertThat(result).contains(1, 2);
    }

    @DisplayName(",이외에 콜론으로도 구분하여 리스트 반환")
    @Test
    public void stringToArrayWithAnotherSymbol() {
        String input = "1,2:3";
        List result = ParserUtils.stringToArray(input);
        assertThat(result).contains(1, 2, 3);
    }

    @DisplayName("//와 \n 문자 사이에 커스텀 구분자를 통해 리스트로 반환")
    @Test
    public void stringToArrayWithCustomSymbol() {
        String input = "//;\n1;2;3";
        List result = ParserUtils.stringToArray(input);
        assertThat(result).contains(1, 2, 3);
    }

    @DisplayName("음수 입력시 에러가 발생함")
    @Test
    public void stringToArrayWithMinusInput() {
        String input = "-1,2,3";
        assertThatThrownBy(() -> {
            ParserUtils.stringToArray(input);
        }).isInstanceOf(RuntimeException.class);
    }

}
