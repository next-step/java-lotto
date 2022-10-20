package domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ArithmeticSignTest {

    @ParameterizedTest
    @ValueSource(strings = {"+"})
    public void 더하기_기호_문자열_expect_Success(String text) {
        String plus = "+";
        ArithmeticSign sign = new ArithmeticSign(text);
        sign.equals(new ArithmeticSign(plus));

    }

    @ParameterizedTest
    @ValueSource(strings = {"-"})
    public void 빼기_기호_문자열_expect_Success(String text) {
        String subtract = "-";
        ArithmeticSign sign = new ArithmeticSign(text);
        sign.equals(new ArithmeticSign(subtract));

    }


    @ParameterizedTest
    @ValueSource(strings = {"*"})
    public void 곱하기_기호_문자열_expect_Success(String text) {
        String multiply = "-";
        ArithmeticSign sign = new ArithmeticSign(text);
        sign.equals(new ArithmeticSign(multiply));

    }


    @ParameterizedTest
    @ValueSource(strings = {"/"})
    public void 나누기_기호_문자열_expect_Success(String text) {
        String devide = "/";
        ArithmeticSign sign = new ArithmeticSign(text);
        sign.equals(new ArithmeticSign(devide));

    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    public void 산술기호_공백문자열_expect_IllegalArgumentException(String text) {
        assertThatIllegalArgumentException().isThrownBy(() -> new ArithmeticSign(text));
    }

    @ParameterizedTest
    @ValueSource(strings = {"=", "&", "$"})
    public void 산술기호_아닌_문자열_expect_IllegalArgumentException(String text) {
        assertThatIllegalArgumentException().isThrownBy(() -> new ArithmeticSign(text));
    }

    @ParameterizedTest
    @ValueSource(strings = {"가", "5", "10"})
    public void 기호_아닌_문자열_expect_IllegalArgumentException(String text) {
        assertThatIllegalArgumentException().isThrownBy(() -> new ArithmeticSign(text));
    }


    @ParameterizedTest
    @ValueSource(strings = {"++", "-+", "/*"})
    public void 산술기호_중복_문자열_expect_IllegalArgumentException(String text) {
        assertThatIllegalArgumentException().isThrownBy(() -> new ArithmeticSign(text));
    }

}
