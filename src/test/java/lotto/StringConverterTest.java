package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringConverterTest {
    @ParameterizedTest
    @CsvSource(value = {"13000:13000", "1000:1000", "1500:1500"}, delimiter = ':')
    void convertStringToPositiveNumber(String input, int expected) {
        //when
        PositiveNumber positiveNumber = StringConverter.convertStringToPositiveNumber(input);

        //then
        assertThat(positiveNumber).isEqualTo(new PositiveNumber(expected));
    }
}
