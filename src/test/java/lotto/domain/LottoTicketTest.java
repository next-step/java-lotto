package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.Test;

public class LottoTicketTest {

    @Test
    public void publish_로또개수확인() {
        final int lottosCount = 10;

        LottoTicket lottoTicket = new LottoTicket(lottosCount);

        List<Lotto> lottos = lottoTicket.publish();

        assertThat(lottos.size()).isEqualTo(lottosCount);
    }

    @Test
    public void publish_로또_각_숫자확인() {
        LottoTicket lottoTicket = new LottoTicket(1);

        List<Integer> lottoNumbers = lottoTicket.publish().get(0).getLottoNumbers();

        for (Integer lottoNumber : lottoNumbers) {
            assertThat(lottoNumber).isBetween(1, 45);
        }
    }
}