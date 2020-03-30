package lotto_tests;

import lotto.model.WinningLottoTicket;
import lotto.model.wrapper.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

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
    public void generateWinningLottoTest(Set<LottoNumber> numbers) {
        assertThatCode(() -> WinningLottoTicket.newInstance(numbers)).doesNotThrowAnyException();
    }

    @DisplayName("당첨 로또 생성 오류 테스트")
    @ParameterizedTest
    @NullAndEmptySource
    @MethodSource("generateWinningLottoExceptionTestCases")
    public void generateLottoExceptionTest(Set<LottoNumber> numbers) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> WinningLottoTicket.newInstance(numbers))
                .withMessageContaining("Lotto Ticket must have six distinct number.");
    }

    private static Stream<Arguments> generateWinningLottoTestCases() {
        return Stream.of(
                Arguments.of(new HashSet<>(Arrays.asList(
                        LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                        LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6)))),
                Arguments.of(new HashSet<>(Arrays.asList(
                        LottoNumber.of(10), LottoNumber.of(20), LottoNumber.of(30),
                        LottoNumber.of(40), LottoNumber.of(41), LottoNumber.of(42))))
        );
    }

    private static Stream<Arguments> generateWinningLottoExceptionTestCases() {
        return Stream.of(
                Arguments.of(new HashSet<>(Arrays.asList(
                        LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                        LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6), LottoNumber.of(7)))),
                Arguments.of(new HashSet<>(Arrays.asList(
                        LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                        LottoNumber.of(4), LottoNumber.of(5))))
        );
    }
}
