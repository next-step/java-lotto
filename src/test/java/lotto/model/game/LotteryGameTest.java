package lotto.model.game;

import lotto.model.domain.PurchaseInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LotteryGameTest {

    @ParameterizedTest
    @ValueSource(ints = {100, 500, 600})
    @DisplayName("로또를 하나도 구매 안했을 때 예외 발생 테스트")
    void purchasedLotteryCountTest(int amount) {
        PurchaseInfo purchaseInfo = new PurchaseInfo(amount);
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LotteryGame(purchaseInfo))
                .withMessage("로또를 구매하지 않았습니다.");
    }
}