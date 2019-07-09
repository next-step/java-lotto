package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

/**
 * Created by wyparks2@gmail.com on 2019-07-08
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class WinningLottoTicketTest {
    private WinningLottoTicket winningLottoTicket;

    @BeforeEach
    void setUp() {
        winningLottoTicket = new WinningLottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
    }

    @Test
    void match_1등() {
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(winningLottoTicket.match(lottoTicket)).isEqualTo(LottoRank.FIRST);
    }

    @Test
    void match_2등() {
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 7));

        assertThat(winningLottoTicket.match(lottoTicket)).isEqualTo(LottoRank.SECOND);
    }

    @Test
    void match_3등() {
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 7, 8));

        assertThat(winningLottoTicket.match(lottoTicket)).isEqualTo(LottoRank.THIRD);
    }

    @Test
    void match_4등() {
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 7, 8, 9));

        assertThat(winningLottoTicket.match(lottoTicket)).isEqualTo(LottoRank.FOURTH);
    }

    @Test
    void match_꽝() {
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(11, 12, 13, 14, 15, 16));

        assertThat(winningLottoTicket.match(lottoTicket)).isEqualTo(LottoRank.MISS);
    }

    @Test
    void 보너스_중복숫자_불가() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new WinningLottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6), 6));
    }
}
