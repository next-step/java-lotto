package step1;

import org.junit.jupiter.api.Test;
import step1.domain.Inputs;

import static org.assertj.core.api.Assertions.*;

public class InputsTest {
    @Test
    void createWithDelimiter() {
        assertThat(Inputs.createWithDelimiter("//;\\n1;2;3")).isEqualTo(Inputs.createWithDelimiter("//;\\n1;2;3"));
    }

    @Test
    void createWithoutDelimiter() {
        assertThat(Inputs.createWithoutDelimiter("1:2:3")).isEqualTo(Inputs.createWithoutDelimiter("1:2,3"));
    }
}
