package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TicketsTest {
    @DisplayName(" 티켓 개수가 올바른 경우 테스트")
    @ParameterizedTest
    @MethodSource("provideValidateTicketsTest")
    public void validateTicketsTest(List<String> input, TicketCount totalCount) {
        Tickets tickets = new Tickets(input, totalCount);
        assertEquals(tickets, new Tickets(input, totalCount));
    }

    private static Stream<Arguments> provideValidateTicketsTest() {
        return Stream.of(
            Arguments.of(Arrays.asList(
                "8, 21, 23, 41, 42, 43",
                "3, 5, 11, 16, 32, 38",
                "7, 11, 16, 35, 36, 44"
                ), new TicketCount(3))
        );
    }

    @DisplayName(" 티켓 개수가 올바르지 않은 경우 테스트")
    @ParameterizedTest
    @MethodSource("provideValidateTicketsBadTest")
    public void validateTicketsBadTest(List<String> input, TicketCount totalCount) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Tickets(input, totalCount));
    }

    private static Stream<Arguments> provideValidateTicketsBadTest() {
        return Stream.of(
            Arguments.of(Arrays.asList("3"), new TicketCount(2)),
            Arguments.of(Arrays.asList("dgsdgsa"), new TicketCount(2))
        );
    }
}
