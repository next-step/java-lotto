package lotto.model;

import lotto.model.Ball;
import lotto.model.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TicketTest {
    public static final int STARTING_NUMBER = 1;
    private Set<Ball> balls;
    private Ticket ticket;

    @BeforeEach
    void setUp() {
        balls = new HashSet<>();
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
    @DisplayName("Ticket은 6개의 로또 번호들로 생성한다.")
    void create_Ticket() {
        assertThat(ticket).isInstanceOf(Ticket.class);
    }

    @Test
    @DisplayName("Ticket을 랜덤하게 생성할 수 있다.")
    void create_RandomTicket() {
        Ticket ticket = Ticket.generateRandomTicket();
        assertThat(ticket).isInstanceOf(Ticket.class);
    }

    @Test
    @DisplayName("Ticket은 6개보다 많은 로또 번호들로 생성하면 예외를 발생한다.")
    void create_OverSize_ExceptionThrown() {
        balls.add(Ball.valueOf(Ball.MAXIMUM_VALUE));
        assertThatThrownBy(() -> Ticket.generateTicket(balls))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Ticket.OUT_OF_SIZE_MESSAGE);
    }

    @Test
    @DisplayName("Ticket 객체는 동등성을 보장한다.")
    void equals_HasSameValue() {
        Set<Ball> otherBalls = new HashSet<>(balls);
        Ticket otherTicket = Ticket.generateTicket(otherBalls);

        boolean result = ticket.equals(otherTicket);
        assertThat(result).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6})
    @DisplayName("Ticket 객체끼리는 서로 겹치는 Ball의 갯수를 확인할 수 있다")
    void match_CountSameBall(int shiftIndex) {
        Set<Ball> otherBalls = new HashSet<>();
        initBalls(otherBalls, STARTING_NUMBER + shiftIndex);

        Ticket otherTicket = Ticket.generateTicket(otherBalls);

        assertThat(ticket.match(otherTicket)).isEqualTo(Ticket.SIZE - shiftIndex);
    }
}