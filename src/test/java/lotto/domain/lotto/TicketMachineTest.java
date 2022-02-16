package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TicketMachineTest {

    private TicketMachine machine;

    @BeforeEach
    void setUp() {
        int amount = 14000;
        machine = new TicketMachine(new Amount(amount), getNumbers());
    }

    @DisplayName("티켓 구매시 수동 티켓과 자동 티켓의 합이 총 구매장수와 일치해야 한다.")
    @Test
    void purchaseTest() {
        Tickets tickets = machine.purchase();

        assertThat(tickets.getEachTicketNumbers().size())
            .isEqualTo(14);
    }

    @DisplayName("총 구매금액과 수동 티켓 수가 유효하게 주어졌을 때, 수동 티켓 수와 자동 티켓 수가 올바르게 반환")
    @Test
    void testEachTicketsValid() {
        assertAll(
            () -> assertThat(machine.autoTickets()).isEqualTo(11),
            () -> assertThat(machine.manualTickets()).isEqualTo(3)
        );
    }

    List<List<Number>> getNumbers() {
        return Arrays.asList(
            Stream.of(1, 2, 3, 4, 5, 6)
                .map(Number::new)
                .collect(Collectors.toList()),
            Stream.of(7, 8, 9, 10, 11, 12)
                .map(Number::new)
                .collect(Collectors.toList()),
            Stream.of(13, 14, 15, 16, 17, 18)
                .map(Number::new)
                .collect(Collectors.toList())
        );
    }

}
