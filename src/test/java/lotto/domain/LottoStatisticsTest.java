package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.Map;

/**
 * LottoStatistics 생성 및 통계 관련 기능 검증
 */
class LottoStatisticsTest {

    @ParameterizedTest
    @CsvSource(value = {"10,1,0,0,0,0.50", "13,2,0,0,0,0.76", "23,1,1,1,0,67.60", "30,0,0,0,1,66666.66"})
    @DisplayName("수익률 확인")
    void calculate_rateOfReturn(int buyCount, int three, int four, int five, int six, String rateOfReturn) {
        // given
        Price price = new Price(buyCount * Price.UNIT_OF_PRICE);
        Map<Integer, Integer> statistics = new HashMap<>();
        statistics.put(3, three);
        statistics.put(4, four);
        statistics.put(5, five);
        statistics.put(6, six);
        WinningCounts winningCounts = new WinningCounts(statistics);
        LottoStatistics lottoStatistics = new LottoStatistics(winningCounts);

        // when
        String rate = String.format("%.2f", lottoStatistics.calculateRateOfReturnByPrice(price));

        // then
        assertThat(rate).isEqualTo(rateOfReturn);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,0,0,0,5000", "1,1,1,2,4001555000", "0,0,0,1,2000000000"})
    @DisplayName("총 당첨금액 확인")
    void get_total_winningAmount(int three, int four, int five, int six, Long amount) {
        // given
        Map<Integer, Integer> statistics = new HashMap<>();
        statistics.put(3, three);
        statistics.put(4, four);
        statistics.put(5, five);
        statistics.put(6, six);
        WinningCounts winningCounts = new WinningCounts(statistics);
        // when
        LottoStatistics lottoStatistics = new LottoStatistics(winningCounts);

        // then
        assertThat(lottoStatistics.getTotalWinningAmount()).isEqualTo(amount);
    }

    @ParameterizedTest
    @CsvSource(value = {"3:7", "4:8", "5:9", "6:10"}, delimiter = ':')
    @DisplayName("당첨번호와 일치하는 갯수만큼 당청됨 로또 개수 확인")
    void get_count(int matchingNumber, int count) {
        // given
        Map<Integer, Integer> winningMatchedCounts = new HashMap<>();
        winningMatchedCounts.put(3, 7);
        winningMatchedCounts.put(4, 8);
        winningMatchedCounts.put(5, 9);
        winningMatchedCounts.put(6, 10);
        WinningCounts winningCounts = new WinningCounts(winningMatchedCounts);

        // when
        LottoStatistics lottoStatistics = new LottoStatistics(winningCounts);

        // then
        assertThat(lottoStatistics.getCountOfLottoWithMatchingNumber(matchingNumber)).isEqualTo(count);
    }

    @Test
    @DisplayName("통계 객체 생성")
    void create() {
        // given
        Map<Integer, Integer> winningMatchedCounts = new HashMap<>();
        winningMatchedCounts.put(3, 10);
        winningMatchedCounts.put(4, 10);
        winningMatchedCounts.put(5, 10);
        winningMatchedCounts.put(6, 10);
        WinningCounts winningCounts = new WinningCounts(winningMatchedCounts);

        // when
        LottoStatistics lottoStatistics = new LottoStatistics(winningCounts);

        // then
        assertThat(lottoStatistics.isEmpty()).isFalse();
    }
}
