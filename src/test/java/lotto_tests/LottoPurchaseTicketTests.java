package lotto_tests;

import lotto.model.LottoPurchaseTicket;
import lotto.model.LottoResult;
import lotto.model.WinningLottoTicket;
import lotto.model.wrapper.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static lotto.model.LottoTicket.LOTTO_NUMBER_SIZE;
import static lotto.model.wrapper.LottoNumber.LOTTO_MAX_NUMBER;
import static lotto.model.wrapper.LottoNumber.LOTTO_MIN_NUMBER;
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
        assertThat(lottoPurchaseTicket.getNumbers())
                .hasSize(LOTTO_NUMBER_SIZE)
                .allMatch(number -> number.toInt() >= LOTTO_MIN_NUMBER && number.toInt() <= LOTTO_MAX_NUMBER);
    }

    @DisplayName("로또 생성 오류 테스트")
    @ParameterizedTest
    @NullAndEmptySource
    @MethodSource("generateLottoExceptionTestCases")
    public void generateLottoExceptionTest(Set<LottoNumber> numbers) {
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
                Arguments.of(new HashSet<>(Arrays.asList(
                        LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                        LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6), LottoNumber.of(7)))),
                Arguments.of(new HashSet<>(Arrays.asList(
                        LottoNumber.of(1), LottoNumber.of(2),
                        LottoNumber.of(3), LottoNumber.of(4))))
        );
    }

    private static Stream<Arguments> checkLottoTicketTestCases() {
        LottoPurchaseTicket lottoPurchaseTicket = LottoPurchaseTicket.create(
                LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6)
        );
        return Stream.of(
                Arguments.of(
                        lottoPurchaseTicket,
                        WinningLottoTicket.create(
                                LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                                LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6)),
                        LottoResult.SIX),
                Arguments.of(
                        lottoPurchaseTicket,
                        WinningLottoTicket.create(
                                LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                                LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(7)),
                        LottoResult.FIVE),
                Arguments.of(
                        lottoPurchaseTicket,
                        WinningLottoTicket.create(
                                LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                                LottoNumber.of(4), LottoNumber.of(8), LottoNumber.of(7)),
                        LottoResult.FOUR),
                Arguments.of(
                        lottoPurchaseTicket,
                        WinningLottoTicket.create(
                                LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                                LottoNumber.of(9), LottoNumber.of(8), LottoNumber.of(7)),
                        LottoResult.THREE),
                Arguments.of(
                        lottoPurchaseTicket,
                        WinningLottoTicket.create(
                                LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(10),
                                LottoNumber.of(9), LottoNumber.of(8), LottoNumber.of(7)),
                        LottoResult.TWO),
                Arguments.of(
                        lottoPurchaseTicket,
                        WinningLottoTicket.create(
                                LottoNumber.of(1), LottoNumber.of(11), LottoNumber.of(10),
                                LottoNumber.of(12), LottoNumber.of(13), LottoNumber.of(14)),
                        LottoResult.ONE),
                Arguments.of(
                        lottoPurchaseTicket,
                        WinningLottoTicket.create(
                                LottoNumber.of(7), LottoNumber.of(8), LottoNumber.of(9),
                                LottoNumber.of(10), LottoNumber.of(11), LottoNumber.of(12)),
                        LottoResult.NONE)
        );
    }
}
