package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TicketAmountTest {
    @Test
    @DisplayName("티켓 갯수가 0개 미만이면 예외를 반환한다.")
    void ticketAmountLessThan0() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new TicketAmount(-10));
    }

    @Test
    @DisplayName("amount가 더 크면 true를 반환한다.")
    void isGreaterThanTest() {
        TicketAmount three = new TicketAmount(3);
        TicketAmount two = new TicketAmount(2);
        TicketAmount sameThree = new TicketAmount(3);

        assertThat(three.isGreaterThan(two)).isTrue();
        assertThat(two.isGreaterThan(three)).isFalse();
        assertThat(three.isGreaterThan(sameThree)).isFalse();
    }

    @Test
    @DisplayName("amount를 뺀 값을 반환한다.")
    void minusTest() {
        TicketAmount five = new TicketAmount(5);
        TicketAmount two = new TicketAmount(2);

        TicketAmount result = five.minus(two);

        assertThat(result.getAmount()).isEqualTo(3);
    }

}
