package lottery.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LotteryTicketsTest {

    @Test
    @DisplayName("생성 테스트")
    void validGenerationTest() {
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        final LotteryTickets generatedTickets = LotteryTickets.create(1, FixedLotteryNumberGenerator.create(numbers));
        final LotteryTickets expectedTickets = LotteryTickets.create(Arrays.asList(LotteryTicket.of(numbers)));

        assertThat(generatedTickets).isEqualTo(expectedTickets);
    }

    @Test
    @DisplayName("LotteryNumberGenerator null 테스트")
    void nullArgumentTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> LotteryTickets.create(1, null));
    }
}
