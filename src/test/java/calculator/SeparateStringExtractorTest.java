package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SeparateStringExtractorTest {

    @Test
    void extraction() {

        String separator = SeparateStringExtractor.execute("//;\n");

        assertThat(separator).isEqualTo(";");
    }
}
