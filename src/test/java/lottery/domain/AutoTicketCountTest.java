package lottery.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AutoTicketCountTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, -1000})
    @DisplayName("음수 파라미터 테스트")
    void invalidParam(int value) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> AutoTicketCount.from(value));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 100})
    @DisplayName("정상 생성 테스트")
    void validValue(int value) {
        assertThat(AutoTicketCount.from(value))
            .isEqualTo(AutoTicketCount.from(value));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 100})
    @DisplayName("실제 구매한 티켓 수가 요청한 수와 일치하는지 확인하는 테스트")
    void buyTickets(int ticketCount) {
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        final AutoTicketCount autoTicketCount = AutoTicketCount.from(ticketCount);
        final LotteryTickets lotteryTickets = autoTicketCount.buyTickets(() -> numbers);

        final int actuallyBoughtTicketCount = lotteryTickets.tickets()
            .size();

        assertThat(ticketCount)
            .isEqualTo(actuallyBoughtTicketCount);
    }
}
