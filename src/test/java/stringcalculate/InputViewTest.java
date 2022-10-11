package stringcalculate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import stringcalculate.view.InputView;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class InputViewTest {
    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 + 1 * 2 - 5"})
    @DisplayName("사칙연산과 숫자 외에 문자가 들어오면 예외를 던진다.")
    void if_input_return_InputValue(String input) {
        String input1 = "1 + 1 * 2 - 5";
        InputStream in = generateUserInput(input1);
        System.setIn(in);
        InputView inputView = new InputView();
        InputValue inputValue = inputView.askInput(new Scanner(System.in));
        assertAll(() -> assertThat(inputValue).isExactlyInstanceOf(InputValue.class),
                () -> assertThat(inputValue.getSize()).isEqualTo(7));
    }
}
