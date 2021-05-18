import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void split() {
        assertThat("1,2".split(",")).containsExactly("1","2");
        assertThat("1".split(",")).containsExactly("1");
    }

    @Test
    void substring() {
        String data = "(1,2)";
        assertThat(data.substring(1, data.length()-1)).isEqualTo("1,2");
    }

    
}
