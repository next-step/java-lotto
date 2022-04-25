package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class StringCalculatorTest {
    @Test
    void 덧셈() {
        assertThat(StringCalculator.input("11 + 2 + 3")).isEqualTo(16);
    }

    @Test
    void 뺄셈() {
        assertThat(StringCalculator.input("1 - 2 - 3.5")).isEqualTo(-4.5);
    }

    @Test
    void 곱셈() {
        assertThat(StringCalculator.input("1 * 2 * 3")).isEqualTo(6);
    }

    @Test
    void 나눗셈() {
        assertThat(StringCalculator.input("1 * 2 / 2")).isEqualTo(1);
    }

    @Test
    void 나눗셈_소수점() {
        assertThat(StringCalculator.input("1 / 3")).isEqualTo(0.3333333333333333);
    }

    @Test
    void 나눗셈_0으로_나눴을_경우() {
        assertThatThrownBy(() -> {
            StringCalculator.input("3 / 0");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 공백_입력() {
        assertThatThrownBy(() -> {
            StringCalculator.input("");
        }).isInstanceOf(NullPointerException.class);
    }

    @Test
    void 숫자만_입력() {
        assertThatThrownBy(() -> {
            StringCalculator.input("1");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사칙연산만_입력() {
        assertThatThrownBy(() -> {
            StringCalculator.input("+");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사칙연산_아닌_문자열_입력() {
        assertThatThrownBy(() -> {
            StringCalculator.input("1 . 2");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자하나_사칙연산하나_만_입력() {
        assertThatThrownBy(() -> {
            StringCalculator.input("1 +");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사칙연산_기호를_계산_개수보다_많게_설정() {
        assertThatThrownBy(() -> {
            StringCalculator.input("1 + 2 + 3 +");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 공백기준_홀수자리에_숫자가_아닐경우() {
        assertThatThrownBy(() -> {
            StringCalculator.input("+ 1 + 2 + 3");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 공백기준_짝수자리에_연산자가_아닐경우() {
        assertThatThrownBy(() -> {
            StringCalculator.input("1 2 3 + 3");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}