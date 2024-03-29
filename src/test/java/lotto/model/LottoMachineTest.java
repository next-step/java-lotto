package lotto.model;

import lotto.exception.PurchaseException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static lotto.model.PurchaseAmount.INVALID_PURCHASE_AMOUNT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMachineTest {
    private static final String VALID_MANUAL_LOTTO_FIRST = "1,2,3,4,5,6";
    private static final String VALID_MANUAL_LOTTO_SECOND = "11,12,13,14,15,16";

    @Test
    @DisplayName("LottoMachine 객체 생성 : 성공")
    void testLottoMachine_ShouldReturnCorrectSize() {
        // given
        PurchaseAmount purchaseAmount = new PurchaseAmount(4000);

        // when
        LottoMachine lottoMachine = new LottoMachine(getManualLottos(), purchaseAmount);

        // then
        assertThat(lottoMachine.getNumberOfLottos()).isEqualTo(4);
    }

    @Test
    @DisplayName("LottoMachine 객체 생성 살패 : 자동 로또의 합과 수동 로또의 합이 총 구매 개수와 동일하지 않음")
    void testLottoMachine_InvalidPurchaseAmount_ShouldThrowException() {
        // given
        PurchaseAmount purchaseAmount = new PurchaseAmount(1000);

        // when, then
        assertThatThrownBy(() -> new LottoMachine(getManualLottos(), purchaseAmount))
                .isInstanceOf(PurchaseException.class)
                .hasMessageContaining(INVALID_PURCHASE_AMOUNT);
    }

    @ParameterizedTest(name = "LottoMachine 객체 생성 실패 : 유효하지 않은 값, 또는 범위의 수동 로또가 포함됨")
    @ValueSource(strings = {"1,1,2,3,4,5", "111,2,3,4,5,6", "1,2,3,4,5"})
    void testLottoMachine_InvalidManualLottoNumber_ShouldThrowException(String input) {
        // given
        PurchaseAmount purchaseAmount = new PurchaseAmount(1000);

        // when, then
        assertThatThrownBy(() -> new LottoMachine(List.of(input), purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private List<String> getManualLottos() {
        return List.of(VALID_MANUAL_LOTTO_FIRST, VALID_MANUAL_LOTTO_SECOND);
    }
}
