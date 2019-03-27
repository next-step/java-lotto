package lotto.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoBundleTest {

    @Test(expected = UnsupportedOperationException.class)
    public void 변경불가_확인() {
        List<LottoBall> lottoBalls = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            lottoBalls.add(new LottoBall(i+1));
        }
        LottoTicket lottoTicket = new LottoTicket(lottoBalls);
        LottoTicket illegalLottoTicket = new LottoTicket(lottoBalls);
        List<LottoTicket> lottoTickets = new ArrayList<>();
        lottoTickets.add(lottoTicket);

        LottoBundle lottoBundle = new LottoBundle(lottoTickets);
        lottoBundle.getTickets().add(illegalLottoTicket);
        assertThat(lottoBundle.getTickets().size()).isEqualTo(2);
    }
}
