package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import lotto.enumeration.LottoReward;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoGameWinnerResultTest {

    @ParameterizedTest
    @MethodSource("provideRewardInfo")
    @DisplayName("당첨결과통계는 어떤 당첨이 있었느냐에 따라 상금,수익률이 변한다.")
    void change_result_by_reward(LottoReward reward, int expectedMoney, double expectedRate) {

        int playerTicketsCount = 1;

        LottoGameWinnerResult result = new LottoGameWinnerResult();
        result.updateResultInfo(reward, 1);

        assertThat(result.getHitCountByReward(reward)).isEqualTo(playerTicketsCount);
        assertThat(result.getRewardMoneySum()).isEqualTo(expectedMoney);
        assertThat(result.getProfitRate()).isEqualTo(expectedRate);
    }


    @ParameterizedTest
    @MethodSource("provideDifferentProfitRate")
    @DisplayName("같은 당첨결과라도 사용자의 로또시도회수에따라 수익률이 달라진다.")
    void change_result_by_ticket_count(LottoReward reward, int playerTicketsCount,
        double expectedRate) {

        LottoGameWinnerResult result = new LottoGameWinnerResult();
        result.updateResultInfo(reward, playerTicketsCount);

        assertThat(result.getProfitRate()).isEqualTo(expectedRate);
    }


    private static Stream<Arguments> provideRewardInfo() {

        return Stream.of(
            Arguments.of(LottoReward.THREE_NUMBERS_MATCHED_REWARD,
                LottoReward.THREE_NUMBERS_MATCHED_REWARD.getRewardMoney(), 5.0),
            Arguments.of(LottoReward.FOUR_NUMBERS_MATCHED_REWARD,
                LottoReward.FOUR_NUMBERS_MATCHED_REWARD.getRewardMoney(), 50.0),
            Arguments.of(LottoReward.FIVE_NUMBERS_MATCHED_REWARD,
                LottoReward.FIVE_NUMBERS_MATCHED_REWARD.getRewardMoney(), 1500.0),
            Arguments.of(LottoReward.SIX_NUMBERS_MATCHED_REWARD,
                LottoReward.SIX_NUMBERS_MATCHED_REWARD.getRewardMoney(), 2000000.0),
            Arguments.of(LottoReward.NO_REWARD,
                LottoReward.NO_REWARD.getRewardMoney(), 0)
        );
    }


    private static Stream<Arguments> provideDifferentProfitRate() {

        return Stream.of(
            Arguments.of(LottoReward.SIX_NUMBERS_MATCHED_REWARD,
                1, 2000000.0),
            Arguments.of(LottoReward.SIX_NUMBERS_MATCHED_REWARD,
                2, 1000000.0),
            Arguments.of(LottoReward.SIX_NUMBERS_MATCHED_REWARD,
                50, 40000.0),
            Arguments.of(LottoReward.SIX_NUMBERS_MATCHED_REWARD,
                1000, 2000.0),
            Arguments.of(LottoReward.SIX_NUMBERS_MATCHED_REWARD,
                20000, 100.0)
        );
    }

}