package stringCalculator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static stringCalculator.Operator.*;

public class OperatorTest {

    @Test
    void operator() {
        assertThat(PLUS.getValue()).isEqualTo("+");
        assertThat(MINUS.getValue()).isEqualTo("-");
        assertThat(MULTIPLE.getValue()).isEqualTo("*");
        assertThat(DIVIDE.getValue()).isEqualTo("/");
    }
}
