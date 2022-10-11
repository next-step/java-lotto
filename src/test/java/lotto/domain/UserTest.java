package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserTest {

    private final User user = new User();

    @Test
    @DisplayName("티켓 수취 예외 검증")
    void receiveTicketsException() {
        assertThatThrownBy(() -> user.receiveTickets(null)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> user.receiveTickets(Arrays.asList())).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("가져올 로또 티켓이 없는 경우")
    void lottoTicket() {
        assertThat(user.lottoTickets()).isEqualTo(new ArrayList<Integer>());
    }

    @Test
    @DisplayName("사용자 로또와 당첨 로또 번호 비교 후 일치 개수 반환")
    void matchingCountsByTickets() {
        user.receiveTickets(Arrays.asList(new LottoTicket(new TreeSet<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6)))));

        assertThat(user.matchingCountsByTickets(new WinningNumber(new LottoTicket(new TreeSet<Integer>(Arrays.asList(4, 5, 6, 7, 8, 9)))).winningNumber()))
                .isEqualTo(Arrays.asList(3));
    }

    @Test
    @DisplayName("사용자 로또와 당첨 로또 번호 비교 후 일치 개수 반환 - 예외")
    void matchingCountsByTicketsUserLottoEmpty() {
        user.receiveTickets(Arrays.asList(new LottoTicket(new TreeSet<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6)))));

        assertThatThrownBy(() -> user.matchingCountsByTickets(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사용자 로또와 당첨 로또 번호 비교 후 일치 개수 반환 - 예외")
    void matchingCountsByTicketsWinningLottoNull() {
        assertThatThrownBy(() -> user.matchingCountsByTickets(new WinningNumber(new LottoTicket(new TreeSet<Integer>(Arrays.asList(4, 5, 6, 7, 8, 9)))).winningNumber()))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
