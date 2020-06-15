package dev.dahye.lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("Lotto의 결과를 출력하는 객체")
class LottoResultTest {
    private static Winning winning;

    @BeforeEach
    void setup() {
        LottoTicket winningTicket = LottoTicket.manualIssued(Arrays.asList(1, 2, 3, 4, 5, 6));
        winning = Winning.of(winningTicket, LottoNumber.of(8));
    }

    @ParameterizedTest(name = "입력 값 = {0}, 예상 결과 = {1}")
    @MethodSource("ranks")
    @DisplayName("당첨 번호를 입력하면 당첨 여부를 알 수 있다.")
    void getResult_myRanks(LottoTicket winningNumbers, int bonusNumber, Rank rank) {
        LottoTickets manualLottoTickets
                = LottoTickets.manualIssued(Arrays.asList(LottoTicket.manualIssued(Arrays.asList(1, 2, 3, 4, 5, 6))));

        LottoResult lottoResult = new LottoResult(manualLottoTickets, Winning.of(winningNumbers, LottoNumber.of(bonusNumber)));
        assertThat(lottoResult.getMyRanks().get(0)).isEqualTo(rank);
    }

    private static Stream<Arguments> ranks() {
        return Stream.of(
                arguments(LottoTicket.manualIssued(Arrays.asList(1, 2, 3, 23, 24, 25)), 45, Rank.FIFTH),
                arguments(LottoTicket.manualIssued(Arrays.asList(1, 2, 3, 4, 25, 26)), 45, Rank.FOURTH),
                arguments(LottoTicket.manualIssued(Arrays.asList(1, 2, 3, 4, 5, 26)), 45, Rank.THIRD),
                arguments(LottoTicket.manualIssued(Arrays.asList(1, 2, 3, 4, 5, 26)), 6, Rank.SECOND),
                arguments(LottoTicket.manualIssued(Arrays.asList(1, 2, 3, 4, 5, 6)), 45, Rank.FIRST)
        );
    }

    @ParameterizedTest
    @MethodSource("lottoRates")
    @DisplayName("로또 수익률을 구할 수 있다.")
    void lotto_winning_rate(LottoTickets lottoTickets, LottoMoney totalPrize) {
        LottoMoney lottoMoney = new LottoMoney(2000);
        LottoResult lottoResult = new LottoResult(lottoTickets, winning);

        BigDecimal expectedResult = lottoMoney.divideBy(totalPrize);
        assertThat(lottoResult.getMyWinningRate(lottoMoney)).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> lottoRates() {
        return Stream.of(
                arguments(
                        LottoTickets.manualIssued(Arrays.asList(
                                LottoTicket.manualIssued(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                LottoTicket.manualIssued(Arrays.asList(1, 2, 3, 4, 5, 7))
                        )),
                        new LottoMoney(Rank.FIRST.getPrize() + Rank.THIRD.getPrize())),
                arguments(
                        LottoTickets.manualIssued(Arrays.asList(
                                LottoTicket.manualIssued(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                LottoTicket.manualIssued(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                LottoTicket.manualIssued(Arrays.asList(1, 2, 3, 4, 5, 6))
                        )),
                        new LottoMoney(Rank.FIRST.getPrize() + Rank.FIRST.getPrize() + Rank.FIRST.getPrize()))
        );
    }

    @Test
    @DisplayName("당첨율 구하기")
    void winning_rate() {
        LottoMoney lottoMoney = new LottoMoney(14000);
        LottoMoney totalPrize = new LottoMoney(5000);

        assertThat(lottoMoney.divideBy(totalPrize)).isEqualTo(new BigDecimal("0.36"));
    }

    @ParameterizedTest
    @MethodSource("nullCases")
    @DisplayName("로또 티켓이 없는 경우 LottoTickets를 생성할 수 없다.")
    void exception_lottoMoney_is_null(LottoTickets lottoTickets, Winning winning, String expected) {
        assertThatThrownBy(() -> new LottoResult(lottoTickets, winning))
                .isInstanceOf(NullPointerException.class)
                .hasMessage(expected + " must not be null");
    }

    private static Stream<Arguments> nullCases() {
        return Stream.of(
                arguments(null, winning, "lottoTickets"),
                arguments(LottoTickets.autoIssued(1), null, "winning")
        );
    }
}