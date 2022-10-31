package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PaidAmountTest {

    @Test
    @DisplayName("구매 금액 생성")
    void create() {
        PaidAmount paidAmount = new PaidAmount(3000);
        assertThat(paidAmount).isEqualTo(new PaidAmount(3000));
    }

    @Test
    @DisplayName("구매 가능한 로또 개수 반환")
    void purchasable() {
        PaidAmount paidAmount = new PaidAmount(4700);
        assertThat(paidAmount.getPurchasableTicketNo())
                .isEqualTo(4);
    }

    @Test
    @DisplayName("구매 금액으로 1000원 미만의 단위를 입력했을 경우")
    void notPurchasable() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PaidAmount(500));
    }
}
