package splitter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

public class CommaSplitterTest {

    private CommaSplitter commaSplitter;

    @BeforeEach
    void setUp() {
        commaSplitter = new CommaSplitter();
    }

    @DisplayName("빈 문자열을 입력하면 빈 String 배열을 반환")
    @ParameterizedTest
    @EmptySource
    void failureSplitByEmpty(final String value) {
        assertThat(commaSplitter.split(value))
                .isEqualTo(new String[0]);
    }

    @DisplayName("null 을 입력하면 NullPointerException 예외 발생")
    @ParameterizedTest
    @NullSource
    void failureSplitByNull(final String value) {
        assertThatNullPointerException().isThrownBy(() -> commaSplitter.split(value));
    }
}
