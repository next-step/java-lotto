package stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class IntegerTest {

    @Test
    void 마이너스_제로() {
        assertThat(Integer.parseInt("-0")).isEqualTo(0);
    }

}
