package autoLotto.model;

import autoLotto.exception.PurchaseException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMachineTest {
    private static final String VALID_MANUAL_LOTTO_FIRST = "1,2,3,4,5,6";
    private static final String VALID_MANUAL_LOTTO_SECOND = "11,12,13,14,15,16";
    private static final String INVALID_PURCHASE_AMOUNT = "구입하신 수동 로또의 개수가 전체 로또 개수보다 많습니다.\n관리자에게 문의하여 로또를 재구매하시기 바랍니다.";
    private static final String INVALID_LOTTO_NUMBERS = "쉼표를 기준으로 1 ~ 45 사이의 숫자 6개의 숫자를 중복없이 입력하셔야 합니다.\n(ex: 1,2,3,4,5,6)";

    @Test
    @DisplayName("LottoMachine 객체 생성 : 성공")
    void testLottoMachine_ShouldReturnCorrectSize() {
        // given
        LottoPurchaseCount lottoPurchaseCount = new LottoPurchaseCount(4000, 2);

        // when
        LottoMachine lottoMachine = new LottoMachine(getManualLottos(), lottoPurchaseCount);

        // then
        assertThat(lottoMachine.getNumberOfLottos()).isEqualTo(4);
    }

    @Test
    @DisplayName("LottoMachine 객체 생성 살패 : 자동 로또의 합과 수동 로또의 합이 총 구매 개수와 동일하지 않음")
    void testLottoMachine_InvalidPurchaseAmount_ShouldThrowException() {
        // given
        LottoPurchaseCount lottoPurchaseCount = new LottoPurchaseCount(1000, 1);

        // when, then
        assertThatThrownBy(() -> new LottoMachine(getManualLottos(), lottoPurchaseCount))
                .isInstanceOf(PurchaseException.class)
                .hasMessageContaining(INVALID_PURCHASE_AMOUNT);
    }

    @ParameterizedTest(name = "LottoMachine 객체 생성 실패 : 유효하지 않은 값, 또는 범위의 수동 로또가 포함됨")
    @ValueSource(strings = {"1,1,2,3,4,5", "1,2,3,4,5"})
    void testLottoMachine_InvalidManualLottoNumber_ShouldThrowException(String input) {
        // given
        LottoPurchaseCount lottoPurchaseCount = new LottoPurchaseCount(1000, 1);

        // when, then
        assertThatThrownBy(() -> new LottoMachine(List.of(input), lottoPurchaseCount))
                .isInstanceOf(PurchaseException.class)
                .hasMessageContaining(INVALID_LOTTO_NUMBERS);
    }

    private List<String> getManualLottos() {
        return List.of(VALID_MANUAL_LOTTO_FIRST, VALID_MANUAL_LOTTO_SECOND);
    }
}
