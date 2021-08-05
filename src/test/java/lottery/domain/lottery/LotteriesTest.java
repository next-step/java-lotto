package lottery.domain.lottery;

import lottery.domain.lottery.Lotteries;
import lottery.domain.lottery.Lottery;
import lottery.domain.lottery.LotteryNumber;
import lottery.domain.winningstrategy.MatchWinningLotteryStrategy;
import lottery.dto.LotteryResultDto;
import lottery.dto.LotteryStatisticDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lottery.domain.lottery.LotteryResult.SIX_MATCHES;
import static org.assertj.core.api.Assertions.assertThat;

class LotteriesTest {

    @Test
    @DisplayName("getLotteryStatisticDto 테스트우 - 6개 일치하는 경우")
    public void getLotteryStatisticAllMatches() {
        // given
        List<Lottery> lotteryList = Arrays.asList(getLottery(1, 6));
        Lotteries lotteries = new Lotteries(lotteryList);
        Lottery winningLottery = getLottery(1, 6);
        int sixMatchesIndex = 3;
        int expectedSixMatchesCount = 1;
        double expectedEarningsRate = (double) SIX_MATCHES.toDto(0).getCashPrize() / Lottery.PRICE;

        // when
        LotteryStatisticDto lotteryStatisticDto = lotteries.getLotteryStatisticDto(new MatchWinningLotteryStrategy(winningLottery));
        List<LotteryResultDto> lotteryResultDtos = lotteryStatisticDto.getLotteryResultDtos();

        // then
        assertThat(lotteryResultDtos.get(sixMatchesIndex).getCount()).isEqualTo(expectedSixMatchesCount);
        assertThat(lotteryStatisticDto.getEarningsRate()).isEqualTo(expectedEarningsRate);
    }

    @Test
    @DisplayName("getLotteryStatisticDto 테스트 - 3개 일치하는 경우")
    public void getLotteryStatisticThreeMatches() {
        // given
        List<Lottery> lotteryList = Arrays.asList(getLottery(4, 9), getLottery(11, 16));
        Lotteries lotteries = new Lotteries(lotteryList);
        Lottery winningLottery = getLottery(1, 6);
        int threeMatchesIndex = 0;
        int expectedThreeMatchesCount = 1;
        double expectedEarningsRate = (double) SIX_MATCHES.toDto(0).getCashPrize() / (Lottery.PRICE * 2);

        // when
        LotteryStatisticDto lotteryStatisticDto = lotteries.getLotteryStatisticDto(new MatchWinningLotteryStrategy(winningLottery));
        List<LotteryResultDto> lotteryResultDtos = lotteryStatisticDto.getLotteryResultDtos();

        // then
        assertThat(lotteryResultDtos.get(threeMatchesIndex).getCount()).isEqualTo(expectedThreeMatchesCount);
        assertThat(lotteryStatisticDto.getEarningsRate()).isEqualTo(expectedEarningsRate);
    }

    private Lottery getLottery(int start, int end) {
        return new Lottery(getLotteryNumbers(start, end));
    }

    private List<LotteryNumber> getLotteryNumbers(int start, int end) {
        return IntStream.rangeClosed(start, end).boxed()
                .map(LotteryNumber::new)
                .collect(Collectors.toList());
    }
}