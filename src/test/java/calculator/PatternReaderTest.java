package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PatternReaderTest {

    @DisplayName("패턴을 판독하여 `숫자들(Numbers)`을 반환한다.")
    @Test
    void read() {
        // given
        PatternReader patternReader = pattern -> Numbers.of(1, 2, 3);
        String pattern = "";

        // when
        Numbers read = patternReader.read(pattern);

        // then
        assertThat(read).isNotNull();
    }
}
