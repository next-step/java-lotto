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
        CustomSplitterDivider customSplitterDivider = new CustomSplitterDivider(input);

        String customSplitter = customSplitterDivider.extractSplitter();

        assertThat(customSplitter).isEqualTo(";");
    }

    @Test
    void extractInput() {
        CustomSplitterDivider customSplitterDivider = new CustomSplitterDivider(input);

        String expression = customSplitterDivider.extractExpressionString();

        assertThat(expression).isEqualTo("1;2;3");
    }

    @Test
    void isCustomExpression_true() {
        CustomSplitterDivider customSplitterDivider = new CustomSplitterDivider(input);

        boolean isCustomExpression = customSplitterDivider.isCustomExpression();

        assertThat(isCustomExpression).isTrue();
    }

    @Test
    void isCustomExpression_false() {
        String input = "1,2,3";
        CustomSplitterDivider customSplitterDivider = new CustomSplitterDivider(input);

        boolean isCustomExpression = customSplitterDivider.isCustomExpression();

        assertThat(isCustomExpression).isFalse();
    }
}
