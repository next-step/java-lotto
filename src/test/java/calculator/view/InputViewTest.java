package calculator.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {

    @DisplayName("white space로 문자열을 분리한다.")
    @ParameterizedTest
    @ValueSource(strings = {"6 + 5 - 4 * 3 / 2"})
    void receiveFormula(String input) {
        InputView inputView = setIn(input);
        List<String> expected = Arrays.asList("6", "+", "5", "-", "4", "*", "3", "/", "2");

        List<String> actual = inputView.receiveFormula();

        assertThat(actual).isEqualTo(expected);
    }

    private InputView setIn(String input) {
        InputStream in = generateUserInput(input);
        System.setIn(in);
        return new InputView();
    }

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
