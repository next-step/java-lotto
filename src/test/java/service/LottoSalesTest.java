package service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoSalesTest {
    @Test
    @DisplayName("입력한 금액만큼 로또티켓을 구매한다.")
    void buyLottoTest() {
        LottoSalesService lottoSalesService = new LottoSalesService();
        int tickets = lottoSalesService.buyTickets(2000);

        assertThat(tickets).isEqualTo(2);
    }
}
