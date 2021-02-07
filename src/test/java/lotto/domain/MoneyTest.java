package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneyTest {

    @DisplayName("가격을 기준으로 티켓 개수 테스트")
    @ParameterizedTest
    @MethodSource("provideCalculateTicketsTest")
    public void calculateTicketsTest(String money, int tickets) {
        assertEquals(tickets, new Money(money).calculateTickets());
    }

    private static Stream<Arguments> provideCalculateTicketsTest() {
        return Stream.of(
                Arguments.of("24000", 24),
                Arguments.of("1000", 1)
        );
    }
}
