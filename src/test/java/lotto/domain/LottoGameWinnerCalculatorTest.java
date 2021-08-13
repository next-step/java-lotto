package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.enumeration.LottoReward;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoGameWinnerCalculatorTest {

    private static LottoGameWinnerCalculator winnerCalculator;

    @BeforeAll
    static void generateWinnerCalculator() {
        int[] winnerNumbers = {1, 2, 3, 4, 5, 6};
        int bonusBallNumber = 7;

        WinnerNumberInfo winnerNumberInfo = new WinnerNumberInfo(winnerNumbers, bonusBallNumber);
        winnerCalculator = new LottoGameWinnerCalculator(winnerNumberInfo);
    }


    @ParameterizedTest
    @MethodSource("generatePlayerTicketsAndReward")
    @DisplayName("당첨번호티켓과 일치하는 번호개수에 따라 당첨금이 달라진다.")
    void check_reward_money(List<LottoTicket> playerTickets, LottoReward reward) {
        LottoGameWinnerResult result = winnerCalculator.calculate(playerTickets);
        assertThat(result.getRewardMoneySum()).isEqualTo(reward.getRewardMoney());
    }

    @ParameterizedTest
    @MethodSource("generatePlayerTicketsAndProfitRate")
    @DisplayName("당첨번호티켓과 일치하는 번호개수에 따라 수익률이 달라진다.")
    void check_profit_ratio(List<LottoTicket> playerTickets, double profitRate) {
        LottoGameWinnerResult result = winnerCalculator.calculate(playerTickets);
        assertThat(result.getProfitRate()).isEqualTo(profitRate);
    }


    @ParameterizedTest
    @MethodSource("generatePlayerTicketsAndReward")
    @DisplayName("당첨 결과에 있어서 각 일치개수도  몇번일어났는지 기록한다.")
    void check_reward_hit_count(List<LottoTicket> playerTickets, LottoReward reward) {
        LottoGameWinnerResult result = winnerCalculator.calculate(playerTickets);
        assertThat(result.getHitCountByReward(reward)).isEqualTo(1);
    }

    private static Stream<Arguments> generatePlayerTicketsAndReward() {

        return Stream.of(
            Arguments.of(makeThreeNumberMatched(), LottoReward.THREE_NUMBERS_MATCHED),
            Arguments.of(makeFourNumberMatched(), LottoReward.FOUR_NUMBERS_MATCHED),
            Arguments.of(makeFiveNumberMatched(), LottoReward.FIVE_NUMBERS_MATCHED),
            Arguments.of(makeFiveNumberAndBonusNumberMatched(),
                LottoReward.FIVE_NUMBERS_AND_BONUS_NUMBER_MATCHED),
            Arguments.of(makeSixNumberMatched(), LottoReward.SIX_NUMBERS_MATCHED),
            Arguments.of(makeNoMatched(), LottoReward.NO_MATCHED)
        );

    }


    private static Stream<Arguments> generatePlayerTicketsAndProfitRate() {

        return Stream.of(
            Arguments.of(makeThreeNumberMatched(), 5.0),
            Arguments.of(makeFourNumberMatched(), 50.0),
            Arguments.of(makeFiveNumberMatched(), 1_500.0),
            Arguments.of(makeSixNumberMatched(), 2_000_000.0),
            Arguments.of(makeNoMatched(), 0)
        );

    }

    private static List<LottoTicket> makeThreeNumberMatched() {

        return new ArrayList<>(Arrays.asList(
            LottoTicket.generateByIntegerArray(1, 2, 3, 12, 13, 14)
        ));
    }

    private static List<LottoTicket> makeFourNumberMatched() {
        return new ArrayList<>(Arrays.asList(
            LottoTicket.generateByIntegerArray(1, 2, 3, 4, 13, 14)
        ));
    }

    private static List<LottoTicket> makeFiveNumberMatched() {
        return new ArrayList<>(Arrays.asList(
            LottoTicket.generateByIntegerArray(1, 2, 3, 4, 5, 14)
        ));
    }

    private static List<LottoTicket> makeFiveNumberAndBonusNumberMatched() {
        return new ArrayList<>(Arrays.asList(
            LottoTicket.generateByIntegerArray(1, 2, 3, 4, 5, 7)
        ));
    }

    private static List<LottoTicket> makeSixNumberMatched() {
        return new ArrayList<>(Arrays.asList(
            LottoTicket.generateByIntegerArray(1, 2, 3, 4, 5, 6)
        ));
    }

    private static List<LottoTicket> makeNoMatched() {
        return new ArrayList<>(Arrays.asList(
            LottoTicket.generateByIntegerArray(11, 12, 13, 14, 15, 16)
        ));
    }
}