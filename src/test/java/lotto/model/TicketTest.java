package lotto.model;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class TicketTest {
    @Test
    public void 티켓_번호_3개일치() {
        Ticket ticket = new Ticket(LottoNum.toLottoNums(Arrays.asList(8, 21, 23, 41, 42, 43)));
        int matchNums = ticket.countMatch(LottoNum.toLottoNums(Arrays.asList(1, 2, 3, 8, 21, 43)));
        assertThat(matchNums).isEqualTo(3);
    }

    @Test
    public void 티켓_번호_6개일치() {
        Ticket ticket = new Ticket(LottoNum.toLottoNums(Arrays.asList(8, 21, 23, 41, 42, 43)));
        int matchNums = ticket.countMatch(LottoNum.toLottoNums(Arrays.asList(8, 21, 23, 41, 42, 43)));
        assertThat(matchNums).isEqualTo(6);
    }

    @Test
    public void hasBonusNum_6() {
        Ticket ticket = new Ticket(LottoNum.toLottoNums(Arrays.asList(1, 2, 3, 4, 5, 6)));
        boolean hasBonusNum = ticket.hasBonusNum(LottoNum.toLottoNum(6));
        assertThat(hasBonusNum).isTrue();
    }

}
