package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.Test;

public class LottoTicketTest {

    @Test
    public void 동일번호_4개_매칭_확인() {
        LottoTicket ticket = new LottoTicket(Arrays.asList(1,2,3,4,5,6));
        int howmany = ticket.howManyNumber(Arrays.asList(1,2,3,4,5,7));
        assertThat(howmany).isEqualTo(5);
    }
    
    @Test
    public void 동일번호_0개_매칭_확인() {
        LottoTicket ticket = new LottoTicket(Arrays.asList(1,2,3,4,5,6));
        int howmany = ticket.howManyNumber(Arrays.asList(10,11,12,13,14,16));
        assertThat(howmany).isEqualTo(0);
    }
}
