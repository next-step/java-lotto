package stringcalculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DelimiterTest {

    @DisplayName("정적 스태틱 메서드 생성 잘 되는지")
    @Test
    void delimiter_생성_확인() {
        List<Delimiter> delimiters = Delimiter.of(Arrays.asList("!", " "));

        assertThat(delimiters.get(0).getDelimiter()).isEqualTo("!");
        assertThat(delimiters.get(1).getDelimiter()).isEqualTo(" ");
    }

    @DisplayName("구분자의 시작과 끝은 숫자이면 안된다.")
    @ValueSource(strings = {"3a3", "123", "22a", "aa3"})
    @ParameterizedTest
    void delimiter_구분자의_시작과_끝은_숫자(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Delimiter.of(Arrays.asList(input)));
    }
}
