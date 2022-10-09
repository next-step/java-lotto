package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserInputTest {

    @ParameterizedTest
    @DisplayName("입력 금액 검증")
    @CsvSource(
            delimiter = ':',
            value = {"5000:5", "8000:8", "10500:10"}
    )
    void validPrice(int price, int count) {
        UserInput userInput = new UserInput(price);
        assertThat(userInput.price()).isEqualTo(price);
        assertThat(userInput.count()).isEqualTo(count);
    }

    @ParameterizedTest
    @DisplayName("입력 예외 금액 검증")
    @ValueSource(ints = {500, 101000})
    void invalidPrice(int price) {
        assertThatThrownBy(() -> new UserInput(price))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
