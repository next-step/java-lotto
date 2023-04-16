package stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.security.InvalidParameterException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class OperatorTest {

    @Test
    void 나눗셈_큰수로나눔() {
        assertThatExceptionOfType(InvalidParameterException.class)
            .isThrownBy(() -> new Operator("/").calculation(new Number("4"), new Number("5")))
            .withMessageContaining("나누어 떨어지지 않는 수로는 나눌수 없습니다.");
    }

    @Test
    void 나눗셈_나누어떨어지지않음() {
        assertThatExceptionOfType(InvalidParameterException.class)
            .isThrownBy(() -> new Operator("/").calculation(new Number("4"), new Number("3")))
            .withMessageContaining("나누어 떨어지지 않는 수로는 나눌수 없습니다.");
    }

    @Test
    void 나눗셈_제로() {
        assertThatExceptionOfType(ArithmeticException.class)
            .isThrownBy(() -> new Operator("/").calculation(new Number("4"), new Number("0")))
            .withMessageMatching("/ by zero");
    }

    @Test
    void 나눗셈() {
        assertAll(
            () -> assertThat(
                new Operator("/").calculation(new Number("1"), new Number("1"))).isEqualTo(
                new Number("1")),
            () -> assertThat(
                new Operator("/").calculation(new Number("1"), new Number("-1"))).isEqualTo(
                new Number("-1")),
            () -> assertThat(
                new Operator("/").calculation(new Number("0"), new Number("1"))).isEqualTo(
                new Number("0")),
            () -> assertThat(
                new Operator("/").calculation(new Number("-1"), new Number("1"))).isEqualTo(
                new Number("-1")),
            () -> assertThat(
                new Operator("/").calculation(new Number("-1"), new Number("-1"))).isEqualTo(
                new Number("1"))
        );
    }

    @Test
    void 곱셈() {
        assertAll(
            () -> assertThat(
                new Operator("*").calculation(new Number("1"), new Number("1"))).isEqualTo(
                new Number("1")),
            () -> assertThat(
                new Operator("*").calculation(new Number("0"), new Number("1"))).isEqualTo(
                new Number("0")),
            () -> assertThat(
                new Operator("*").calculation(new Number("1"), new Number("0"))).isEqualTo(
                new Number("0")),
            () -> assertThat(
                new Operator("*").calculation(new Number("-1"), new Number("1"))).isEqualTo(
                new Number("-1")),
            () -> assertThat(
                new Operator("*").calculation(new Number("1"), new Number("-1"))).isEqualTo(
                new Number("-1")),
            () -> assertThat(
                new Operator("*").calculation(new Number("-1"), new Number("-1"))).isEqualTo(
                new Number("1"))
        );
    }

    @Test
    void 뺄셈() {
        assertAll(
            () -> assertThat(
                new Operator("-").calculation(new Number("1"), new Number("1"))).isEqualTo(
                new Number("0")),
            () -> assertThat(
                new Operator("-").calculation(new Number("1"), new Number("2"))).isEqualTo(
                new Number("-1"))
        );
    }

    @Test
    void 덧셈() {
        assertAll(
            () -> assertThat(
                new Operator("+").calculation(new Number("1"), new Number("1"))).isEqualTo(
                new Number("2")),
            () -> assertThat(
                new Operator("+").calculation(new Number("-1"), new Number("1"))).isEqualTo(
                new Number("0")),
            () -> assertThat(
                new Operator("+").calculation(new Number("-1"), new Number("-1"))).isEqualTo(
                new Number("-2")),
            () -> assertThat(
                new Operator("+").calculation(new Number("1"), new Number("-2"))).isEqualTo(
                new Number("-1"))
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"++", "--", "**", "//", "+-", "-*", "*/", "+-*/", "1", "a", "ㄱ"})
    void 사용불가연산(String input) {
        assertThatExceptionOfType(InvalidParameterException.class)
            .isThrownBy(() -> new Operator(input))
            .withMessageMatching("사용이 불가능한 연산자 입니다.");
    }

    @Test
    void 널() {
        assertThatExceptionOfType(InvalidParameterException.class)
            .isThrownBy(() -> new Operator(null))
            .withMessageMatching("연산자는 빈 값일 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    void 스페이스(String input) {
        assertThatExceptionOfType(InvalidParameterException.class)
            .isThrownBy(() -> new Operator(input))
            .withMessageMatching("연산자는 빈 값일 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    void 사용가능연산(String input) {
        assertThat(new Operator(input)).isEqualTo(new Operator(input));
    }

}
