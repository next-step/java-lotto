package com.nextstep.lotto.view;

import com.nextstep.lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class BoughtHistoryOutputViewTest {
    @DisplayName("사용자에게 수동으로 구매한 LottoTicket과 자동으로 구매한 LottoTicket의 수를 보여줄 수 있다.")
    @Test
    void getHowManyLottoTicketsTest() {
        int numberOfStaticLottoTickets = 3;
        Money remainMoney = new Money(10000L);
        String expected = "수동으로 3장, 자동으로 10개를 구매했습니다.";

        assertThat(BoughtHistoryOutputView.getHowManyLottoTickets(numberOfStaticLottoTickets, remainMoney))
                .isEqualTo(expected);
    }

    @DisplayName("LottoTickets를 사용자에게 보여줄 수 있다.")
    @Test
    void parseLottoTickets() {
        LottoTicketCreatePolicy createPolicy1 = new StaticCreatePolicy(Arrays.asList(1,2,3,4,5,6));
        LottoTicketCreatePolicy createPolicy2 = new StaticCreatePolicy(Arrays.asList(7,8,9,10,11,12));
        String expected = "[1, 2, 3, 4, 5, 6]" + "\n" + "[7, 8, 9, 10, 11, 12]" + "\n";

        LottoTickets lottoTickets = new LottoTickets(
                Arrays.asList(LottoTicket.of(createPolicy1), LottoTicket.of(createPolicy2)));

        assertThat(BoughtHistoryOutputView.parseLottoTickets(lottoTickets)).isEqualTo(expected);
    }
}
