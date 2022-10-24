package domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class ArithmeticSignTest {

    @ParameterizedTest
    @ValueSource(strings = {"+"})
    public void 더하기_기호_문자열_expect_Success(String text) {
        assertThat(ArithmeticSign.of(text)).isEqualTo(ArithmeticSign.PLUS);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-"})
    public void 빼기_기호_문자열_expect_Success(String text) {
        assertThat(ArithmeticSign.of(text)).isEqualTo(ArithmeticSign.MINUS);
    }

    @ParameterizedTest
    @ValueSource(strings = {"*"})
    public void 곱하기_기호_문자열_expect_Success(String text) {
        assertThat(ArithmeticSign.of(text)).isEqualTo(ArithmeticSign.MULTIPLICATION);
    }

    @ParameterizedTest
    @ValueSource(strings = {"/"})
    public void 나누기_기호_문자열_expect_Success(String text) {
        assertThat(ArithmeticSign.of(text)).isEqualTo(ArithmeticSign.DIVISION);
    }


    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    public void 산술기호_공백문자열_expect_IllegalArgumentException(String text) {
        assertThatIllegalArgumentException().isThrownBy(() -> ArithmeticSign.of(text));
    }

    @ParameterizedTest
    @ValueSource(strings = {"=", "&", "$"})
    public void 산술기호_아닌_문자열_expect_IllegalArgumentException(String text) {
        assertThatIllegalArgumentException().isThrownBy(() -> ArithmeticSign.of(text));
    }

    @ParameterizedTest
    @ValueSource(strings = {"가", "5", "10"})
    public void 기호_아닌_문자열_expect_IllegalArgumentException(String text) {
        assertThatIllegalArgumentException().isThrownBy(() -> ArithmeticSign.of(text));
    }


    @ParameterizedTest
    @ValueSource(strings = {"++", "-+", "/*"})
    public void 산술기호_중복_문자열_expect_IllegalArgumentException(String text) {
        assertThatIllegalArgumentException().isThrownBy(() -> ArithmeticSign.of(text));
    }

    @Test
    public void 덧셈_expect_success() {
        assertThat(ArithmeticSign.PLUS.doArithmetic(new Number(3), new Number(5))).isEqualTo(new Number(8));
    }


    @Test
    public void 뺄셈_expect_success() {
        assertThat(ArithmeticSign.MINUS.doArithmetic(new Number(7), new Number(4))).isEqualTo(new Number(3));
    }


    @Test
    public void 곱셈_expect_success() {
        assertThat(ArithmeticSign.MULTIPLICATION.doArithmetic(new Number(5), new Number(9))).isEqualTo(new Number(45));
    }


    @Test
    public void 나눗셈_expect_success() {
        assertThat(ArithmeticSign.DIVISION.doArithmetic(new Number(12), new Number(3))).isEqualTo(new Number(4));
    }


    @Test
    public void 나눗셈_0으로_나누기_expect_IllegalArgumentException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> ArithmeticSign.DIVISION.doArithmetic(new Number(8), new Number(0)));
    }

    @Test
    public void 나눗셈_결과_정수아님_expect_IllegalArgumentException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> ArithmeticSign.DIVISION.doArithmetic(new Number(8), new Number(3)));
    }

}
