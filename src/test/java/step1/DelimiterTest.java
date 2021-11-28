package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step1.domain.Delimiter;

import static org.assertj.core.api.Assertions.*;

public class DelimiterTest {
    @Test
    @DisplayName("생성자 test")
    void create() {
        Delimiter delimiter = new Delimiter(";");
        assertThat(delimiter.equals(new Delimiter(";"))).isTrue();
    }

    @Test
    @DisplayName("get method test")
    void getDelimiter() {
        Delimiter delimiter = new Delimiter(";");
        assertThat(delimiter.getDelimiter()).isEqualTo(";");
        assertThat(delimiter.getDelimiter()).isNotEqualTo(":");
    }
}
