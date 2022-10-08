package stringcalculator;

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
        assertThatThrownBy(() -> new Number("a")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void add(){
        Number number = new Number("1");
        number.add(2);

        assertThat(number).isEqualTo(new Number("3"));
    }
}
