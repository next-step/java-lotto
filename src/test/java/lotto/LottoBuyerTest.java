package lotto;

import lotto.domain.LottosBuyer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoBuyerTest {
    @Test
    @DisplayName("구매금액보다 많은 양의 수동 로또 구매 시에 exception 테스트")
    void checkPurchaseValidation() {
        assertThatThrownBy(
                () -> {
                    new LottosBuyer(14000, 15);
                }
        ).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("전체 로또 수 보다, 수동 로또를 많이 구매할 수 없습니다.");
    }
}
