package stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.security.InvalidParameterException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberTest {

    @Test
    void 나눗셈_제로() {
        assertThatExceptionOfType(ArithmeticException.class)
            .isThrownBy(() -> new Number("1").calculation(new Operation("/"), new Number("0")))
            .withMessageMatching("/ by zero");
    }

    @Test
    void 나눗셈() {
        assertAll(
            () -> assertThat(
                new Number("1").calculation(new Operation("/"), new Number("1"))).isEqualTo(
                new Number("1")),
            () -> assertThat(
                new Number("0").calculation(new Operation("/"), new Number("1"))).isEqualTo(
                new Number("0")),
            () -> assertThat(
                new Number("-1").calculation(new Operation("/"), new Number("1"))).isEqualTo(
                new Number("-1")),
            () -> assertThat(
                new Number("-1").calculation(new Operation("/"), new Number("-1"))).isEqualTo(
                new Number("1"))
        );
    }

    @Test
    void 곱셈() {
        assertAll(
            () -> assertThat(
                new Number("1").calculation(new Operation("*"), new Number("1"))).isEqualTo(
                new Number("1")),
            () -> assertThat(
                new Number("0").calculation(new Operation("*"), new Number("1"))).isEqualTo(
                new Number("0")),
            () -> assertThat(
                new Number("1").calculation(new Operation("*"), new Number("0"))).isEqualTo(
                new Number("0")),
            () -> assertThat(
                new Number("-1").calculation(new Operation("*"), new Number("1"))).isEqualTo(
                new Number("-1")),
            () -> assertThat(
                new Number("-1").calculation(new Operation("*"), new Number("-1"))).isEqualTo(
                new Number("1"))
        );
    }

    @Test
    void 뺄셈() {
        assertAll(
            () -> assertThat(
                new Number("1").calculation(new Operation("-"), new Number("1"))).isEqualTo(
                new Number("0")),
            () -> assertThat(
                new Number("1").calculation(new Operation("-"), new Number("2"))).isEqualTo(
                new Number("-1"))
        );
    }

    @Test
    void 덧셈() {
        assertAll(
            () -> assertThat(
                new Number("1").calculation(new Operation("+"), new Number("1"))).isEqualTo(
                new Number("2")),
            () -> assertThat(
                new Number("-1").calculation(new Operation("+"), new Number("1"))).isEqualTo(
                new Number("0")),
            () -> assertThat(
                new Number("-1").calculation(new Operation("+"), new Number("-1"))).isEqualTo(
                new Number("-2")),
            () -> assertThat(
                new Number("1").calculation(new Operation("+"), new Number("-2"))).isEqualTo(
                new Number("-1"))
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "1a", "10 ", " a", "ㄱ", "일"})
    void 문자입력(String input) {
        assertThatExceptionOfType(NumberFormatException.class)
            .isThrownBy(() -> new Number(input))
            .withMessageContaining("For input string: ");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "10"})
    void 제로_양수(String input) {
        assertThat(new Number(input)).isEqualTo(new Number(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void 빈값(String input) {
        assertThatExceptionOfType(InvalidParameterException.class)
            .isThrownBy(() -> new Number(input))
            .withMessageMatching("빈 숫자는 입력할 수 없습니다.");
    }

    @Test
    void 널() {
        assertThatExceptionOfType(InvalidParameterException.class)
            .isThrownBy(() -> new Number(null))
            .withMessageMatching("빈 숫자는 입력할 수 없습니다.");
    }

    @Test
    void 숫자생셩() {
        assertThat(new Number("1")).isEqualTo(new Number("1"));
    }

}
