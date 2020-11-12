package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperandCollectorTest {
    @Test
    void testCollect() {
        assertThat(OperandCollector.collect("1")).isEqualTo(1);
        assertThat(OperandCollector.collect("")).isEqualTo(0);
    }

    @Test
    void testValidate() {
        assertThatThrownBy(() -> {
            OperandCollector.collect("-1");
        }).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("음수");
    }
}
