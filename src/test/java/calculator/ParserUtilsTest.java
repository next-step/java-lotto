package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
        assertThat(result).isEqualTo(false);
    }

    @DisplayName("null 입력을 확인한다.")
    @Test
    public void checkNullTest() {
        String input = null;
        boolean result = parserUtils.checkNull(input);
        assertThat(result).isEqualTo(false);
    }

}
