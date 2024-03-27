package lotto.domain;

import lotto.exception.InvalidNumberOfManualLottoToPurchase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberOfManualLottoToPurchaseTest {
    @ParameterizedTest
    @CsvSource(value = {"-1:10", "11:10"}, delimiter = ':')
    @DisplayName("NumberOfManualLottoToPurchase 인스턴스 생성시 numberOfManualLottoToPurchase가 0보다 작거나 maximumNumberOfManualLottoToPurchase보다 큰 경우 InvalidNumberOfManualLottoToPurchase 발생한다.")
    void testInstanceCreationFailCase(int numberOfManualLottoToPurchase, int maximumNumberOfManualLottoToPurchase) {
        assertThatThrownBy(() -> NumberOfManualLottoToPurchase.newNumberOfManualLottoToPurchase(numberOfManualLottoToPurchase, maximumNumberOfManualLottoToPurchase))
                .isExactlyInstanceOf(InvalidNumberOfManualLottoToPurchase.class);
    }
}
