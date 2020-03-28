package LottoTests;

import lotto.model.LottoPurchaseTicket;
import lotto.model.LottoResult;
import lotto.model.WinningLottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

@DisplayName("로또 한장 테스트")
public class LottoPurchaseTicketTests {

    @DisplayName("로또 생성 테스트")
    @Test
    public void generateLottoTest() {
        assertThatCode(LottoPurchaseTicket::newInstance).doesNotThrowAnyException();
    }

    @DisplayName("로또 생성 번호 테스트")
    @Test
    public void generateLottoNumberTest() {
        LottoPurchaseTicket lottoPurchaseTicket = LottoPurchaseTicket.newInstance();
        assertThat(lottoPurchaseTicket.toArray())
                .hasSize(6)
                .allMatch(number -> number >= 1 && number <= 45);
    }

    @DisplayName("로또 생성 오류 테스트")
    @ParameterizedTest
    @NullAndEmptySource
    @MethodSource("generateLottoExceptionTestCases")
    public void generateLottoExceptionTest(List<Integer> numbers) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoPurchaseTicket.newInstance(numbers))
                .withMessageContaining("Lotto Ticket must have six distinct number.");
    }

    @DisplayName("로또 결과 확인 테스트")
    @ParameterizedTest
    @MethodSource("checkLottoTicketTestCases")
    public void checkLottoTicketTest(LottoPurchaseTicket lottoPurchaseTicket, WinningLottoTicket winningLottoTicket, LottoResult lottoResult) {
        assertThat(lottoPurchaseTicket.check(winningLottoTicket)).isEqualTo(lottoResult);
    }

    private static Stream<Arguments> generateLottoExceptionTestCases() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7)),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 60)),
                Arguments.of(Arrays.asList(-1, 2, 3, 0, 5, 6))
        );
    }

    private static Stream<Arguments> checkLottoTicketTestCases() {
        LottoPurchaseTicket lottoPurchaseTicket = LottoPurchaseTicket.newInstance(Arrays.asList(1, 2, 3, 4, 5, 6));
        return Stream.of(
                Arguments.of(lottoPurchaseTicket, WinningLottoTicket.newInstance(Arrays.asList(1, 2, 3, 4, 5, 6)), LottoResult.SIX),
                Arguments.of(lottoPurchaseTicket, WinningLottoTicket.newInstance(Arrays.asList(1, 2, 3, 4, 5, 7)), LottoResult.FIVE),
                Arguments.of(lottoPurchaseTicket, WinningLottoTicket.newInstance(Arrays.asList(1, 2, 3, 4, 8, 7)), LottoResult.FOUR),
                Arguments.of(lottoPurchaseTicket, WinningLottoTicket.newInstance(Arrays.asList(1, 2, 3, 9, 8, 7)), LottoResult.THREE),
                Arguments.of(lottoPurchaseTicket, WinningLottoTicket.newInstance(Arrays.asList(1, 2, 10, 9, 8, 7)), LottoResult.TWO),
                Arguments.of(lottoPurchaseTicket, WinningLottoTicket.newInstance(Arrays.asList(1, 11, 10, 12, 13, 14)), LottoResult.ONE),
                Arguments.of(lottoPurchaseTicket, WinningLottoTicket.newInstance(Arrays.asList(7, 8, 9, 10, 11, 12)), LottoResult.NONE)
        );
    }

}
