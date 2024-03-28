package lottery.domain;

import lottery.code.WinPrizeType;
import lottery.domain.vo.LotteryNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import java.util.List;
import java.util.Map;

import static java.util.Map.entry;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LotteriesTest {

    @Test
    @DisplayName("당첨 통계 테스트")
    void winStatisticsTest() {
        // Given
        final Lottery lotteryA = new Lottery("1, 2, 3, 4, 5, 6");
        final Lottery lotteryB = new Lottery("2, 3, 4, 5, 6, 7");
        final Lotteries lotteries = new Lotteries(List.of(lotteryA, lotteryB));
        final WinLottery winLottery = new WinLottery("3, 4, 5, 6, 7, 8");

        // When
        Map<WinPrizeType, Long> actual = lotteries.winStatistics(winLottery);

        // Then
        assertThat(actual).hasSize(2);
        assertThat(actual).contains(entry(WinPrizeType.FOUR_MATCH, 1L), entry(WinPrizeType.FIVE_MATCH, 1L));
        assertThat(actual).doesNotContainEntry(WinPrizeType.THREE_MATCH, 0L);
    }

    @Test
    @DisplayName("로또 개수 테스트")
    void lotteryCountTest(){
        // Given
        final Lottery lotteryA = new Lottery("1, 2, 3, 4, 5, 6");
        final Lottery lotteryB = new Lottery("2, 3, 4, 5, 6, 7");
        final Lotteries lotteries = new Lotteries(List.of(lotteryA, lotteryB));

        // When
        Long actual = lotteries.lotteryCount();

        // Then
        assertThat(actual).isEqualTo(2L);
    }

    @Test
    @DisplayName("로또 여러개 생성 테스트")
    void lotteriesTest() {
        // Given
        final Lottery lotteryA = new Lottery("1, 2, 3, 4, 5, 6");
        final Lottery lotteryB = new Lottery("2, 3, 4, 5, 6, 7");
        final Lotteries lotteries = new Lotteries(List.of(lotteryA, lotteryB));

        // When
        List<Lottery> actual = lotteries.lotteries();

        // Then
        assertThat(actual).hasSize(2);
        assertThat(actual).contains(lotteryA, lotteryB);
    }

    @Test
    @DisplayName("로또 여러개 총 금액 테스트")
    void lotteriesTotalPriceTest(){
        // Given
        final Lottery lotteryA = new Lottery("1, 2, 3, 4, 5, 6");
        final Lottery lotteryB = new Lottery("2, 3, 4, 5, 6, 7");
        final Lotteries lotteries = new Lotteries(List.of(lotteryA, lotteryB));

        // When
        int actual = lotteries.lotteriesTotalPrice();

        // Then
        int expected = Lottery.PRICE * 2;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("로또 여러개 총 당첨 금액 테스트")
    void lotteriesTotalPrizeTest(){
        // Given
        final Lottery lotteryA = new Lottery("1, 2, 3, 4, 5, 6");
        final Lottery lotteryB = new Lottery("2, 3, 4, 5, 6, 7");
        final Lotteries lotteries = new Lotteries(List.of(lotteryA, lotteryB));
        final Map<WinPrizeType, Long> matchStatistics = Map.of(
                WinPrizeType.FOUR_MATCH, 1L,
                WinPrizeType.FIVE_MATCH, 1L);

        // When
        int actual = lotteries.lotteriesTotalPrize(matchStatistics);

        // Then
        int expected = WinPrizeType.FOUR_MATCH.prize() + WinPrizeType.FIVE_MATCH.prize();
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("구매 금액 null 예외 처리 테스트")
    void nullInputMoneyThrowExceptionTest(Integer inputMoney) {
        // When
        assertThatThrownBy(() -> {
            new Lotteries(inputMoney);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입 금액은 필수 입니다.");
    }

    @Test
    @DisplayName("구매 금액 부적합한 단위 예외 처리 테스트")
    void unfitUnitInputMoneyThrowExceptionTest() {
        // Given
        final Integer inputMoney = 1500;

        // When
        assertThatThrownBy(() -> {
            new Lotteries(inputMoney);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입 금액은 1000 단위 입니다.");
    }
}
