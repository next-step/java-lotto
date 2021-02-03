package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoMachineTest {

    private final LottoMachine lottoMachine = new LottoMachine();

    @DisplayName(" 당첨 번호가 올바른 경우 테스트")
    @ParameterizedTest
    @MethodSource("provideValidateWinningNumberTest")
    public void validateWinningNumberTest(String winningNumber,WinningNumber expected) {
        assertEquals(expected, new WinningNumber(lottoMachine.generateManualTicket(winningNumber)));
    }

    private static Stream<Arguments> provideValidateWinningNumberTest() {
        return Stream.of(
            Arguments.of("1, 2, 3, 4, 5, 6", new WinningNumber(new Ticket(
                Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::new).collect(Collectors.toList())
            ))),
            Arguments.of("1, 2, 3, 4, 5, 45", new WinningNumber(new Ticket(
                Stream.of(1, 2, 3, 4, 5, 45).map(LottoNumber::new).collect(Collectors.toList())
            )))
        );
    }

    @DisplayName(" 당첨 번호가 틀린 경우 테스트")
    @ParameterizedTest
    @MethodSource("provideValidateWinningNumberBadTest")
    public void validateWinningNumberBadTest(String winningNumber) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new WinningNumber(lottoMachine.generateManualTicket(winningNumber)));
    }

    private static Stream<Arguments> provideValidateWinningNumberBadTest() {
        return Stream.of(
            Arguments.of("1, 2, 3, 4, 5, 5"),
            Arguments.of("1, 2, 3, 4, dfsd, 45"),
            Arguments.of("1, 2, 3, 4, 5, 47"),
            Arguments.of("1, 2, 3, 4, 5, 6, 8"),
            Arguments.of("123456"),
            Arguments.of("asdfasdfasdf")
        );
    }
}
