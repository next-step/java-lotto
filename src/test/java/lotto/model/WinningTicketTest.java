package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningTicketTest {
    public static final int STARTING_NUMBER = 1;
    private Ticket ticket;

    @BeforeEach
    void setUp() {
        Set<Ball> balls = new HashSet<>();
        initBalls(balls, STARTING_NUMBER);
        ticket = Ticket.generateTicket(balls);
    }

    private void initBalls(Set<Ball> balls, int startingNumber) {
        for (int i = startingNumber; balls.size() < Ticket.SIZE; i++) {
            Ball ball = Ball.valueOf(i);
            balls.add(ball);
        }
    }

    @Test
    @DisplayName("WinningTicket은 티켓과 보너스볼로 생성된다.")
    void create_WinningTicket() {
        WinningTicket winningTicket = new WinningTicket(ticket, Ball.valueOf(Ball.MAXIMUM_VALUE));
        assertThat(winningTicket).isInstanceOf(WinningTicket.class);
    }

    @Test
    @DisplayName("WinningTicket의 보너스볼이 티켓에 있는 볼과 중복되면 예외를 발생시킨다.")
    void check_invalidLeftNumber_ExceptionThrown() {
        assertThatThrownBy(() -> new WinningTicket(ticket, Ball.valueOf(STARTING_NUMBER)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WinningTicket.BONUS_BALL_DUPLICATE_MESSAGE);
    }

    @Test
    @DisplayName("WinningTicket으로 Ticket의 등수를 확인할 수 있다.")
    void check_RankWithTicket() {
        WinningTicket winningTicket = new WinningTicket(ticket, Ball.valueOf(Ball.MAXIMUM_VALUE));
        assertThat(winningTicket.getRank(ticket)).isEqualByComparingTo(Rank.FIRST);
    }
}
