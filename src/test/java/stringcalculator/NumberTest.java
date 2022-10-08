package stringcalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
        number.add(2);

        assertThat(number).isEqualTo(new Number("3"));
    }

    @Test
    void minus() {
        Number number = new Number("3");
        number.minus(1);

        assertThat(number).isEqualTo(new Number("2"));
    }

}
