package service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoSalesTest {
    @Test
    @DisplayName("입력한 금액만큼 로또티켓을 구매한다.")
    void buyLottoTest() {
        int tickets = LottoSalesService.validateMoneyAndReturnTicketCount(2000);

        assertThat(tickets).isEqualTo(2);
    }
    @Test
    @DisplayName("1000원 미만을 입력하는 경우 IllegalArgumentException throw 테스트")
    void lessMoneyExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> LottoSalesService.validateMoneyAndReturnTicketCount(900));
    }

    @Test
    @DisplayName("사용자가 총 구매 가능 로또 수를 초과 입력하는 경우 Exception throw")
    void checkTicketCountTest() {

    }
}
