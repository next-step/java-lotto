package calculator.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringSplitterTest {

    @Test
    @DisplayName("문자열 공백 분리 테스트")
    void inputSplitSpaceTest() {
        // Given
        String input = "2 + 3 * 4 / 2";
        int expectedSize = 7;

        // When
        String[] actual = StringSplitter.splitWithSpace(input);

        // Then
        assertThat(actual).hasSize(expectedSize);
    }

}
