package lotto.model;

import lotto.model.wrapper.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

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
                .withMessageContaining("로또는 서로 다른 6개의 숫자여야 합니다.");
    }

    @DisplayName("당첨 로또 생성 오류 - 보너스 번호 테스트")
    @ParameterizedTest
    @MethodSource("winningLottoBonusNumberExceptionTestCases")
    public void generateLottoExceptionWinningNumberTest(Set<LottoNumber> numbers, LottoNumber bonusNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> WinningLottoTicket.newInstance(numbers, bonusNumber))
                .withMessageContaining("보너스 숫자는 당첨 번호와 일치하면 안됩니다.");
    }

    @DisplayName("로또 결과 확인 테스트")
    @ParameterizedTest
    @MethodSource("checkLottoTicketTestCases")
    public void checkLottoTicketTest(LottoTicket lottoTicket, WinningLottoTicket winningLottoTicket, LottoResult lottoResult) {
        assertThat(winningLottoTicket.check(lottoTicket)).isEqualTo(lottoResult);
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


    private static Stream<Arguments> checkLottoTicketTestCases() {
        LottoTicket lottoTicket = LottoTicket.newInstance(convertToLottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
        return Stream.of(
                Arguments.of(
                        lottoTicket,
                        WinningLottoTicket.newInstance(convertToLottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)), LottoNumber.of(7)),
                        LottoResult.SIX),
                Arguments.of(
                        lottoTicket,
                        WinningLottoTicket.newInstance(convertToLottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 7)), LottoNumber.of(8)),
                        LottoResult.FIVE),
                Arguments.of(
                        lottoTicket,
                        WinningLottoTicket.newInstance(convertToLottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 7)), LottoNumber.of(6)),
                        LottoResult.FIVE_WITH_BONUS),
                Arguments.of(
                        lottoTicket,
                        WinningLottoTicket.newInstance(convertToLottoNumbers(Arrays.asList(1, 2, 3, 4, 8, 7)), LottoNumber.of(24)),
                        LottoResult.FOUR),
                Arguments.of(
                        lottoTicket,
                        WinningLottoTicket.newInstance(convertToLottoNumbers(Arrays.asList(1, 2, 3, 9, 8, 7)), LottoNumber.of(24)),
                        LottoResult.THREE),
                Arguments.of(
                        lottoTicket,
                        WinningLottoTicket.newInstance(convertToLottoNumbers(Arrays.asList(1, 2, 10, 9, 8, 7)), LottoNumber.of(24)),
                        LottoResult.TWO),
                Arguments.of(
                        lottoTicket,
                        WinningLottoTicket.newInstance(convertToLottoNumbers(Arrays.asList(1, 11, 10, 12, 13, 14)), LottoNumber.of(24)),
                        LottoResult.ONE),
                Arguments.of(
                        lottoTicket,
                        WinningLottoTicket.newInstance(convertToLottoNumbers(Arrays.asList(7, 8, 9, 10, 11, 12)), LottoNumber.of(24)),
                        LottoResult.NONE)
        );
    }

    private static Set<LottoNumber> convertToLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toSet());
    }
}
