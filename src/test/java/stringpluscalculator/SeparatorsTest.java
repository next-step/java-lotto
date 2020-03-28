package stringpluscalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class SeparatorsTest {

    @Test
    @DisplayName("split용 separator 가져오기 테스트")
    void getSplitSeparatorTest() {
        assertAll(
                () -> assertThat(new Separators("//d\\n1234567").getSplitSeparator()).isEqualTo("d"),
                () -> assertThat(new Separators("//*\\n1234567").getSplitSeparator()).isEqualTo("*"),
                () -> assertThat(new Separators("1234567").getSplitSeparator()).isEqualTo(":|,"),
                () -> assertThat(new Separators("///\\n1234567").getSplitSeparator()).isEqualTo("/")
        );
    }

    @Test
    @DisplayName("input에서 custom separator 부분 뺴고 가져오기 테스트")
    void getInputWithoutCustomSeparatorTest() {
        assertAll(
                () -> assertThat(Separators.getInputWithoutCustomSeparator("//d\\n1234567")).isEqualTo("1234567"),
                () -> assertThat(Separators.getInputWithoutCustomSeparator("//*\\n1234567")).isEqualTo("1234567"),
                () -> assertThat(Separators.getInputWithoutCustomSeparator("//ㅋ\\n8ㅋ7ㅋ6ㅋ7ㅋ8")).isEqualTo("8ㅋ7ㅋ6ㅋ7ㅋ8"),
                () -> assertThat(Separators.getInputWithoutCustomSeparator("8ㅋ7ㅋ6ㅋ7ㅋ8")).isEqualTo("8ㅋ7ㅋ6ㅋ7ㅋ8"),
                () -> assertThat(Separators.getInputWithoutCustomSeparator("1234567")).isEqualTo("1234567")
        );
    }
}
