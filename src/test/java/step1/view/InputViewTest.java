package step1.view;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class InputViewTest {

    @ParameterizedTest
    @CsvSource(value = {"'2 + 3 * 4 / 5',7", "'5 * 4 / 2 - 10 + 4',9",})
    void 입력한_수식_공백_기준_split_테스트(String input, int expected) {
        InputView inputView = new InputView();
        assertThat(inputView.getExpression(input)).hasSize(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"' '", "NULL"}, nullValues = "NULL")
    void 입력한_수식_공백_기준_split_테스트_오류(String input) {
        InputView inputView = new InputView();
        assertThatIllegalArgumentException().isThrownBy(() -> inputView.getExpression(input));
    }
}
