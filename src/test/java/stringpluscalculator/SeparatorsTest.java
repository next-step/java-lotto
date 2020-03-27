package stringpluscalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class SeparatorsTest {

    @ParameterizedTest
    @ValueSource(strings = {"1234567", "//*\n1234567", "1234567"})
    @DisplayName("separator 생성 테스트")
    void customSeparatorsTest(String input) {
        assertThat(new Separators(input)).isEqualTo(new Separators(input));
    }

    @Test
    @DisplayName("split용 separator 가져오기 테스트")
    void getSplitSeparatorTest() {
        assertAll(
                () -> assertThat(new Separators("//d\n1234567").getSplitSeparator()).isEqualTo("d"),
                () -> assertThat(new Separators("//*\n1234567").getSplitSeparator()).isEqualTo("*"),
                () -> assertThat(new Separators("1234567").getSplitSeparator()).isEqualTo(":|,"),
                () -> assertThat(new Separators("///\n1234567").getSplitSeparator()).isEqualTo("/")
        );
    }

    @Test
    @DisplayName("input에서 custom separator 부분 뺴고 가져오기 테스트")
    void getInputWithoutCustomSeparatorTest() {
        assertAll(
                () -> assertThat(Separators.getInputWithoutCustomSeparator("//d\n1234567")).isEqualTo("1234567"),
                () -> assertThat(Separators.getInputWithoutCustomSeparator("//*\n1234567")).isEqualTo("1234567"),
                () -> assertThat(Separators.getInputWithoutCustomSeparator("//ㅋ\n8ㅋ7ㅋ6ㅋ7ㅋ8")).isEqualTo("8ㅋ7ㅋ6ㅋ7ㅋ8"),
                () -> assertThat(Separators.getInputWithoutCustomSeparator("8ㅋ7ㅋ6ㅋ7ㅋ8")).isEqualTo("8ㅋ7ㅋ6ㅋ7ㅋ8"),
                () -> assertThat(Separators.getInputWithoutCustomSeparator("1234567")).isEqualTo("1234567")
        );
    }
}
