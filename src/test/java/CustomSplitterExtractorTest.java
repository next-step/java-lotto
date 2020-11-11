import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomSplitterExtractorTest {
    String input;

    @BeforeEach
    void setUp() {
        input = "//;\n1;2;3";
    }

    @Test
    void extractSplitter() {
        String customSplitter = CustomSplitterDivider.extractSplitter(input);

        assertThat(customSplitter).isEqualTo(";");
    }

}
