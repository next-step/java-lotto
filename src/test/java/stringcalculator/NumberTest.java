package stringcalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import stringcalculator.domain.Number;

import static org.assertj.core.api.Assertions.*;

public class NumberTest {

    @Test
    void create() {
        Number actual = new Number("3");

        assertThat(actual).isEqualTo(new Number("3"));
    }

    @Test
    void valid() {
        Assertions.assertAll(
                () -> assertThatThrownBy(() -> new Number("a")).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new Number(null)).isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void add() {
        Number number = new Number("1");
        number.add(new Number("2"));

        assertThat(number).isEqualTo(new Number("3"));
    }

    @Test
    void minus() {
        Number number = new Number("3");
        number.minus(new Number("1"));

        assertThat(number).isEqualTo(new Number("2"));
    }

    @Test
    void multiply() {
        Assertions.assertAll(
                () -> {
                    Number number = new Number("3");
                    number.multiply(new Number("3"));
                    assertThat(number).isEqualTo(new Number("9"));
                },
                () -> {
                    Number number = new Number("3");
                    number.multiply(new Number("0"));
                    assertThat(number).isEqualTo(new Number("0"));
                }
        );
    }

    @Test
    void division() {
        Number number = new Number("3");
        number.division(new Number("3"));

        assertThat(number).isEqualTo(new Number("1"));
    }

    @Test
    void division_zero() {
        Number number = new Number("3");

        assertThatThrownBy(() -> number.division(new Number("0"))).isInstanceOf(IllegalArgumentException.class);
    }

}
