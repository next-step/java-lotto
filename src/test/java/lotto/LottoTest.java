package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class LottoTest {

    @Test
    @DisplayName("구입 금액으로 로또 개수를 계산한다")
    void calculatePurchaseQuantityTest() {
        //given
        int purchaseAmount = 14000;
        Lotto lotto = new Lotto();

        //when`
        int purchaseQuantity = lotto.calculatePurchaseQuantity(purchaseAmount);

        //then
        assertThat(purchaseQuantity).isEqualTo(14);
    }

    @ParameterizedTest
    @DisplayName("구입 금액이 1000원 보다 적은 경우 에러를 던진다")
    @ValueSource(ints = {-1, 0, 999})
    void calculatePurchaseQuantityWithInvalidAmount(int purchaseAmount) {
        //given
        Lotto lotto = new Lotto();

        //when
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lotto.calculatePurchaseQuantity(purchaseAmount))
                .withMessageContaining("로또를 구매하기 적절한 금액이 아닙니다");

    }
}