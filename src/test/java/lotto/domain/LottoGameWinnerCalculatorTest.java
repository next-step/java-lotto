package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.enumeration.LottoReward;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoGameWinnerCalculatorTest {

    @ParameterizedTest
    @MethodSource("generatePlayerTicketsAndReward")
    @DisplayName("당첨번호티켓과 일치하는 번호개수에 따라 당첨금이 달라진다.")
    void check_reward_money(List<LottoTicket> playerTickets, LottoReward reward) {
        LottoGameWinnerCalculator winnerCalculator = new LottoGameWinnerCalculator();

        LottoTicket winnerTicket = makeWinnerTicket();

        LottoGameWinnerResult result = winnerCalculator.calculate(playerTickets, winnerTicket);
        assertThat(result.getRewardMoneySum()).isEqualTo(reward.getRewardMoney());
    }

    @ParameterizedTest
    @MethodSource("generatePlayerTicketsAndProfitRate")
    @DisplayName("당첨번호티켓과 일치하는 번호개수에 따라 수익률이 달라진다.")
    void check_profit_ratio(List<LottoTicket> playerTickets, double profitRate) {
        LottoGameWinnerCalculator winnerCalculator = new LottoGameWinnerCalculator();

        LottoTicket winnerTicket = makeWinnerTicket();

        LottoGameWinnerResult result = winnerCalculator.calculate(playerTickets, winnerTicket);
        assertThat(result.getProfitRate()).isEqualTo(profitRate);
    }


    @ParameterizedTest
    @MethodSource("generatePlayerTicketsAndReward")
    @DisplayName("당첨 결과에 있어서 각 일치개수도  몇번일어났는지 기록한다.")
    void check_reward_hit_count(List<LottoTicket> playerTickets, LottoReward reward) {
        LottoGameWinnerCalculator winnerCalculator = new LottoGameWinnerCalculator();

        LottoTicket winnerTicket = makeWinnerTicket();

        LottoGameWinnerResult result = winnerCalculator.calculate(playerTickets, winnerTicket);
        assertThat(result.getHitCountByReward(reward)).isEqualTo(1);
    }


    private LottoTicket makeWinnerTicket() {

        return new LottoTicket(Arrays.asList(
            new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
            new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));

    }

    private static Stream<Arguments> generatePlayerTicketsAndReward() {

        return Stream.of(
            Arguments.of(makeThreeNumberMatched(), LottoReward.THREE_NUMBERS_MATCHED_REWARD),
            Arguments.of(makeFourNumberMatched(), LottoReward.FOUR_NUMBERS_MATCHED_REWARD),
            Arguments.of(makeFiveNumberMatched(), LottoReward.FIVE_NUMBERS_MATCHED_REWARD),
            Arguments.of(makeSixNumberMatched(), LottoReward.SIX_NUMBERS_MATCHED_REWARD),
            Arguments.of(makeNoMatched(), LottoReward.NO_REWARD)
        );

    }


    private static Stream<Arguments> generatePlayerTicketsAndProfitRate() {

        return Stream.of(
            Arguments.of(makeThreeNumberMatched(), 5.0),
            Arguments.of(makeFourNumberMatched(), 50.0),
            Arguments.of(makeFiveNumberMatched(), 1500.0),
            Arguments.of(makeSixNumberMatched(), 2000000.0),
            Arguments.of(makeNoMatched(), 0)
        );

    }

    private static List<LottoTicket> makeThreeNumberMatched() {
        return new ArrayList<>(Arrays.asList(
            new LottoTicket(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(12), new LottoNumber(13), new LottoNumber(14)))
        ));
    }

    private static List<LottoTicket> makeFourNumberMatched() {
        return new ArrayList<>(Arrays.asList(
            new LottoTicket(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(13), new LottoNumber(14)))
        ));
    }

    private static List<LottoTicket> makeFiveNumberMatched() {
        return new ArrayList<>(Arrays.asList(
            new LottoTicket(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(14)))
        ));
    }

    private static List<LottoTicket> makeSixNumberMatched() {
        return new ArrayList<>(Arrays.asList(
            new LottoTicket(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)))
        ));
    }

    private static List<LottoTicket> makeNoMatched() {
        return new ArrayList<>(Arrays.asList(
            new LottoTicket(Arrays.asList(
                new LottoNumber(11), new LottoNumber(12), new LottoNumber(13),
                new LottoNumber(14), new LottoNumber(15), new LottoNumber(16)))
        ));
    }


}