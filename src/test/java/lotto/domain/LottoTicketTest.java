package lotto.domain;
import lotto.dto.WinningLotto;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @Test
    public void 유저로또티켓_확인(){
        ILottoGenerator lottoGenerator = new LottoGeneratorFixture();
        LottoTicket ticket = new LottoTicket(lottoGenerator);
        assertThat(ticket.getTicket().stream().max(Comparator.comparing(Integer::valueOf)).get()).isEqualTo(6);
        assertThat(ticket.getTicket()).hasSize(6);
    }

    @Test
    public void 숫자매칭카운트(){
        ILottoGenerator lottoGenerator = new LottoGeneratorFixture();
        LottoTicket ticket = new LottoTicket(lottoGenerator);
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1,2,3,4,5,6));
        ticket.addTicketMatchCount(winningLotto);

        assertThat(ticket.getMatchCount()).isEqualTo(6);
    }
}