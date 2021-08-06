package lottery.domain;

import lottery.domain.Lotteries;
import lottery.domain.Lottery;
import lottery.domain.LotteryNumber;
import lottery.domain.LotteryResult;
import lottery.domain.winningstrategy.MatchWinningLotteryStrategy;
import lottery.dto.LotteryResultDto;
import lottery.dto.LotteryStatisticDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lottery.domain.Lottery.PRICE;
import static lottery.domain.LotteryResult.SIX_MATCHES;
import static lottery.domain.LotteryResult.THREE_MATCHES;
import static org.assertj.core.api.Assertions.assertThat;

class LotteriesTest {

    @Test
    @DisplayName("getLotteryStatisticDto 테스트우 - 6개 일치하는 경우")
    public void getLotteryStatisticAllMatches() {
        // given
        List<Lottery> lotteryList = Arrays.asList(getLottery(1, 6));
        Lotteries lotteries = new Lotteries(lotteryList);
        Lottery winningLottery = getLottery(1, 6);
        double expectedEarningsRate = getEarningsRate(SIX_MATCHES, 1);

        // when
        LotteryStatisticDto lotteryStatisticDto = lotteries.getLotteryStatisticDto(new MatchWinningLotteryStrategy(winningLottery));
        List<Integer> counts = getLotteryResultCounts(lotteryStatisticDto);
        double earningsRate = lotteryStatisticDto.getEarningsRate();

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
        double expectedEarningsRate = getEarningsRate(THREE_MATCHES, 2);

        // when
        LotteryStatisticDto lotteryStatisticDto = lotteries.getLotteryStatisticDto(new MatchWinningLotteryStrategy(winningLottery));
        List<Integer> counts = getLotteryResultCounts(lotteryStatisticDto);
        double earningsRate = lotteryStatisticDto.getEarningsRate();

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

    private double getEarningsRate(LotteryResult lotteryResult, int lotteryCount) {
        return lotteryResult.toDto(0)
                .getCashPrize()
                .divide(PRICE.multiply(lotteryCount));
    }
}