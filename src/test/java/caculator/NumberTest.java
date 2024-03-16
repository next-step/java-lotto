package caculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberTest {

    @Test
    void plus() {

        Number origin = new Number("5");
        Number other = new Number("7");
        origin.plus(other);

        Assertions.assertThat(origin).usingRecursiveComparison().isEqualTo(new Number(12));
    }
}