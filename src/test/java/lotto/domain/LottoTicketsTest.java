package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoTicketsTest {

    @DisplayName("금액에 해당하는 로또 티켓을 발행한다.")
    @Test
    void buy_lotto() {
        LottoTickets tickets = LottoTickets.of(14000);
        List<LottoNumbers> lottoTickets = tickets.getLottoTickets();
        LottoNumbers lottoNumbers = lottoTickets.get(0);
        Set<Integer> set = new HashSet<>(lottoNumbers.getLottoNumbers());

        assertThat(lottoTickets.size()).isEqualTo(14);
        assertThat(set.size()).isEqualTo(6);
    }
}