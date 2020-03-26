package stringpluscalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SeparatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "7", "5"})
    @DisplayName("구분자에 숫자가 들어가면 IllegalArgumentException 발생 테스트")
    void validateSeparatorTest(String input) {
        assertThatThrownBy(() -> new Separator(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {":", "y", "#"})
    @DisplayName("구분자를 만들고 구분자 가져오기 테스트")
    void getSeparatorTest(String input) {
        assertThat(new Separator(input).getSeparator()).isEqualTo(input);
    }
}
