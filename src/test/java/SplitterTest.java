import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SplitterTest {

    private final Splitter splitter = new Splitter();

    @ParameterizedTest
    @NullAndEmptySource
    void 입력_값이_null이거나_빈_공백_문자일_경우_IllegalArgumentException(String value) {
        // when then
        assertThatThrownBy(() -> splitter.splitOperationNumbers(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
