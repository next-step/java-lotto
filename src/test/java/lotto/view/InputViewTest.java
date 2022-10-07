package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {

    @DisplayName("로또 금액을 입력 받는다.")
    @ParameterizedTest
    @ValueSource(strings = "14000")
    void receiveFormula(String input) {
        setIn(input);

        String actual = InputView.receiveMoney();

        assertThat(actual).isEqualTo("14000");
    }

    private void setIn(String input) {
        InputStream in = generateUserInput(input);
        System.setIn(in);
    }

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
