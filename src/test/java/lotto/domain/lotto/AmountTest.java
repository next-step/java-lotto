package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AmountTest {
    @DisplayName("총 구매금액이 주어졌을 때, 1000원 단위가 아닌 유효하지 않은 경우에 예외발생")
    @Test
    void invalidAmountCases() {
        List<Ticket> numbers = Arrays.asList(
            new Ticket(
                Stream.of(1, 2, 3, 4, 5, 6)
                .map(Number::new)
                .collect(Collectors.toList())
            ),
            new Ticket(
                Stream.of(7, 8, 9, 10, 11, 12)
                    .map(Number::new)
                    .collect(Collectors.toList())
            ),
            new Ticket(
                Stream.of(13, 14, 15, 16, 17, 18)
                    .map(Number::new)
                    .collect(Collectors.toList())
            )
        );

        assertThatThrownBy(() -> new TicketMachine(new Amount(14500), numbers))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
