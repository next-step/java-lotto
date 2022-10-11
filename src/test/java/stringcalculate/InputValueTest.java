package stringcalculate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import stringcalculate.InputValue;
import stringcalculate.WrongInputException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class InputValueTest {

    @Test
    @DisplayName("입력 받은 식을 쪼개어 list로 반환한다.")
    void InputSplitter() {
        String input = "1 - 1 + 1 * 1 / 1";
        List<String> test = Arrays.stream(input.split(" ")).collect(Collectors.toList());
        InputValue inputValue = new InputValue(input);

        assertAll(
                () -> assertEquals(test.size(), inputValue.getSize()),
                () -> assertEquals(test, inputValue.getExpression())
        );
    }
}
