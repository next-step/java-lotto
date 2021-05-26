package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {

    @DisplayName("구매액/티켓가격과 일치하는 티켓장수가 발급되었는지 테스트")
    @Test
    void check_count_of_tickets() {
        //Given
        Money purchaseAmount = new Money(18000);

        //When + Then
        LottoTickets lottoTickets = new LottoTickets(AutoLottoTicketGenerator.start(), purchaseAmount);

        //Then
        assertThat(lottoTickets.count()).isEqualTo(purchaseAmount.countOfTickets());
    }
}
