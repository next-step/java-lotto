package calculator.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringUtilTest {
    private static final StringUtil stringUtil = new StringUtil();

    @Test
    public void isNullTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            stringUtil.isNullOrEmpty(null);
        });
    }

    @ParameterizedTest
    @DisplayName("isEmptyTest")
    @ValueSource(strings = {""})
    public void isEmptyTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            stringUtil.isNullOrEmpty(input);
        });
    }

    @Test
    @DisplayName("RigthInputTest")
    public void rightInputTest() {
        assertThat(stringUtil.isNullOrEmpty(" ")).isFalse();
    }


    @ParameterizedTest
    @DisplayName("isRigthStringTest")
    @ValueSource(strings = {"1 2 3 + - / *"})
    public void isRigthStringTest(String string) {
        assertTrue(stringUtil.isRightString(string));
    }

    @ParameterizedTest
    @DisplayName("isWrongStringTest")
    @ValueSource(strings = {"a b", "& % ^"})
    public void isWrongStringTest(String string) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            stringUtil.isRightString(string);
        });
    }

    @Test
    public void splitStringTest() {
        String s = "1 + 2 - 3";
        List<String> expectedList = List.of("1", "+", "2", "-", "3");
        assertThat(stringUtil.splitString(s)).isEqualTo(expectedList);
    }
}
