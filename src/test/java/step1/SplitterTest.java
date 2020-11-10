package step1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SplitterTest {

    @Test
    void splitInput() {
        Assertions.assertAll(
                () -> {
                    String[] expected = new String[] { "1", "2", "3" };
                    assertThat(Splitter.splitInput("1,2,3"))
                            .isEqualTo(expected);
                },
                () -> {
                    String[] expected = new String[] { "1", "2", "3" };
                    assertThat(Splitter.splitInput("//;\n1;2;3"))
                            .isEqualTo(expected);
                }
        );
    }
}
