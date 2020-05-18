package splitter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CustomSplitterTest {

    private CustomSplitter customSplitter;

    @BeforeEach
    void setUp() {
        customSplitter = new CustomSplitter();
    }

    @DisplayName("빈 문자열을 입력하면 빈 String 배열을 반환")
    @ParameterizedTest
    @EmptySource
    void failureSplitByEmpty(final String value) {
        assertThat(customSplitter.split(value))
                .isEqualTo(new String[0]);
    }

    @DisplayName("null 을 입력하면 NullPointerException 예외 발생")
    @ParameterizedTest
    @NullSource
    void failureSplitByNull(final String value) {
        assertThatNullPointerException().isThrownBy(() -> customSplitter.split(value));
    }

    @DisplayName("매칭되지 않는 정규 표현식 문자열이 들어오면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = { "3,4", "//1", "\n1" })
    void failureSplit(final String value) {
        assertThatThrownBy(() -> customSplitter.split(value))
                .isInstanceOf(RuntimeException.class);
    }
}
