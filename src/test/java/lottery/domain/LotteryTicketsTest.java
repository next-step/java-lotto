package lottery.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteryTicketsTest {

    @Test
    @DisplayName("생성 테스트")
    void validGenerationTest() {
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        final LotteryTickets expectedTickets = LotteryTickets.create(Arrays.asList(LotteryTicket.from(numbers)));
    }

    @Test
    @DisplayName("null parameter 테스트")
    void nullArgumentTest() {
        assertThatIllegalArgumentException().isThrownBy(
            () -> LotteryTickets.create(LotteryTickets.create(), null));

        assertThatIllegalArgumentException().isThrownBy(
            () -> LotteryTickets.create(null, LotteryTickets.create(Collections.emptyList())));
    }
}
