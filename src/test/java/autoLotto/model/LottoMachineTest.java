package autoLotto.model;

import autoLotto.exception.PurchaseException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMachineTest {
    private static final String INVALID_PURCHASE_AMOUNT = "로또 1장은 1,000원이며, 지불하신 금액으로는 로또 구매가 불가능합니다.";
    private static final RandomLottoGeneratorStrategy RANDOM_LOTTO_GENERATOR_STRATEGY = new RandomLottoGeneratorStrategy();

    @Test
    @DisplayName("LottoMachine 객체 생성 : 성공")
    void testLottoMachine_ShouldReturnCorrectSize() {
        // given
        String purchaseAmount = "5000";

        // when
        LottoMachine lottoMachine = new LottoMachine(purchaseAmount, RANDOM_LOTTO_GENERATOR_STRATEGY);

        // then
        assertThat(lottoMachine.getNumberOfLottos()).isEqualTo(5);
    }

    @Test
    @DisplayName("LottoMachine 객체 생성 : 부족한 금액이 들어와 로또 구매 실패 및 예외 발생")
    void testLottoMachine_InvalidPurchaseAmount_ShouldThrowException() {
        // given
        String purchaseAmount = "500";

        // when, then
        assertThatThrownBy(() -> new LottoMachine(purchaseAmount, RANDOM_LOTTO_GENERATOR_STRATEGY))
                .isInstanceOf(PurchaseException.class)
                .hasMessageContaining(INVALID_PURCHASE_AMOUNT);
    }
}
