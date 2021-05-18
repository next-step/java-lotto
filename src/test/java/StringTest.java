import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void split() {
        assertThat("1,2".split(",")).containsExactly("1","2");
        assertThat("1".split(",")).containsExactly("1");
        }
    }
