package lotto.utils;

import lotto.domain.value.Price;
import lotto.exception.EmptySourceException;
import lotto.exception.InvalidValueException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputUtilsTest {

    @DisplayName("금액 생성에 공백이 입력될 시 예외가 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void validateNullAndEmptySourceOnCreatePrice(String input) {
        assertThatThrownBy(() -> InputUtils.createPrice(input)).isInstanceOf(EmptySourceException.class);
    }

    @DisplayName("금액 생성에 금액이아닌 문자열을 입력했을 경우 예외가 발생한다.")
    @Test
    void validateStringOnCreatePrice() {
        String input = "문자열 입력";

        assertThatThrownBy(() -> InputUtils.createPrice(input)).isInstanceOf(InvalidValueException.class);
    }

    @DisplayName("금액을 입력할 경우 Price를 생성한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "14000", "23000", "42000"
    })
    void createLottoCount(String input) {
        Price price = InputUtils.createPrice(input);

        assertThat(price).isEqualTo(Price.of(input));
    }

    @DisplayName("당첨번호 생성에 공백이 입력될 시 예외가 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void validateNullAndEmptySourceOnCreateWinningFrom(String input) {
        assertThatThrownBy(() -> InputUtils.createWinningNumbers(input)).isInstanceOf(EmptySourceException.class);
    }

    @DisplayName("당첨번호 생성에 문자가 입력될 시 예외가 발생한다.")
    @Test
    void validateNullAndEmptySourceOnCreateWinningFrom() {
        String input = "1, 문자, 3, 4, 5, 6";

        assertThatThrownBy(() -> InputUtils.createWinningNumbers(input)).isInstanceOf(InvalidValueException.class);
    }

}
