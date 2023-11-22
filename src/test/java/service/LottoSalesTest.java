package service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoSalesTest {
    @Test
    @DisplayName("입력한 금액만큼 로또티켓을 구매한다.")
    void buyLottoTest() {
        int tickets = LottoSalesService.validateMoneyAndReturnTicketCount(2000);

        assertThat(tickets).isEqualTo(2);
    }
}
