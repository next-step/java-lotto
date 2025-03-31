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
    @DisplayName("로또 티켓은 당첨번호와 일치하는 숫자의 개수를 반환한다.")
    void countMatchNumbers() {
        LottoTicket lottoTicket = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));
        LottoTicket lottoTicket2 = new LottoTicket(List.of(1, 2, 3, 4, 5, 7));
        assertThat(lottoTicket.countMatchNumbers(lottoTicket2)).isEqualTo(5);
    }

    @Test
    @DisplayName("로또 티켓은 로또 넘버를 포함하는지 확인한다.")
    void containsNumber() {
        assertThat(new LottoTicket(List.of(1, 2, 3, 4, 5, 6)).contains(new LottoNumber(1))).isTrue();
    }

}