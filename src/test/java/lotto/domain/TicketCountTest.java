package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TicketCountTest {

    @DisplayName(" 티켓 개수가 올바른 경우 테스트")
    @ParameterizedTest
    @MethodSource("provideValidateTicketCountTest")
    public void validateTicketCountTest(String input, TicketCount totalCount) {
        TicketCount ticketCount = new TicketCount(input, totalCount);
        assertEquals(ticketCount, new TicketCount(input, totalCount));
    }

    private static Stream<Arguments> provideValidateTicketCountTest() {
        return Stream.of(
            Arguments.of("1", new TicketCount(2)),
            Arguments.of("2", new TicketCount(2))
        );
    }

    @DisplayName(" 티켓 개수가 올바르지 않은 경우 테스트")
    @ParameterizedTest
    @MethodSource("provideValidateTicketCountBadTest")
    public void validateTicketCountBadTest(String input, TicketCount totalCount) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new TicketCount(input, totalCount));
    }

    private static Stream<Arguments> provideValidateTicketCountBadTest() {
        return Stream.of(
            Arguments.of("3", new TicketCount(2)),
            Arguments.of("dgsdgg", new TicketCount(2))
        );
    }
}
