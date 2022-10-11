package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {

    @DisplayName("로또 금액을 입력 받는다.")
    @ParameterizedTest
    @ValueSource(strings = "14000")
    void receive_money(String input) {
        setIn(input);

        String actual = InputView.receiveMoney();

        assertThat(actual).isEqualTo("14000");
    }

    @DisplayName("지난주 당첨번호를 입력 받는다.")
    @ParameterizedTest
    @ValueSource(strings = "1, 2, 3, 4, 5, 6")
    void receive_last_week_winning_number(String input) {
        setIn(input);
        List<String> expected = List.of("1", "2", "3", "4", "5", "6");

        List<String> actual = InputView.receiveLastWeekWinningNumber();

        assertThat(actual).isEqualTo(expected);
    }

    private void setIn(String input) {
        InputStream in = generateUserInput(input);
        System.setIn(in);
    }

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
