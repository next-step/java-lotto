package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class LottoTicketTest {

    @Test
    public void publish_로또_개수확인() {
        final int lottosCount = 10;

        LottoTicket lottoTicket = new LottoTicket(lottosCount);

        List<Lotto> lottos = lottoTicket.publish();

        assertThat(lottos.size()).isEqualTo(lottosCount);
    }

    @Test
    public void publish_로또_각_번호확인() {
        LottoTicket lottoTicket = new LottoTicket(1);

        List<Integer> lottoNumbers = lottoTicket.publish().get(0).getLottoNumbers();

        for (Integer lottoNumber : lottoNumbers) {
            assertThat(lottoNumber).isBetween(1, 45);
        }
    }

    @Test
    public void announceWinningResult() {
        final List<Integer> winningNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoTicket lottoTicket = new LottoTicket(1000);

        lottoTicket.publish();

        Map<Integer, List<Lotto>> lottoResult = lottoTicket.announceWinningResult(winningNumbers);

        for (int i = 3; i <= 6 ; i++) {
            List<Lotto> lottos = lottoResult.get(i);
            int count = 0;

            for (Lotto lotto : lottos) {
                List<Integer> lottoNumbers = lotto.getLottoNumbers();

                lottoNumbers.retainAll(winningNumbers);

                if (lottoNumbers.size() == i) {
                    count++;
                }
            }

            assertThat(count).isEqualTo(lottoResult.get(i).size());
        }
    }
}