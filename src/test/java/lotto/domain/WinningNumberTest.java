package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WinningNumberTest {

    @DisplayName("1-45에 해당하고 6자리인 WinningNumber 경우 객체가 생성됨")
    @ParameterizedTest
    @MethodSource("provideCheckWinningNumberGoodTest")
    void checkWinningNumberGoodTest(Ticket ticket) {
        WinningNumber winningNumber = new WinningNumber(ticket);
        assertEquals(winningNumber, new WinningNumber(ticket));
    }

    private static Stream<Arguments> provideCheckWinningNumberGoodTest() {
        return Stream.of(
            Arguments.of(new Ticket(
                Stream.of(1, 2, 3, 4, 5, 45).map(LottoNumber::new).collect(
                    Collectors.toList())))
        );
    }

    @DisplayName("1-45에 해당하지 않고 6자리가 아닌 WinningNumber 경우 예외가 남")
    @ParameterizedTest
    @MethodSource("provideCheckWinningNumberBadTest")
    void checkLottoNumberBadTest(Ticket ticket) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new WinningNumber(ticket));
    }

    private static Stream<Arguments> provideCheckWinningNumberBadTest() {
        return Stream.of(
            Arguments.of(new Ticket(
                Stream.of(1, 2, 3, 4, 5, 5).map(LottoNumber::new).collect(
                    Collectors.toList()))),
            Arguments.of(new Ticket(
                Stream.of(1,2,3,4,4,4,4,4).map(LottoNumber::new).collect(
                    Collectors.toList()))),
            Arguments.of(new Ticket(
                Stream.of(1, 2, 3, 4, 5, 6, 8).map(LottoNumber::new).collect(
                    Collectors.toList()))),
            Arguments.of(new Ticket(Stream.of(1,2,3,4,5,6,7,8,9,10).map(LottoNumber::new).collect(
                Collectors.toList()))),
            Arguments
                .of(new Ticket(Stream.of(1).map(LottoNumber::new).collect(
                    Collectors.toList())))
        );
    }
}
