package study.step1.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {
    @Test
    void 덧셈_계산을_하는_경우() {
        StringCalculator stringCalculator = new StringCalculator(Formula.from("2 + 3"));
        assertThat(stringCalculator.start()).isEqualTo(5);
    }

    @Test
    void 뺄셈_계산을_하는_경우() {
        StringCalculator stringCalculator = new StringCalculator(Formula.from("2 - 3"));
        assertThat(stringCalculator.start()).isEqualTo(-1);
    }

    @Test
    void 곱셈_계산을_하는_경우() {
        StringCalculator stringCalculator = new StringCalculator(Formula.from("2 * 3"));
        assertThat(stringCalculator.start()).isEqualTo(6);
    }

    @Test
    void 나눗셈_계산을_하는_경우() {
        StringCalculator stringCalculator = new StringCalculator(Formula.from("4 / 2"));
        assertThat(stringCalculator.start()).isEqualTo(2);
    }

    @Test
    void 음수를_계산을_하는_경우() {
        StringCalculator stringCalculator = new StringCalculator(Formula.from("-1 * 2"));
        assertThat(stringCalculator.start()).isEqualTo(-2);
    }

    @Test
    void 모든_사칙연산을_계산을_하는_경우() {
        StringCalculator stringCalculator = new StringCalculator(Formula.from("2 + 3 * 4 / 2"));
        assertThat(stringCalculator.start()).isEqualTo(10);
    }

    @Test
    void 복잡한_사칙연산을_계산을_하는_경우() {
        StringCalculator stringCalculator = new StringCalculator(Formula.from("100 - 50 / 2 * 4 - 50 - 5"));
        assertThat(stringCalculator.start()).isEqualTo(45);
    }
}