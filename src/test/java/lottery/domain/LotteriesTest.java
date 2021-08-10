package lottery.domain;

import lottery.domain.winningstrategy.MatchWinningLotteryStrategy;
import lottery.dto.LotteryResultDto;
import lottery.dto.LotteryStatisticDto;
import org.assertj.core.api.ThrowableAssert;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LotteriesTest {

    @Test
    @DisplayName("입력 값이 null 인 경우")
    public void nullInput() {
        // given
        List<Lottery> lotteries = null;
        String message = "입력값은 null 일 수 없습니다";

        // when
        ThrowingCallable throwingCallable = () -> new Lotteries(lotteries);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    @DisplayName("getLotteryStatisticDto 테스트우 - 6개 일치하는 경우")
    public void getLotteryStatisticAllMatches() {
        // given
        List<Lottery> lotteryList = Arrays.asList(getLottery(1, 6));
        Lotteries lotteries = new Lotteries(lotteryList);
        Lottery winningLottery = getLottery(1, 6);
        BigDecimal expectedEarningsRate = getEarningsRate(LotteryResult.SIX_MATCHES, 1);

        // when
        LotteryStatisticDto lotteryStatisticDto = lotteries.getLotteryStatisticDto(new MatchWinningLotteryStrategy(winningLottery));
        List<Integer> counts = getLotteryResultCounts(lotteryStatisticDto);
        BigDecimal earningsRate = lotteryStatisticDto.getEarningsRate();

        // then
        assertThat(counts).containsExactly(0, 0, 0, 1);
        assertThat(earningsRate).isEqualTo(expectedEarningsRate);
    }

    @Test
    @DisplayName("getLotteryStatisticDto 테스트 - 3개 일치하는 경우")
    public void getLotteryStatisticThreeMatches() {
        // given
        List<Lottery> lotteryList = Arrays.asList(getLottery(4, 9), getLottery(11, 16));
        Lotteries lotteries = new Lotteries(lotteryList);
        Lottery winningLottery = getLottery(1, 6);
        BigDecimal expectedEarningsRate = getEarningsRate(LotteryResult.THREE_MATCHES, 2);

        // when
        LotteryStatisticDto lotteryStatisticDto = lotteries.getLotteryStatisticDto(new MatchWinningLotteryStrategy(winningLottery));
        List<Integer> counts = getLotteryResultCounts(lotteryStatisticDto);
        BigDecimal earningsRate = lotteryStatisticDto.getEarningsRate();

        // then
        assertThat(counts).containsExactly(1, 0, 0, 0);
        assertThat(earningsRate).isEqualTo(expectedEarningsRate);
    }

    private List<Integer> getLotteryResultCounts(final LotteryStatisticDto lotteryStatisticDto) {
        return lotteryStatisticDto.getLotteryResultDtos().stream()
                .map(LotteryResultDto::getCount)
                .collect(Collectors.toList());
    }

    private Lottery getLottery(int start, int end) {
        return new Lottery(getLotteryNumbers(start, end));
    }

    private List<LotteryNumber> getLotteryNumbers(int start, int end) {
        return IntStream.rangeClosed(start, end).boxed()
                .map(LotteryNumber::new)
                .collect(Collectors.toList());
    }

    private BigDecimal getEarningsRate(LotteryResult lotteryResult, int lotteryCount) {
        return lotteryResult.toDto(0)
                .getCashPrize()
                .divide(Lottery.PRICE.multiply(lotteryCount));
    }
}