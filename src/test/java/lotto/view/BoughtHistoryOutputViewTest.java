package lotto.view;

import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BoughtHistoryOutputViewTest {
    @DisplayName("Money를 인자로 받아서 구매한 LottoTicket 수 결과 문자열을 반환한다.")
    @Test
    void getHowManyLottoTicketsTest() {
        Money money = new Money(10000L);
        String expected = "10개를 구매했습니다.";

        assertThat(BoughtHistoryOutputView.getHowManyLottoTickets(money)).isEqualTo(expected);
    }
}
