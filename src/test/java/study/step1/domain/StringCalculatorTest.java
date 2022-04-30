package study.step1.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {
    @Test
    void 덧셈_계산을_하는_경우() {
        StringCalculator stringCalculator = StringCalculator.of(Formula.of("2 + 3"));
        stringCalculator.setUp();
        assertThat(stringCalculator.start()).isEqualTo("5");
    }

    @Test
    void 뺄셈_계산을_하는_경우() {
        StringCalculator stringCalculator = StringCalculator.of(Formula.of("2 - 3"));
        stringCalculator.setUp();
        assertThat(stringCalculator.start()).isEqualTo("-1");
    }

    @Test
    void 곱셈_계산을_하는_경우() {
        StringCalculator stringCalculator = StringCalculator.of(Formula.of("2 * 3"));
        stringCalculator.setUp();
        assertThat(stringCalculator.start()).isEqualTo("6");
    }

    @Test
    void 나눗셈_계산을_하는_경우() {
        StringCalculator stringCalculator = StringCalculator.of(Formula.of("4 / 2"));
        stringCalculator.setUp();
        assertThat(stringCalculator.start()).isEqualTo("2");
    }

    @Test
    void 모든_사칙연산을_계산을_하는_경우() {
        StringCalculator stringCalculator = StringCalculator.of(Formula.of("2 + 3 * 4 / 2"));
        stringCalculator.setUp();
        assertThat(stringCalculator.start()).isEqualTo("10");
    }

    @Test
    void 사용자가_입력하는_문자열에_사칙연산자_아닌_값을_입력하는_경우() {
        assertThatThrownBy(() -> Formula.of("2 ( 3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사용자가_입력하는_문자열에_슷자가_아닌_값을_입력하는_경우() {
        assertThatThrownBy(() -> Formula.of("가 + 3"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}