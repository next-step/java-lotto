package dev.dahye.lotto.domain;

import dev.dahye.lotto.util.DoubleUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("Lotto의 결과를 출력하는 객체")
class LottoResultTest {
    private List<LottoTicket> autoLottoTickets;

    @BeforeEach
    void setUp() {
        autoLottoTickets = Collections.singletonList(LottoTicket.autoIssued());
    }

    @ParameterizedTest(name = "입력 값 = {0}")
    @NullAndEmptySource
    @DisplayName("당첨 숫자가 null이거나 빈 값인 경우 IllegalArguments exception throw")
    void winningNumbers_must_not_be_null_or_empty(String winningNumbers) {
        assertThrows(IllegalArgumentException.class, () -> new LottoResult(autoLottoTickets, winningNumbers),
                "당첨 번호는 반드시 입력되어야 합니다.");
    }

    @ParameterizedTest(name = "입력 값 = {0}")
    @ValueSource(strings = {"1, 2, 3, 4, 5"})
    @DisplayName("당첨 숫자가 6자리가 아닌 경우 IllegalArguments exception throw")
    void winningNumbers_must_be_six_numbers(String winningNumbers) {
        assertThrows(IllegalArgumentException.class, () -> new LottoResult(autoLottoTickets, winningNumbers),
                "당첨 번호는 6자리 숫자여야 합니다.");
    }

    @ParameterizedTest(name = "입력 값 = {0}, 예상 결과 = {1}")
    @MethodSource("winnings")
    @DisplayName("당첨 번호를 입력하면 당첨 여부를 알 수 있다.")
    void getResult_myWinnings(String winningNumbers, Winning winning) {
        List<LottoTicket> manualLottoTickets
                = Collections.singletonList(LottoTicket.manualIssued(Arrays.asList(1, 2, 3, 4, 5, 6)));

        LottoResult lottoResult = new LottoResult(manualLottoTickets, winningNumbers);
        assertThat(lottoResult.getMyWinnings().get(0)).isEqualTo(winning);
    }

    private static Stream<Arguments> winnings() {
        return Stream.of(
                arguments("1, 2, 3, 23, 24, 25", Winning.FOURTH),
                arguments("1, 2, 3, 4, 25, 26", Winning.THIRD),
                arguments("1, 2, 3, 4, 5, 26", Winning.SECOND),
                arguments("1, 2, 3, 4, 5, 6", Winning.FIRST)
        );
    }

    @Test
    @DisplayName("로또 수익률을 구할 수 있다.")
    void lotto_winning_rate() {
        int myMoney = 2000;
        LottoTicket lottoTicketByWinningFirst = LottoTicket.manualIssued(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoTicket lottoTicketByWinningSecond = LottoTicket.manualIssued(Arrays.asList(1, 2, 3, 4, 5, 7));

        LottoResult lottoResult = new LottoResult(Arrays.asList(
                lottoTicketByWinningFirst,
                lottoTicketByWinningSecond
        ), "1, 2, 3, 4, 5, 6");

        double expectedResult
                = DoubleUtils.parseDoubleSecondDigit((Winning.FIRST.getPrize() + Winning.SECOND.getPrize()) / myMoney);
        assertThat(lottoResult.getMyWinningRate(myMoney)).isEqualTo(expectedResult);
    }
}