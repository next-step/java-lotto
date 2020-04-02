package lotto.view;

import lotto.model.Money;
import lotto.view.input.StringConverter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringConverterTest {
    @ParameterizedTest
    @NullAndEmptySource
    void validateNullOrEmptyTest(String input) {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> {
            StringConverter.convertStringToMoney(input);
        });
    }

    @DisplayName("문자열 입력값을 인자로 주면, long으로 변환된 멤버변수를 통해 생성된 Money객체를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1000:1000", "5000:5000", "1000000:1000000"}, delimiter = ':')
    void convertStringToMoneyTest(String input, long expected) {
        assertThat(StringConverter.convertStringToMoney(input))
                .isEqualTo(new Money(expected));
    }

    @DisplayName("숫자가 아닌 값이 입력되면, 예외를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"@", "Money", "!!!!!"})
    void validateNonNumberTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringConverter.convertStringToMoney(input);
        });
    }

    @DisplayName("1000원 미만의 금액을 입력받으면 예외를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "500", "999"})
    void validateEnoughToBuyLottoTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringConverter.convertStringToMoney(input);
        });
    }

    @DisplayName("숫자가 아닌 값이 입력되면, 예외를 반환한다 (2)")
    @ParameterizedTest
    @ValueSource(strings = {"@", "Money", "!!!!!"})
    void validateNonNumberTestForNumbers(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringConverter.convertStringToMoney(input);
        });
    }
}