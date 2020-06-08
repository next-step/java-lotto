package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParserUtilsTest {

    private ParserUtils parserUtils;

    @BeforeEach
    void setUp() {
        parserUtils = new ParserUtils();
    }

    @DisplayName("빈 문자열 입력을 확인한다.")
    @Test
    public void checkEmptyTest() {
        String input = "";
        boolean result = parserUtils.checkEmpty(input);
        assertThat(result).isEqualTo(true);
    }

    @DisplayName("null 입력을 확인한다.")
    @Test
    public void checkNullTest() {
        String input = null;
        boolean result = parserUtils.checkNull(input);
        assertThat(result).isEqualTo(true);
    }

    @DisplayName("숫자 하나를 입력했을때 해당 숫자 반환")
    @Test
    public void stringToArray() {
        String input = "1";
        List result = parserUtils.stringToArray(input);
        assertThat(result).contains(1);
    }

    @DisplayName(",포함된 숫자 두개 입력시 리스트로 반환")
    @Test
    public void stringToArrayWithComma() {
        String input = "1,2";
        List result = parserUtils.stringToArray(input);
        assertThat(result).contains(1, 2);
    }

    @DisplayName(",이외에 콜론으로도 구분하여 리스트 반환")
    @Test
    public void stringToArrayWithAnotherSymbol() {
        String input = "1,2:3";
        List result = parserUtils.stringToArray(input);
        assertThat(result).contains(1, 2, 3);
    }

    @DisplayName("//와 \n 문자 사이에 커스텀 구분자를 통해 리스트로 반환")
    @Test
    public void stringToArrayWithCustomSymbol() {
        String input = "//;\n1;2;3";
        List result = parserUtils.stringToArray(input);
        assertThat(result).contains(1, 2, 3);
    }

    @DisplayName("음수 입력시 에러가 발생함")
    @Test
    public void stringToArrayWithMinusInput() {
        String input = "-1,2,3";
        assertThatThrownBy(() -> {
            parserUtils.stringToArray(input);
        }).isInstanceOf(RuntimeException.class);
    }

}
