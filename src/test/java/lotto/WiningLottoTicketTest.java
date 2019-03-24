package lotto;

import lotto.domain.LottoTicket;
import lotto.domain.WiningLottoTicket;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


public class WiningLottoTicketTest {
    @Test
    public void 당첨_번호_포함된_개수_반환() {
        //given
        WiningLottoTicket winingLottoTicket = new WiningLottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(6, 3, 1, 10, 45, 30));
        //when
        int matchCount = winingLottoTicket.checkLottoNumber(lottoTicket);
        //then
        assertThat(matchCount).isEqualTo(3);
    }

}