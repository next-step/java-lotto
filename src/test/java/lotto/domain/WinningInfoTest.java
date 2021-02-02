package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningInfoTest {


    @DisplayName("로또 번호와 지난주 당첨 번호 일치 테스트")
    @ParameterizedTest
    @MethodSource("provideMatchWinningTest")
    void matchWinningTest(WinningInfo winningInfo, Ticket ticket, int expected) {
        assertEquals(expected, winningInfo.matchWinning(ticket));
    }

    private static Stream<Arguments> provideMatchWinningTest() {
        return Stream.of(
            Arguments.of(
                new WinningInfo(new WinningNumber(
                    new Ticket(Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::new).collect(
                        Collectors.toList()))), new LottoNumber(7)),
                new Ticket(Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::new).collect(
                    Collectors.toList())), 6
            ),
            Arguments.of(
                new WinningInfo(new WinningNumber(
                    new Ticket(Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::new).collect(
                        Collectors.toList()))), new LottoNumber(7)),
                new Ticket(Stream.of(7, 8, 9, 10, 11, 12).map(LottoNumber::new).collect(
                    Collectors.toList())), 0
            ),
            Arguments.of(
                new WinningInfo(new WinningNumber(
                    new Ticket(Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::new).collect(
                        Collectors.toList()))), new LottoNumber(7)),
                new Ticket(Stream.of(7, 8, 9, 1, 2, 3).map(LottoNumber::new).collect(
                    Collectors.toList())), 3
            )
        );
    }

    @DisplayName("로또 번호와 보너스 볼 일치 테스트")
    @ParameterizedTest
    @MethodSource("provideMatchBonusTest")
    void matchBonusTest(WinningInfo winningInfo, Ticket ticket, boolean expected) {
        assertEquals(expected, winningInfo.matchBonus(ticket));
    }

    private static Stream<Arguments> provideMatchBonusTest() {
        return Stream.of(
            Arguments.of(
                new WinningInfo(new WinningNumber(
                    new Ticket(Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::new).collect(
                        Collectors.toList()))), new LottoNumber(7)),
                new Ticket(Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::new).collect(
                    Collectors.toList())), false
            ),
            Arguments.of(
                new WinningInfo(new WinningNumber(
                    new Ticket(Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::new).collect(
                        Collectors.toList()))), new LottoNumber(7)),
                new Ticket(Stream.of(7, 8, 9, 10, 11, 12).map(LottoNumber::new).collect(
                    Collectors.toList())), true
            )
        );
    }
}