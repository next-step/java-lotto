package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created By mand2 on 2020-11-16.
 */
public class StringAddCalculatorTest {

    @Test
    @DisplayName("입력한 값이 null이면 0을 입력한다.")
    void is_inputString_null() {
        // given
        String inputStr = null;

        // when
        InputValue inputValue = InputValue.of(inputStr);

        // then
        assertThat(inputValue.getInput()).isEqualTo("0");

    }


    @Test
    @DisplayName("입력한 값이 빈 문자열이면 0을 입력한다.")
    void is_inputString_empty() {
        // given
        String inputStr = "";

        // when
        InputValue inputValue = InputValue.of(inputStr);

        // then
        assertThat(inputValue.getInput()).isEqualTo("0");
    }

}
