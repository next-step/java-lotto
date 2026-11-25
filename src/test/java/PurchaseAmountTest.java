import domain.PurchaseAmount;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchaseAmountTest {


    @Test
    void 금액이_1000원_미만이면_예외가_발생한다() {
        assertThatThrownBy(() -> new PurchaseAmount(800))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구매_가능한_로또_개수를_반환한다() {
        PurchaseAmount amount = new PurchaseAmount(14000);
        assertThat(amount.ticketCount()).isEqualTo(14);
    }
}