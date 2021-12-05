package lotto;

import lotto.domain.LottosBuyer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
@Nested
@DisplayName("LottoBuyer 클래스는")
public class LottoBuyerTest {
    @Nested
    @DisplayName("checkPurchaseValidation 메소드는 매금액보다 많은 양의 수동 로또 구매 시에")
    class CheckPurchaseValidation{
        @Test
        @DisplayName("전체 로또 수 보다, 수동 로또를 많이 구매할 수 없습니다. 를 반환")
        void checkPurchaseValidation() {
            assertThatThrownBy(
                    () -> {
                        new LottosBuyer(14000, 15);
                    }
            ).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("전체 로또 수 보다, 수동 로또를 많이 구매할 수 없습니다.");
        }
    }
}
