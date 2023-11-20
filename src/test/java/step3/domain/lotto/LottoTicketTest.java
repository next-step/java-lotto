package step3.domain.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {

    LottoTicket winningLottoTicket;
    LottoTicket userLottoTicket;

    @BeforeEach
    void setUp() {
        winningLottoTicket = LottoTicket.from(new LottoNumber(Arrays.asList(1, 2, 4, 8, 16, 32)));
    }

    @Test
    void 매칭_되는_개수_확인_테스트() {
        userLottoTicket = new LottoTicket(
                List.of(new LottoNumber(List.of(32, 8, 16, 1, 4, 2)),
                        new LottoNumber(List.of(3, 2, 5, 8, 16, 33))
                )
        );
        assertThat(winningLottoTicket.findCountOfMatch(userLottoTicket.getLottoNumbers().get(0))).isEqualTo(6);
        assertThat(winningLottoTicket.findCountOfMatch(userLottoTicket.getLottoNumbers().get(1))).isEqualTo(3);
    }
}
