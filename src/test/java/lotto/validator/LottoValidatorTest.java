package lotto.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoValidatorTest {


    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 999, 1001, 2022})
    @DisplayName("최소 1,000 단위로 입려하지 않았을 시, 예외 발생")
    void checkMinimumPurchasePrice(Integer purchasePrice) {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoValidator.checkMinimumPurchasePrice(purchasePrice));
    }

    @ParameterizedTest
    @ValueSource(ints = {101000, 200000})
    @DisplayName("최대 100,000 만원이 넘어가면 예외 발생")
    void checkMaximumPurchasePrice(Integer purchasePrice) {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoValidator.checkMaximumPurchasePrice(purchasePrice));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 7, 8})
    @DisplayName("로또 번호가 6개 아닌 경우 예외 발생")
    void checkLottoNumberCount(Integer lottoCount) {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoValidator.checkLottoNumberCount(lottoCount));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46, 60})
    @DisplayName("번호 입력 시, 제한 범위를 벗어나는 경우 예외 발생 (1-45)")
    void checkWinningNumber(Integer manualNumber) {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoValidator.checkManualNumber(manualNumber));
    }
}
