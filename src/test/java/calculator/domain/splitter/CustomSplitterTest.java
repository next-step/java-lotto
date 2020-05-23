package calculator.domain.splitter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("CustomSplitter 클래스 테스트")
public class CustomSplitterTest {
    CustomSplitter customSplitter;

    @BeforeEach
    void setUp() {
        customSplitter = new CustomSplitter();
    }

    @DisplayName("커스텀 구분자로 문자열을 분리할 수 있다.")
    @Test
    void split() {
        String input = "//;\n1;2;3";

        String[] actual = customSplitter.split(input);

        assertAll(
                () -> assertThat(actual).contains("1"),
                () -> assertThat(actual).hasSize(3)
        );
    }
}
