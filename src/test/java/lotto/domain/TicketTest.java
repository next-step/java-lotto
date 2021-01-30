package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

public class TicketTest {

    @DisplayName("티켓 매칭 테스트")
    @ParameterizedTest
    @MethodSource("provideMatchNumberTest")
    public void matchNumberTest(long actual, int expected) {
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> provideMatchNumberTest() {
        return Stream.of(
                Arguments.of(new Ticket(Arrays.asList(1,2,3,4,5,6)).matchNumber(new Ticket(Arrays.asList(1,2,3,4,5,6))), 6),
                Arguments.of(new Ticket(Arrays.asList(1,2,3,4,5,6)).matchNumber(new Ticket(Arrays.asList(11,12,13,14,15,16))), 0),
                Arguments.of(new Ticket(Arrays.asList(1,2,3,4,5,6)).matchNumber(new Ticket(Arrays.asList(1,2,3,14,15,16))), 3)
        );
    }
}
