package lottotests;

import lotto.model.WinningLottoTicket;
import lotto.model.wrapper.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("당첨 로또 번호 테스트")
public class WinningLottoTicketTests {

    @DisplayName("당첨 로또 생성 테스트")
    @ParameterizedTest
    @MethodSource("generateWinningLottoTestCases")
    public void generateWinningLottoTest(Set<LottoNumber> numbers, LottoNumber bonusNumber) {
        assertThatCode(() -> WinningLottoTicket.newInstance(numbers, bonusNumber)).doesNotThrowAnyException();
    }

    @DisplayName("당첨 로또 생성 오류 테스트")
    @ParameterizedTest
    @MethodSource("generateWinningLottoExceptionTestCases")
    public void generateLottoExceptionTest(Set<LottoNumber> numbers, LottoNumber bonusNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> WinningLottoTicket.newInstance(numbers, bonusNumber))
                .withMessageContaining("Lotto Ticket must have six distinct number.");
    }

    @DisplayName("당첨 로또 생성 오류 - 보너스 번호 테스트")
    @ParameterizedTest
    @MethodSource("winningLottoBonusNumberExceptionTestCases")
    public void generateLottoExceptionWinningNumberTest(Set<LottoNumber> numbers, LottoNumber bonusNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> WinningLottoTicket.newInstance(numbers, bonusNumber))
                .withMessageContaining("bonus number must be distinct.");
    }

    private static Stream<Arguments> generateWinningLottoTestCases() {
        return Stream.of(
                Arguments.of(new HashSet<>(Arrays.asList(
                        LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                        LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6))),
                        LottoNumber.of(7)),
                Arguments.of(new HashSet<>(Arrays.asList(
                        LottoNumber.of(10), LottoNumber.of(20), LottoNumber.of(30),
                        LottoNumber.of(40), LottoNumber.of(41), LottoNumber.of(42))),
                        LottoNumber.of(45))
        );
    }

    private static Stream<Arguments> generateWinningLottoExceptionTestCases() {
        return Stream.of(
                Arguments.of(new HashSet<>(Arrays.asList(
                        LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                        LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6), LottoNumber.of(7))),
                        LottoNumber.of(9)),
                Arguments.of(new HashSet<>(Arrays.asList(
                        LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                        LottoNumber.of(4), LottoNumber.of(5))),
                        LottoNumber.of(11))
        );
    }

    private static Stream<Arguments> winningLottoBonusNumberExceptionTestCases() {
        return Stream.of(
                Arguments.of(new HashSet<>(Arrays.asList(
                        LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                        LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6))),
                        LottoNumber.of(6)),
                Arguments.of(new HashSet<>(Arrays.asList(
                        LottoNumber.of(10), LottoNumber.of(20), LottoNumber.of(30),
                        LottoNumber.of(40), LottoNumber.of(41), LottoNumber.of(42))),
                        LottoNumber.of(42))
        );
    }
}
