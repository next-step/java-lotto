import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringBuilderTest {

    @Test
    void emptyToString() {
        assertThat(new StringBuilder().toString()).isEqualTo("");
    }
}
