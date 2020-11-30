package lotto_auto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoBundleTest {

    @DisplayName("로또 번들 티켓 카운트 테스트")
    @Test
    public void lottoBundleTicketCountTest() {
        LottoNumbers lottoNumbers = new LottoNumbers("1,2,3,4,5,6");
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);
        LottoBundle lottoBundle = new LottoBundle(Arrays.asList(lottoTicket));
        assertThat(lottoBundle.getTicketCount()).isEqualTo(1);
    }

    @DisplayName("로또 번들 티켓 카운트 테스트")
    @Test
    public void lottoBundleExportTest() {
        LottoNumbers lottoNumbers = new LottoNumbers("1,2,3,4,5,6");
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);
        LottoBundle lottoBundle = new LottoBundle(Arrays.asList(lottoTicket));
        List<LottoTicket> export = lottoBundle.export();
        assertAll(() -> assertThat(export).isNotNull(),
                () -> assertThat(export.size()).isEqualTo(1)
        );
    }

}
