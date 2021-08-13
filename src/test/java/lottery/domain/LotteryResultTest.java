package lottery.domain;

import lottery.dto.LotteryResultDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryResultTest {

    @ParameterizedTest(name = "getLotteryResult 꽝 테스트 | {arguments}")
    @ValueSource(ints = {0, 1, 2})
    public void getBlankLotteryResult(int score) {
        // given
        LotteryResult expected = LotteryResult.BLANK;

        // when
        LotteryResult lotteryResult = LotteryResult.getLotteryResult(score, false);

        // then
        assertThat(lotteryResult).isEqualTo(expected);
    }

    @Test
    @DisplayName("getLotteryResult 테스트")
    public void getLotteryResult() {
        // given
        int score = 3;
        LotteryResult expected = LotteryResult.THREE_MATCHES;

        // when
        LotteryResult lotteryResult = LotteryResult.getLotteryResult(score, false);

        // then
        assertThat(lotteryResult).isEqualTo(expected);
    }

    @Test
    @DisplayName("notBlank 테스트")
    public void notBlank() {
        // given
        LotteryResult lotteryResult = LotteryResult.SIX_MATCHES;
        boolean expected = true;

        // when
        boolean result = LotteryResult.notBlank(lotteryResult);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("getTotalCashPrize 테스트")
    public void getTotalCashPrize() {
        // given
        int count = 10;
        long expected = LotteryResult.FIVE_MATCHES.toDto(0)
                .getCashPrize()
                .multiply(count);

        // when
        long totalCashPrize = LotteryResult.FIVE_MATCHES.getTotalCashPrize(count);

        // then
        assertThat(totalCashPrize).isEqualTo(expected);
    }

    @Test
    @DisplayName("toDto 테스트")
    public void toDto() {
        // given
        int count = 10;
        LotteryResultDto expected = LotteryResult.FIVE_MATCHES.toDto(count);

        // when
        LotteryResultDto lotteryResultDto = LotteryResult.FIVE_MATCHES.toDto(count);

        // then
        assertThat(lotteryResultDto.getCount()).isEqualTo(expected.getCount());
        assertThat(lotteryResultDto.getExplanation()).isEqualTo(expected.getExplanation());
        assertThat(lotteryResultDto.getCashPrize()).isEqualTo(expected.getCashPrize());
    }

}