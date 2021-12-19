package lottery.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AutoTicketCountTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, -1000})
    void invalidParam(int value) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> AutoTicketCount.from(value));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 100})
    void validValue(int value) {
        assertThat(AutoTicketCount.from(value))
            .isEqualTo(AutoTicketCount.from(value));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 100})
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
