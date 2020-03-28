package LottoTests;

import lotto.utils.LottoNumberAdaptor;
import lotto.model.WinningLottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("당첨 로또 번호 테스트")
public class WinningLottoTicketTests {

    @DisplayName("당첨 로또 생성 테스트")
    @ParameterizedTest
    @MethodSource("generateWinningLottoTestCases")
    public void generateWinningLottoTest(List<Integer> numbers) {
        assertThatCode(() -> WinningLottoTicket.newInstance(LottoNumberAdaptor.convert(numbers))).doesNotThrowAnyException();
    }

    @DisplayName("당첨 로또 생성 오류 테스트")
    @ParameterizedTest
    @NullAndEmptySource
    @MethodSource("generateWinningLottoExceptionTestCases")
    public void generateLottoExceptionTest(List<Integer> numbers) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> WinningLottoTicket.newInstance(LottoNumberAdaptor.convert(numbers)))
                .withMessageContaining("Lotto Ticket must have six distinct number.");
    }

    private static Stream<Arguments> generateWinningLottoTestCases() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
                Arguments.of(Arrays.asList(10, 20, 30, 40, 41, 42))
        );
    }

    private static Stream<Arguments> generateWinningLottoExceptionTestCases() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7)),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 60)),
                Arguments.of(Arrays.asList(-1, 2, 3, 0, 5, 6))
        );
    }
}
