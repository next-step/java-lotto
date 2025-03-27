package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketTest {

    @Test
    @DisplayName("로또 티켓은 1과 45사이의 숫자로 구성된다.")
    void createLottoTicketWithWrongBound() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 46);
        List<Integer> numbers2 = List.of(0, 2, 3, 4, 5, 45);
        assertThatThrownBy(() -> new LottoTicket(numbers)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoTicket(numbers2)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 티켓은 6개의 숫자로 구성된다.")
    void createLottoTicketWithWrongSize() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);
        List<Integer> numbers2 = List.of(1, 2, 3, 4, 5);
        assertThatThrownBy(() -> new LottoTicket(numbers)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoTicket(numbers2)).isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("로또 티켓은 중복된 숫자를 가지지 않는다.")
    void ticketNumberShouldNotBeDuplicate() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);
        assertThatThrownBy(() -> new LottoTicket(numbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨된 로또 티켓과 비교하여 당첨 순위를 반환한다.")
    void findNumberMatchCount() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        LottoTicket lottoTicket = new LottoTicket(numbers);

        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        LottoTicket winingTicket = new LottoTicket(winningNumbers);
        assertThat(lottoTicket.rank(winingTicket)).isEqualTo(LottoRank.FIRST);
    }
}