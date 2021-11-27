package step1;

import org.junit.jupiter.api.Test;
import step1.domain.Delimiter;

import static org.assertj.core.api.Assertions.*;

public class DelimiterTest {

    @Test
    void create() {
        Delimiter delimiter = new Delimiter("//;\\n1;2;3");
        assertThat(delimiter.equals(new Delimiter(";"))).isTrue();
    }

    @Test
    void validateDelimiter() {
        assertThatThrownBy(() -> new Delimiter("//;\\n1,2;3"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("구분자 입력 오류");
    }
}
