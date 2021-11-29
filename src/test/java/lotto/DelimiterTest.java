package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class DelimiterTest {
    @ParameterizedTest(name = "{displayName} - {arguments}")
    @NullAndEmptySource
    void whenDelimiterValueIsNullOrEmpty(String value) {
        assertThatThrownBy(() -> new Delimiter(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenDelimiterValueIsBlank() {
        assertThatThrownBy(() -> new Delimiter(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void create() {
        assertThat(new Delimiter("+")).isEqualTo(new Delimiter("+"));
    }
}
