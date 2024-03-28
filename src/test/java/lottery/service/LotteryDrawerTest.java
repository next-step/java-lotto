package lottery.service;

import lottery.code.WinPrizeType;
import lottery.domain.Lotteries;
import lottery.domain.Lottery;
import lottery.domain.WinLottery;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static java.util.Map.entry;
import static org.assertj.core.api.Assertions.assertThat;

public class LotteryDrawerTest {

    @Test
    @DisplayName("로또 당첨 통계 테스트")
    void lotteryBuyTest(){
        // Given
        final Lotteries lotteries = new Lotteries(
                List.of(
                        new Lottery("1, 2, 3, 4, 5, 6"),
                        new Lottery("2, 3, 4, 5, 6, 7")));
        final WinLottery winLottery = new WinLottery("3, 4, 5, 6, 7, 8");
        final LotteryDrawer lotteryDrawer = new LotteryDrawer(lotteries, winLottery);
        // When

        Map<WinPrizeType, Long> actual = lotteryDrawer.winStatistics();

        // Then
        assertThat(actual).hasSize(2);
        assertThat(actual).contains(entry(WinPrizeType.FOUR_MATCH, 1L), entry(WinPrizeType.FIVE_MATCH, 1L));
        assertThat(actual).doesNotContainEntry(WinPrizeType.THREE_MATCH, 0L);
    }

    @Test
    @DisplayName("수익률 계산")
    void profitRateTest(){
        //Given
        final Lotteries lotteries = new Lotteries(
                List.of(new Lottery("1, 2, 3, 4, 5, 6"),
                        new Lottery("10, 11, 12, 13, 14, 15"),
                        new Lottery("10, 11, 12, 13, 14, 15")));
        final WinLottery winLottery = new WinLottery("4, 5, 6, 7, 8, 9");
        final LotteryDrawer lotteryDrawer = new LotteryDrawer(lotteries, winLottery);

        // When
        BigDecimal actual = lotteryDrawer.profitRate();

        // Then
        BigDecimal expected = BigDecimal.valueOf(1.66);
        assertThat(actual).isEqualTo(expected);
    }
}
