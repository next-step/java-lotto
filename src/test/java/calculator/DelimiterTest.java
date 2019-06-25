package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DelimiterTest {
    @Test
    @DisplayName("원하는 String 으로 calculator.Delimiter 가 생성된다.")
    void constructor() {
        Delimiter delimiter = new Delimiter(",");
        assertThat(delimiter.getDelimiter()).isEqualTo(",");
    }
}
