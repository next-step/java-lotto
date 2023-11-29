package step2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.lotto.domain.LottoPurchaseMoney;

class LottoPurchaseMoneyTest {

    @Test
    @DisplayName("로또의 최소 구입금액보다 낮은 금액을 입력한 경우 예외를 반환한다.")
    void lottoPurchaseInputMoneyValidateTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoPurchaseMoney(999));
    }

}
