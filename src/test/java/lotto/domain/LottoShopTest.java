package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoShopTest {

    @Test
    @DisplayName("수동 티켓 수가 총 티켓 수를 초과하면 예외 발생한다")
    void validateAndGetTotalTicketAmountTest_manualGtTotal() {
        Money price = new Money(3000);
        TicketAmount manualAmount = new TicketAmount(5);

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoShop.validateAndGetTotalTicketAmount(price, manualAmount));
    }

    @Test
    @DisplayName("구매 금액으로 살 수 있는 로또 갯수를 반환한다(로또 1장의 가격은 1000원이다.)")
    void validateAndGetTotalTicketAmountTest_returnsTotalAmount() {
        Money price = new Money(5000); // 5장
        TicketAmount manualAmount = new TicketAmount(3);

        TicketAmount total = LottoShop.validateAndGetTotalTicketAmount(price, manualAmount);

        assertThat(total.getAmount()).isEqualTo(5);
    }

}
