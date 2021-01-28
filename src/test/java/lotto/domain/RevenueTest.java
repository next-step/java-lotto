package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RevenueTest {

    @DisplayName("로또 번호 일치, 개수 체크 테스트")
    @ParameterizedTest
    @MethodSource("provideCheckTheNumberOfMatchingLottoTest")
    public void checkTheNumberOfMatchingLotto(Ticket lottoNumbers,
        WinningNumber winningNumbers, Enum<Revenue> expected) {
        assertEquals(expected,
            Revenue.checkTheNumberOfMatchingLotto(lottoNumbers, winningNumbers));
    }

    private static Stream<Arguments> provideCheckTheNumberOfMatchingLottoTest() {
        return Stream.of(
            Arguments.of(new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6)), new WinningNumber(new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6)), 8),
                Revenue.SIX_MATCHES),
            Arguments.of(new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6)), new WinningNumber(new Ticket(Arrays.asList(1, 2, 3, 4, 5, 7)), 6),
                Revenue.FIVE_AND_BONUS_MATCHES),
            Arguments.of(new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6)), new WinningNumber(new Ticket(Arrays.asList(1, 2, 3, 4, 5, 7)), 9),
                Revenue.FIVE_MATCHES),
            Arguments.of(new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6)), new WinningNumber(new Ticket(Arrays.asList(1, 2, 3, 4, 45, 44)), 9),
                Revenue.FOUR_MATCHES),
            Arguments.of(new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6)), new WinningNumber(new Ticket(Arrays.asList(1, 2, 3, 33, 22, 11)), 44),
                Revenue.THREE_MATCHES),
            Arguments.of(new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6)), new WinningNumber(new Ticket(Arrays.asList(11, 22, 33, 44, 45, 37)), 10),
                Revenue.NOTHING)
        );
    }
}
