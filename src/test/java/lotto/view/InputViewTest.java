package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputViewTest {

    @ParameterizedTest
    @CsvSource(value = {"1:1", "10:10", "100:100"}, delimiter = ':')
    @DisplayName("숫자를 입력하면 에러가 나지 않는다")
    void validate_money(String input, int expected) {
        InputView inputView = new InputView();
        assertThat(inputView.validateInt(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "]]]"})
    @DisplayName("숫자가 아닌 값을 입력하면 에러가 난다")
    void validate_money_with_not_number(String input) {
        InputView inputView = new InputView();
        assertThrows(IllegalArgumentException.class , () -> inputView.validateInt(input));
    }

}
