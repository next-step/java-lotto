package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import lotto.utils.LottoHelper;
import org.junit.Test;

public class LottoTicketTest {

    @Test
    public void 로또복권_생성_검증() {
        LottoTicket ticket1 = new LottoTicket(LottoHelper.convertToBalls("1,2,3,4,5,6"));
        assertThat(ticket1.getNumbers().size()).isEqualTo(6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 자리수부족_로또복권_생성_검증() {
        LottoTicket ticket1 = new LottoTicket(LottoHelper.convertToBalls("1,2,3"));
    }

    @Test
    public void 매칭_5개_확인() {
        LottoTicket ticket1 = new LottoTicket(LottoHelper.convertToBalls("1,2,3,4,5,6"));
        LottoTicket ticket2 = new LottoTicket(LottoHelper.convertToBalls("1,2,3,4,5,7"));
        int matchCount = ticket1.howManyMatch(ticket2);
        assertThat(matchCount).isEqualTo(5);
    }

    @Test
    public void 매칭_0개_확인() {
        LottoTicket ticket1 = new LottoTicket(LottoHelper.convertToBalls("1,2,3,4,5,6"));
        LottoTicket ticket2 = new LottoTicket(LottoHelper.convertToBalls("10,12,13,14,15,17"));
        int matchCount = ticket1.howManyMatch(ticket2);
        assertThat(matchCount).isEqualTo(0);
    }
}
