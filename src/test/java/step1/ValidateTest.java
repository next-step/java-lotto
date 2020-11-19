package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ValidateTest {
    @Test
    @DisplayName("유효성 검사 테스트")
    void validateTest(){
        String inputValue = "";
        assertThat(Validator.inputValueTest(inputValue)).isEqualTo("0");

        inputValue = "1,2,12,3";
        assertThat(Validator.inputValueTest(inputValue)).isEqualTo(inputValue);
    }
}
