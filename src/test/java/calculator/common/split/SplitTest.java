package calculator.common.split;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SplitTest {

    @Test
    @DisplayName("\"1 2\"을 ,로 split 했을 때 1과 2 를 분리한다")
    void splitTestStep1() {
        final String[] result = "1 2".split(" ");
        assertThat(result).contains("1", "2");
        assertThat(result).containsExactly("1", "2");
    }
}
