package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class NumbersTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,5,3", "1,5:3", "//;\n1;5;3", "//;\n1;5,3"})
    void 연산자를_구분자기준_분리(String expression) {
        // when
        Numbers numbers = new Numbers(expression);

        // then
        assertThat(numbers.get(0).getNumber()).isEqualTo(1);
        assertThat(numbers.get(1).getNumber()).isEqualTo(5);
        assertThat(numbers.get(2).getNumber()).isEqualTo(3);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 빈_문자열이나_null일_때는_0을_반환(String expression) {
        // when
        Numbers numbers = new Numbers(expression);

        // then
        assertThat(numbers.getNumbers().get(0).getNumber()).isEqualTo(0);
        assertThat(numbers.getNumbers().size()).isEqualTo(1);
    }

    @Test
    void 숫자_하나를_문자열로_입력할경우_해당_숫자를_반환한다() {
        // when
        Numbers numbers = new Numbers("5");

        // then
        assertThat(numbers.getNumbers().get(0).getNumber()).isEqualTo(5);
        assertThat(numbers.getNumbers().size()).isEqualTo(1);
    }
}
