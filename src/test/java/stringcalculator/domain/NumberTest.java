package stringcalculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static stringcalculator.domain.Number.of;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class NumberTest {

    @DisplayName("숫자를 인식한다")
    @CsvSource(value = { "1,1", "-1,-1"})
    @ParameterizedTest
    void 숫자를변환한다(String input, int expected) {
        assertThat(Number.parse(input)).isEqualTo(of(expected));
    }

    @DisplayName("숫자가 아닌 문자열은 생성할 수 없다")
    @Test
    void number_cannot_create() {
        Assertions.assertThatThrownBy(() -> {
            Number.parse("a");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자는 더할수있다")
    @Test
    void number_add() {
        assertThat(Number.parse("1").add(Number.parse("2")))
                  .isEqualTo(Number.parse("3"));
    }

    @DisplayName("숫자는 뺄수있다")
    @Test
    void number_minus() {
        assertThat(Number.parse("1").minus(Number.parse("2")))
                  .isEqualTo(of(-1));
    }

    @DisplayName("숫자는 곱할수있다")
    @Test
    void number_multiply() {
        assertThat(Number.parse("1").multiply(Number.parse("0")))
                  .isEqualTo(of(0));
    }

    @DisplayName("숫자는 나눌수있다")
    @Test
    void number_divide() {
        assertThat(Number.parse("4").divide(Number.parse("2")))
                .isEqualTo(of(2));
    }

    @DisplayName("복합적인 사칙연산을 수행할수있다")
    @Test
    void number_combined_operators() {
        assertThat(of(2).add(of(3)).multiply(of(4)).divide(of(2)))
                .isEqualTo(of(10));
    }
}
