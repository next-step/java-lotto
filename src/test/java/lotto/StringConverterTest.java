package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringConverterTest {
    @DisplayName("입력받은 문자열을 인자로 주면, PositiveNumber 타입으로 변환된 객체를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"13000:13000", "1000:1000", "1500:1500"}, delimiter = ':')
    void convertStringToPositiveNumberTest(String input, int expected) {
        //when
        PositiveNumber positiveNumber = StringConverter.convertStringToPositiveNumber(input);

        //then
        assertThat(positiveNumber).isEqualTo(new PositiveNumber(expected));
    }

    @DisplayName("입력받은 값이 숫자가 아니면 IllegalArgumentException 을 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"숫자가아닌데?", "Money", "!!!!"})
    void validateNonNumberTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringConverter.convertStringToPositiveNumber(input);
        });
    }
}
