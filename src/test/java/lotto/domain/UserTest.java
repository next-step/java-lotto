package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserTest {

    private final User user = new User(new UserInput(5000));

    @Test
    @DisplayName("의존성 주입 검증")
    void constructorDI() {
        assertThatThrownBy(() -> new User(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("유저가 티켓 인수 여부 확인")
    void receiveTicketsException() {

        List<NavigableSet<Integer>> invalidTickets1 = Arrays.asList(new TreeSet<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
        List<NavigableSet<Integer>> invalidTickets2 = Arrays.asList(new TreeSet<Integer>(Arrays.asList(46, 47, 48, 49, 999, 1000)));

        assertThatThrownBy(() -> user.receiveTickets(null)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> user.receiveTickets(Arrays.asList())).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> user.receiveTickets(invalidTickets1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> user.receiveTickets(invalidTickets2)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("가져올 로또 티켓이 없는 경우")
    void getLottoTicket() {
        assertThat(user.lottoTickets()).isEqualTo(new ArrayList<Integer>());
    }

    @Test
    void matchingCountsByTicketsException() {
        NavigableSet<Integer> invalidTicket1 = new TreeSet<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        NavigableSet<Integer> invalidTicket2 = new TreeSet<Integer>(Arrays.asList(46, 47, 48, 49, 999, 1000));

        assertThatThrownBy(() -> user.matchingCountsByTickets(null)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> user.matchingCountsByTickets(invalidTicket1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> user.matchingCountsByTickets(invalidTicket2)).isInstanceOf(IllegalArgumentException.class);
    }
}
