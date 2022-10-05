package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.number.Ticket;
import lotto.domain.number.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoMachineTest {

    @Test
    @DisplayName("주어진 금액에 맞는 수만큼 자동 로또 생성")
    void get_automatic_tickets() {
        assertThat(LottoMachine.getAutomaticTickets(14000)
                .getSize())
                .isEqualTo(14);
    }

    @ParameterizedTest
    @MethodSource("getMatchCountTestArguments")
    @DisplayName("주어진 당첨 번호로 해당 로또 숫자 일치 수 판별")
    void determine_matching_count(WinningNumbers winningNumbers, Ticket ticket, int expected) {
        assertThat(LottoMachine.getMatchingNumberCount(winningNumbers, ticket))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> getMatchCountTestArguments() {
        return Stream.of(
                Arguments.arguments(
                        new WinningNumbers(List.of(3, 8, 12, 14, 15, 17)),
                        new Ticket(List.of(3, 8, 12, 14, 15, 17)),
                        6
                ),
                Arguments.arguments(
                        new WinningNumbers(List.of(3, 8, 12, 14, 15, 17)),
                        new Ticket(List.of(1, 2, 9, 11, 19, 21)),
                        0
                ),
                Arguments.arguments(
                        new WinningNumbers(List.of(3, 8, 12, 14, 15, 17)),
                        new Ticket(List.of(3, 5, 12, 13, 14, 19)),
                        3
                )
        );
    }
}
