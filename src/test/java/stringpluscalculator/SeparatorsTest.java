package stringpluscalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class SeparatorsTest {

    @ParameterizedTest
    @ValueSource(strings = {"u", "#", "J"})
    @DisplayName("separator 생성 테스트")
    void customSeparatorsTest(String input) {
        assertThat(new Separators(input)).isEqualTo(new Separators(input));
    }

    @Test
    @DisplayName("split용 separator 가져오기 테스트")
    void getSplitSeparatorTest() {
        assertAll(
                () -> assertThat(new Separators().getSplitSeparator()).isEqualTo(":|,"),
                () -> assertThat(new Separators("J").getSplitSeparator()).isEqualTo("J")
        );
    }

}
