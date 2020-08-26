package step2;

import org.junit.jupiter.api.Test;
import step2.domain.LottoNumbers;
import step2.domain.LottoResult;
import step2.domain.LottoTicket;
import step2.domain.WinningLottoNumbers;

import static org.assertj.core.api.Assertions.*;

public class LottoTicketTest {
    @Test
    void ticketTest() {
        LottoTicket lottoTicket = LottoNumbers.create(1);
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers("10,1,31,27,19,20");
        LottoResult lottoResult = lottoTicket.getMatching(winningLottoNumbers);
        assertThat(lottoResult.getResultMap().size() <= 4).isTrue();
    }
}
