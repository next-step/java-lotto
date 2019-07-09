package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

/**
 * Created by wyparks2@gmail.com on 2019-07-08
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class LottoTicketTest {
    @Test
    void 로또_숫자는_6개이여야_한다() {
        new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    void 로또_숫자는_6미만_오류발생() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new LottoTicket(Arrays.asList(1, 2, 3, 4, 5));
                });
    }

    @Test
    void 로또_숫자는_6이상_오류발생() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
                });
    }

    @Test
    void match_1등() {
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoTicket winningLottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(winningLottoTicket.match(lottoTicket)).isEqualTo(6);
    }

    @Test
    void match_2등() {
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 7));
        LottoTicket winningLottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(winningLottoTicket.match(lottoTicket)).isEqualTo(5);
    }

    @Test
    void match_3등() {
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 7, 8));
        LottoTicket winningLottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(winningLottoTicket.match(lottoTicket)).isEqualTo(4);
    }

    @Test
    void match_4등() {
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 7, 8, 9));
        LottoTicket winningLottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(winningLottoTicket.match(lottoTicket)).isEqualTo(3);
    }

    @Test
    void match_꽝() {
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(11, 12, 13, 14, 15, 16));
        LottoTicket winningLottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(winningLottoTicket.match(lottoTicket)).isEqualTo(0);
    }
}
