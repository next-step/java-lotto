package lotto.dto;

import lotto.exception.IllegalManuallyPurchasingLottoCountExcepion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static java.lang.Integer.parseInt;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DisplayName("ManuallyPurchasingLottoCount 테스트")
class ManuallyPurchasingLottoCountTest {

    @ValueSource(strings = {"1", "2", "3", "4", "5"})
    @ParameterizedTest
    void new_정상(String value) {
        // Given
        int expectedResult = parseInt(value);

        // When
        ManuallyPurchasingLottoCount manuallyPurchasingLottoCount = new ManuallyPurchasingLottoCount(value);

        // Then
        assertThat(expectedResult).isEqualTo(manuallyPurchasingLottoCount.getValue());
    }

    @ValueSource(strings = {"-11", "-2", "q", "w", "#"})
    @ParameterizedTest
    void new_예외(String value) {
        // When, Then
        assertThatExceptionOfType(IllegalManuallyPurchasingLottoCountExcepion.class)
                .isThrownBy(()->new ManuallyPurchasingLottoCount(value));
    }

}