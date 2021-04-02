package stringcalculator;

import org.assertj.core.util.Strings;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InputNumbersTest {

    @ParameterizedTest
    @DisplayName("생성자 테스트")
    @NullAndEmptySource
    void create(String input) {
        assertTrue(Strings.isNullOrEmpty(input));
    }

    @ParameterizedTest
    @DisplayName("기본 구분자 확인")
    @ValueSource(strings = {"1,2,3", "1:2:3"})
    void splitDefault(String input) {
        assertThat(new InputNumbers(input).numbers()).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("커스텀 구분자 확인")
    void splitCustom() {
        assertAll(
                () -> assertThat(new InputNumbers("//;\n1;2;3").numbers()).containsExactly("1", "2", "3"),
                () -> assertThat(new InputNumbers("// \n1 2 3").numbers()).containsExactly("1", "2", "3")
        );
    }
}
