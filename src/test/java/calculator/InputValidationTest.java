package calculator;

import calculator.validation.InputValidation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InputValidationTest {

    private InputValidation inputValidation;

    @BeforeEach
    public void setUp() {
        inputValidation = new InputValidation();
    }

    @DisplayName("입력값 검증 테스트")
    @Test
    public void inputValidation() {
        //given
        List<String> input = List.of("2", "+", "3", "*", "4", "/", "2");
        //when
        boolean result = inputValidation.validation(input);
        //then
        assertThat(result).isTrue();
    }


}
