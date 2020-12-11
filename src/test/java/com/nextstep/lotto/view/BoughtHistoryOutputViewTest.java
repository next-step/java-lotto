package com.nextstep.lotto.view;

import com.nextstep.lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class BoughtHistoryOutputViewTest {
    @DisplayName("Money를 인자로 받아서 구매한 LottoTicket 수 결과 문자열을 반환한다.")
    @Test
    void getHowManyLottoTicketsTest() {
        Money money = new Money(10000L);
        String expected = "10개를 구매했습니다.";

        assertThat(BoughtHistoryOutputView.getHowManyLottoTickets(money)).isEqualTo(expected);
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
