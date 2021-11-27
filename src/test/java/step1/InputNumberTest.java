package step1;

import org.junit.jupiter.api.Test;
import step1.domain.Number;

import static org.assertj.core.api.Assertions.*;

public class InputNumberTest {
    @Test
    void create() {
        assertThat(new Number(1)).isEqualTo(new Number(1));
    }
}
