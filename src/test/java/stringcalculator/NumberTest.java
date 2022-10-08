package stringcalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberTest {

    @Test
    void create() {
        Number actual = new Number("3");

        Assertions.assertThat(actual).isEqualTo(new Number("3"));
    }
}
