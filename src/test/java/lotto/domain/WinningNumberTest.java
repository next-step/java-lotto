package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

public class WinningNumberTest {

    static WinningNumber winningNumber;

    @BeforeAll
    static void setUp() {
        winningNumber = new WinningNumber(new Ticket(Arrays.asList(1,2,3,4,5,6)), 7);
    }

    @DisplayName("위닝 넘버 매칭 테스트")
    @ParameterizedTest
    @MethodSource("provideCheckTicketAndWinningTest")
    public void checkTicketAndWinningTest(long actual, int expected) {
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> provideCheckTicketAndWinningTest() {
        return Stream.of(
                Arguments.of(winningNumber.checkTicketAndWinning(new Ticket(Arrays.asList(1,2,3,4,5,6))), 6),
                Arguments.of(winningNumber.checkTicketAndWinning(new Ticket(Arrays.asList(11,12,13,14,15,16))), 0),
                Arguments.of(winningNumber.checkTicketAndWinning(new Ticket(Arrays.asList(1,2,3,14,15,16))), 3)
        );
    }

    @DisplayName("보너 넘버 매칭 테스트")
    @ParameterizedTest
    @MethodSource("provideCheckTicketAndBonusTest")
    public void checkTicketAndBonusTest(boolean actual, boolean expected) {
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> provideCheckTicketAndBonusTest() {
        return Stream.of(
                Arguments.of(winningNumber.checkTicketAndBonus(new Ticket(Arrays.asList(11,12,13,14,15,7))), true),
                Arguments.of(winningNumber.checkTicketAndBonus(new Ticket(Arrays.asList(1,2,3,4,5,6))), false)
        );
    }
}
