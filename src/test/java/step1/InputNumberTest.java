package step1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class InputNumberTest {
    @Test
    void create() {
        assertThat(new InputNumber(1)).isEqualTo(new InputNumber(1));
    }
}
