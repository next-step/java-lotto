package step2.model;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningLottoTicketTest {

    @DisplayName("당첨 로또 생성 테스트")
    @ParameterizedTest
    @MethodSource("createWinningLottoTestCases")
    public void generateLottoTest(List<Integer> numbers, int bonusLottoNumber) {
        assertThatCode(() -> WinningLottoTicket.createBy(numbers, LottoNumber.of(bonusLottoNumber))).doesNotThrowAnyException();
    }

    private static Stream<Arguments> createWinningLottoTestCases() {
        return Stream.of(
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7)),
            Arguments.of(Arrays.asList(10, 20, 30, 40, 41, 45, 7))
        );
    }

    @DisplayName("당첨 로또 생성 오류 테스트")
    @ParameterizedTest
    @MethodSource("createWinningLottoExceptionTestCases")
    public void createWinningLottoExceptionTest(List<Integer> numbers, int bonusLottoNumber) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> WinningLottoTicket.createBy(numbers, LottoNumber.of(bonusLottoNumber)))
            .withMessageContaining("로또의 수 범위는 1 ~ 45 까지의 입니다.");
    }

    private static Stream<Arguments> createWinningLottoExceptionTestCases() {
        return Stream.of(
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 70, 9)),
            Arguments.of(Arrays.asList(-10, 2, 3, 9, 5, 6, 10))
        );
    }
}