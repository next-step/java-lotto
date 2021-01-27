package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoTest {
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto();
    }

    @DisplayName("가격을 기준으로 티켓 개수 테스트")
    @ParameterizedTest
    @MethodSource("provideCalculateTicketsTest")
    public void calculateTicketsTest(int money, int tickets) {
        assertEquals(tickets, lotto.calculateTickets(money));
    }

    private static Stream<Arguments> provideCalculateTicketsTest() {
        return Stream.of(
            Arguments.of(24000, 24),
            Arguments.of(1000, 1)
        );
    }
}
