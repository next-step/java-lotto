package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketsTest {

    @DisplayName("입력한 티켓수의 티켓이 생성된다.")
    @Test
    void size_test() {
        LottoTickets lottoTickets = new LottoTickets(1, () -> Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lottoTickets.size()).isEqualTo(1);
    }

    @DisplayName("입력한 숫자로 티켓이 생성된다.")
    @Test
    void get_tickets_test() {
        LottoTickets lottoTickets = new LottoTickets(1, () -> Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lottoTickets.getTickets().get(0).getLottoNumbers()).isEqualTo(
            Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("6개를 맞으면 1등이다.")
    @Test
    void get_lotto_ranks_test() {
        LottoTickets lottoTickets = new LottoTickets(1, () -> Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lottoTickets.getLottoRanks(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6))).get(0))
            .isEqualTo(LottoRank.FIRST);
    }
}
