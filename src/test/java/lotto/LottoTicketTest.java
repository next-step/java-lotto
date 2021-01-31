package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {
    @DisplayName("두 티켓의 같은 값이 몇개 있는지를 잘 반환하는지")
    @Test
    void countMatches() {
        LottoTicket ticket1 = new LottoTicket(
            new ArrayList<LottoNumber>() {{
                add(new LottoNumber(1));
                add(new LottoNumber(2));
                add(new LottoNumber(3));
                add(new LottoNumber(4));
                add(new LottoNumber(5));
                add(new LottoNumber(6));
            }}
        );

        LottoTicket ticket2 = new LottoTicket(
            new ArrayList<LottoNumber>() {{
                add(new LottoNumber(5));
                add(new LottoNumber(6));
                add(new LottoNumber(7));
                add(new LottoNumber(8));
                add(new LottoNumber(9));
                add(new LottoNumber(10));
            }}
        );

        assertThat(
            ticket1.countMatches(ticket2)
        ).isEqualTo(2);
    }

    @DisplayName("특정 번호를 포함하고 있는지를 잘 체크하는지 확인")
    @Test
    void isIncludeNumber() {
        LottoTicket ticket = new LottoTicket(
            new ArrayList<LottoNumber>() {{
                add(new LottoNumber(1));
                add(new LottoNumber(2));
                add(new LottoNumber(3));
                add(new LottoNumber(4));
                add(new LottoNumber(5));
                add(new LottoNumber(6));
            }}
        );

        assertThat(
            ticket.includeNumber(
                new LottoNumber(1)
            )
        ).isEqualTo(true);
    }

    @DisplayName("특정 번호를 포함하고 있지 않은지를 잘 체크하는지 확인")
    @Test
    void NotIncludeBounsNumber() {
        LottoTicket ticket = new LottoTicket(
            new ArrayList<LottoNumber>() {{
                add(new LottoNumber(1));
                add(new LottoNumber(2));
                add(new LottoNumber(3));
                add(new LottoNumber(4));
                add(new LottoNumber(5));
                add(new LottoNumber(6));
            }}
        );

        assertThat(
            ticket.includeNumber(
                new LottoNumber(1)
            )
        ).isEqualTo(true);
    }
}