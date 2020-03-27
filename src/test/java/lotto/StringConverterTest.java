package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringConverterTest {
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
}