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

    @ParameterizedTest
    @CsvSource(value = {"1,true", "45,true", "0,false", "46,false"})
    @DisplayName("로또 번호는 1 ~ 45 사이의 수이다")
    void validateLottoNumberBoundaryTest(int number, boolean expected) {
        boolean result = ValidationUtils.isValidLottoNumberBoundary(number);
        assertThat(result).isEqualTo(expected);
    }
}
