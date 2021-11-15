package step1;

import org.junit.jupiter.api.Test;
import step1.domain.Number;
import static org.assertj.core.api.Assertions.*;

public class NumberTest {
    @Test
    void numberTest() {
        Number number1 = new Number(1);
        Number number2 = new Number(1);
        assertThat(number1).isEqualTo(number2);
    }
}
