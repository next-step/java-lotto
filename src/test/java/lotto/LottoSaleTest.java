package lotto;

import lotto.model.LottoSale;
import lotto.model.RandomLottoStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoSaleTest {
    private static final RandomLottoStrategy RANDOM_LOTTO_GENERATOR_STRATEGY = new RandomLottoStrategy();

    @Test
    @DisplayName("입력한 금액만큼 로또 구입 테스트")
    void inputAmount_purchaseLotto() {
        String purchaseAmount = "10000";

        LottoSale lottoSale = new LottoSale(purchaseAmount, RANDOM_LOTTO_GENERATOR_STRATEGY);

        assertThat(lottoSale.getNumberOfLottos()).isEqualTo(10);
    }

   @Test
   @DisplayName("입력한 금액이 부족하여 로또 구입 실패, 에러 발생 테스트")
    void inputNotEnoughAmount_purchaseFailedLotto() {
       String purchaseAmount = "300";

       assertThatThrownBy(() -> new LottoSale(purchaseAmount, RANDOM_LOTTO_GENERATOR_STRATEGY))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또는 장당 1000원입니다. 입력한 금액으로 구매 불가합니다.");
    }
}
