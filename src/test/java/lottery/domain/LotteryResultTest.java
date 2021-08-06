package lottery.domain;

import lottery.domain.LotteryResult;
import lottery.dto.LotteryResultDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lottery.domain.LotteryResult.*;
import static org.assertj.core.api.Assertions.assertThat;

class LotteryResultTest {

    @ParameterizedTest(name = "getLotteryResult 꽝 테스트 | {arguments}")
    @ValueSource(ints = {0, 1, 2})
    public void getBlankLotteryResult(int score) {
        // given
        LotteryResult expected = BLANK;

        // when
        LotteryResult lotteryResult = LotteryResult.getLotteryResult(score);

        // then
        assertThat(lotteryResult).isEqualTo(expected);
    }

    @Test
    @DisplayName("getLotteryResult 테스트")
    public void getLotteryResult() {
        // given
        int score = 3;
        LotteryResult expected = THREE_MATCHES;

        // when
        LotteryResult lotteryResult = LotteryResult.getLotteryResult(score);

        // then
        assertThat(lotteryResult).isEqualTo(expected);
    }

    @Test
    @DisplayName("notBlank 테스트")
    public void notBlank() {
        // given
        LotteryResult lotteryResult = SIX_MATCHES;
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
        long count = 10;
        long expected = FIVE_MATCHES.toDto(0)
                .getCashPrize()
                .multiply(count);

        // when
        long totalCashPrize = FIVE_MATCHES.getTotalCashPrize(count);

        // then
        assertThat(totalCashPrize).isEqualTo(expected);
    }

    @Test
    @DisplayName("toDto 테스트")
    public void toDto() {
        // given
        long count = 10;
        LotteryResultDto expected = FIVE_MATCHES.toDto(count);

        // when
        LotteryResultDto lotteryResultDto = FIVE_MATCHES.toDto(count);

        // then
        assertThat(lotteryResultDto.getCount()).isEqualTo(expected.getCount());
        assertThat(lotteryResultDto.getExplanation()).isEqualTo(expected.getExplanation());
        assertThat(lotteryResultDto.getCashPrize()).isEqualTo(expected.getCashPrize());
    }

}