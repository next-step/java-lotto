package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step1.domain.extractor.ExpressionExtractor;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ExpressionExtractTest {

    @Test
    @DisplayName("수식 규칙 체크")
    void extract_validate() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new ExpressionExtractor(split("2 2 + 3 * 4 / 2")))
                .withMessageMatching("수식이 올바르지 않습니다.");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new ExpressionExtractor(split("2 + + 3 * 4 / 2")))
                .withMessageMatching("수식이 올바르지 않습니다.");
    }

    private String[] split(String input) {
        return input.split(" ");
    }

}
