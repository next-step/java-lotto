package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationUtilsTest {

    @ParameterizedTest
    @CsvSource(value = {"1000,true", "10000,true", "1100,true", "500,false", "0,false"})
    @DisplayName("금액의 최소값은 1000원 이상이다")
    void validatePriceTest(int price, boolean expected) {
        boolean result = ValidationUtils.isValidPrice(price);
        assertThat(result).isEqualTo(expected);
    }

}
