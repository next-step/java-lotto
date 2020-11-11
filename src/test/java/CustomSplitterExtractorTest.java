import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomSplitterExtractorTest {
    String sentence;

    @BeforeEach
    void setUp() {
        sentence = "//;\n1;2;3";
    }

    @Test
    @DisplayName("Sentence에서 커스텀 구분자 가져오기")
    void getSplitter() {
        CustomSentenceDivider customSentenceDivider = new CustomSentenceDivider(sentence);

        String customSplitter = customSentenceDivider.getSplitter();

        assertThat(customSplitter).isEqualTo(";");
    }

    @Test
    @DisplayName("Sentence에서 문자열 가져오기")
    void getExpressionString() {
        CustomSentenceDivider customSentenceDivider = new CustomSentenceDivider(sentence);

        String expression = customSentenceDivider.getExpressionString();

        assertThat(expression).isEqualTo("1;2;3");
    }

    @Test
    @DisplayName("Sentence가 커스텀 구분자 포함 시, 포함 확인")
    void isCustomExpression_true() {
        CustomSentenceDivider customSentenceDivider = new CustomSentenceDivider(sentence);

        boolean isCustomExpression = customSentenceDivider.isCustomExpression();

        assertThat(isCustomExpression).isTrue();
    }

    @Test
    @DisplayName("Sentence가 커스텀 구분자 미포함 시, 미포함 확안")
    void isCustomExpression_false() {
        String sentence = "1,2,3";
        CustomSentenceDivider customSentenceDivider = new CustomSentenceDivider(sentence);

        boolean isCustomExpression = customSentenceDivider.isCustomExpression();

        assertThat(isCustomExpression).isFalse();
    }
}
