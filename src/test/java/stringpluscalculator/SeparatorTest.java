package stringpluscalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class SeparatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"#", "a", "b"})
    @DisplayName("separator 생성 테스트")
    void customSeparatorsTest(String input) {
        assertThat(
                new Separator(input)
        ).isEqualTo(new Separator(input));
    }

}
