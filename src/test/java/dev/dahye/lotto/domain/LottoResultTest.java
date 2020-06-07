package dev.dahye.lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("Lotto의 결과를 출력하는 객체")
class LottoResultTest {
    private static LottoTickets autoLottoTickets;
    private static final int BONUS_NUMBER = 1;

    @BeforeEach
    void setUp() {
        autoLottoTickets = LottoTickets.autoIssued(1);
    }

    @ParameterizedTest(name = "입력 값 = {0}")
    @MethodSource("winningNumbers")
    @DisplayName("당첨 번호가 6자리가 아닌 경우 IllegalArguments exception throw")
    void winningNumbers_must_be_six_numbers(List<Integer> winningNumbers) {
        assertThatThrownBy(() -> new LottoResult(autoLottoTickets, winningNumbers, BONUS_NUMBER))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 티켓은 6자리 숫자여야 합니다.");
    }

    private static Stream<Arguments> winningNumbers() {
        return Stream.of(
                arguments(Arrays.asList(1, 2, 3, 4, 5)),
                arguments(Arrays.asList(1, 2, 3, 4, 5, 6, 7))
        );
    }

    @ParameterizedTest(name = "입력 값 = {0}")
    @ValueSource(ints = {0, 46})
    @DisplayName("당첨 번호가 범위에 벗어난 경우 IllegalArguments exception throw")
    void validate_winningNumbers(int invalidNumber) {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, invalidNumber);

        assertThatThrownBy(() -> new LottoResult(autoLottoTickets, winningNumbers, BONUS_NUMBER))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1 ~ 45의 숫자만 가능합니다.");
    }

    @ParameterizedTest(name = "입력 값 = {0}, 예상 결과 = {1}")
    @MethodSource("ranks")
    @DisplayName("당첨 번호를 입력하면 당첨 여부를 알 수 있다.")
    void getResult_myRanks(List<Integer> winningNumbers, int bonusNumber, Rank rank) {
        LottoTickets manualLottoTickets
                = LottoTickets.manualIssued(Arrays.asList(LottoTicket.manualIssued(Arrays.asList(1, 2, 3, 4, 5, 6))));

        LottoResult lottoResult = new LottoResult(manualLottoTickets, winningNumbers, bonusNumber);
        assertThat(lottoResult.getMyRanks().get(0)).isEqualTo(rank);
    }

    private static Stream<Arguments> ranks() {
        return Stream.of(
                arguments(Arrays.asList(1, 2, 3, 23, 24, 25), 45, Rank.FIFTH),
                arguments(Arrays.asList(1, 2, 3, 4, 25, 26), 45, Rank.FOURTH),
                arguments(Arrays.asList(1, 2, 3, 4, 5, 26), 45, Rank.THIRD),
                arguments(Arrays.asList(1, 2, 3, 4, 5, 26), 6, Rank.SECOND),
                arguments(Arrays.asList(1, 2, 3, 4, 5, 6), 45, Rank.FIRST)
        );
    }

    @Test
    @DisplayName("로또 수익률을 구할 수 있다.")
    void lotto_winning_rate() {
        int myMoney = 2000;
        LottoTicket lottoTicketByRankFirst = LottoTicket.manualIssued(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoTicket lottoTicketByRankThird = LottoTicket.manualIssued(Arrays.asList(1, 2, 3, 4, 5, 7));
        LottoTickets lottoTickets = LottoTickets.manualIssued(Arrays.asList(lottoTicketByRankFirst, lottoTicketByRankThird));

        LottoResult lottoResult = new LottoResult(lottoTickets, Arrays.asList(1, 2, 3, 4, 5, 6), 8);

        int totalPrize = Rank.FIRST.getPrize() + Rank.THIRD.getPrize();
        double expectedResult = LottoResult.divideTotalPrizeByMoney(totalPrize, myMoney);
        assertThat(lottoResult.getMyWinningRate(myMoney)).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("당첨율 구하기")
    void winning_rate() {
        assertThat(LottoResult.divideTotalPrizeByMoney(5000, 14000)).isEqualTo(0.36);
    }
}