package study.step1;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import study.step1.validator.InputValidator;

public class InputValidatorTest {

    @Test
    @DisplayName("Null 테스트")
    public void nullTest() {
        assertThat(InputValidator.isEmpty(null)).isEqualTo(true);
    }

    @Test
    @DisplayName("Blank 테스트")
    public void blankTest(){
        assertThat(InputValidator.isBlank(" ")).isEqualTo(true);
        assertThat(InputValidator.isBlank("")).isEqualTo(true);
        assertThat(InputValidator.isBlank("test")).isEqualTo(false);
    }

}
