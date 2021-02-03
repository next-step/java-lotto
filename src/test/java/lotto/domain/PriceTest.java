package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PriceTest {

    @DisplayName("가격을 기준으로 티켓 개수 테스트")
    @ParameterizedTest
    @MethodSource("provideCalculateTicketsTest")
    public void calculateTicketsTest(int money, int tickets) {
        assertEquals(tickets, new Price(money).calculateTickets());
    }

    private static Stream<Arguments> provideCalculateTicketsTest() {
        return Stream.of(
                Arguments.of(24000, 24),
                Arguments.of(1000, 1)
        );
    }

    @DisplayName("돈에 맞게 티켓을 만드는지 확인하는 테스트")
    @ParameterizedTest
    @MethodSource("provideBuyTicketsTest")
    public void buyTicketsTest(int actual, int expected) {
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> provideBuyTicketsTest() {
        return Stream.of(
                Arguments.of(new Price(14000).buyTickets().size(), 14),
                Arguments.of(new Price(1000).buyTickets().size(), 1)
        );
    }
}
