package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TicketMachineTest {

    static Stream<Arguments> invalidManualCases() {
        return Stream.of(
            Arguments.of(14000, -5),
            Arguments.of(14000, 15)
        );
    }

    @DisplayName("총 구매금액이 주어졌을 때, 1000원 단위가 아닌 유효하지 않은 경우에 예외발생")
    @Test
    void invalidAmountCases() {
        assertThatThrownBy(() -> new TicketMachine(14500, 3))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("총 구매금액과 수동 티켓 수가 유효하게 주어졌을 때, 수동 티켓 수가 음수이거나 총 구매금액을 초과하면 예외발생")
    @ParameterizedTest
    @MethodSource("invalidManualCases")
    void invalidManualTicketCases(final int amount, final int manualTickets) {
        assertThatThrownBy(() -> new TicketMachine(amount, manualTickets))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("총 구매금액과 수동 티켓 수가 유효하게 주어졌을 때, 수동 티켓 수와 자동 티켓 수가 올바르게 반환")
    @Test
    void testEachTicketsValid() {
        TicketMachine machine = new TicketMachine(14000, 3);

        assertAll(
            () -> assertThat(machine.autoTickets()).isEqualTo(11),
            () -> assertThat(machine.manualTickets()).isEqualTo(3)
        );
    }

}
