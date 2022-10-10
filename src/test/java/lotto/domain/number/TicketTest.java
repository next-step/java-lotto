package lotto.domain.number;

import static lotto.domain.LottoBallsHelper.numbersToBalls;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.List;
import lotto.domain.exception.NullLottoBallsListException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TicketTest {

    @Test
    @DisplayName("정해진 숫자 수 만큼의 숫자를 담은 로또볼 리스트로 로또티켓 생성")
    void generate_ticket() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Ticket ticket = new Ticket(numbersToBalls(numbers));

        numbers.forEach(
                number ->
                        assertThat(ticket.getLottoBalls()
                                .isContain(new LottoBall(number))
                        ).isTrue()
        );
    }

    @Test
    @DisplayName("정해진 숫자 수랑 다르게 로또티켓을 생성 시도 시 예외 발생.")
    void fail_to_generate_ticket_by_null() {
        assertThatExceptionOfType(NullLottoBallsListException.class)
                .isThrownBy(() -> new Ticket(null));
    }

}
