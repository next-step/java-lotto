package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {

    @Test
    @DisplayName("구입금액을 저장하여 발행할 티켓 수를 반환한다.")
    void money_save_test() {
        int purchaseAmount = 14000;

        Money money = new Money(purchaseAmount);

        int totalLottoTicketCount = money.getTotalLottoTicketCount();

        assertThat(totalLottoTicketCount).isEqualTo(purchaseAmount / 1000);
    }

    @Test
    @DisplayName("구입금액이 0 이하인 경우 exception 발생")
    void money_zero_exception_test() {
        int purchaseAmount = 0;

        assertThatThrownBy(() ->
                new Money(purchaseAmount)
        ).isInstanceOf(IllegalArgumentException.class);
    }

}
