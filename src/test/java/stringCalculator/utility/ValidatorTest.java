package stringCalculator.utility;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
    Validator validator = new Validator();

    @Test
    @DisplayName("입력이 empty 일 경우")
    void testEmptyString() {
        //given
        //when
        String input = "";
        //then
        assertThat(validator.isValidInput(input)).isFalse();
    }

    @Test
    @DisplayName("입력이 null 일 경우")
    void testNull() {
        //given
        //when
        //then
        assertThat(validator.isValidInput(null)).isFalse();
    }

    @Test
    @DisplayName("입력이 올바른 경우")
    void testValidInput() {
        //given
        //when
        String input = "1,2,3";
        //then
        assertThat(validator.isValidInput(input)).isTrue();
    }
}
