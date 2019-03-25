package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.WiningLottoTicket;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


public class WiningLottoTicketTest {
    @Test
    public void 당첨_번호_포함된_개수_반환() {
        //given
        LottoTicket winningLottoTicket =  LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoTicket userLottoTicket = LottoTicket.of(Arrays.asList(1, 2, 3, 4, 8, 9));
        WiningLottoTicket winingLottoTicket = new WiningLottoTicket(winningLottoTicket, new LottoNumber((7)));

        //when
        int matchCount = winingLottoTicket.checkLottoNumber(userLottoTicket);

        //then
        assertThat(matchCount).isEqualTo(4);
    }

}