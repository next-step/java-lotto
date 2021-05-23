package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

/**
 * LottoStatistics 생성 및 통계 관련 기능 검증
 */
class LottoStatisticsTest {

    @ParameterizedTest
    @CsvSource(value = {"1,0,0,0,0.25", "2,0,0,0,0.50", "1,1,1,0,77.75", "0,0,0,1,100000.00"})
    @DisplayName("수익률 확인")
    void calculate_rateOfReturn(int three, int fore, int five, int six, Double rateOfReturn) {
        // given
        Price price = new Price(20000L);
        Map<Integer, Integer> statistics = new HashMap<>();
        statistics.put(3, three);
        statistics.put(4, fore);
        statistics.put(5, five);
        statistics.put(6, six);
        LottoStatistics lottoStatistics = new LottoStatistics(statistics);

        // when
        Double rate = lottoStatistics.calculateRateOfReturnByPrice(price);

        // then
        assertThat(rate).isEqualTo(rateOfReturn);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,0,0,0,5000", "1,1,1,2,4001555000", "0,0,0,1,2000000000"})
    @DisplayName("총 당첨금액 확인")
    void get_total_winningAmount(int three, int fore, int five, int six, Long amount) {
        // given
        Map<Integer, Integer> statistics = new HashMap<>();
        statistics.put(3, three);
        statistics.put(4, fore);
        statistics.put(5, five);
        statistics.put(6, six);

        // when
        LottoStatistics lottoStatistics = new LottoStatistics(statistics);

        // then
        assertThat(lottoStatistics.getTotalWinningAmount()).isEqualTo(amount);
    }

    @ParameterizedTest
    @ValueSource(ints = {2,7})
    @DisplayName("통계 생성 시 당첨 기준 번호 일치개수 유효성 검증")
    void validate_matchingNumber(int matchingNumber) {
        // given
        Map<Integer, Integer> statistics = new HashMap<>();
        statistics.put(matchingNumber, 0);

        // then
        assertThatThrownBy(() -> new LottoStatistics(statistics))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨을 인정하는 번호 일치 개수는 3~6개 입니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"3:7", "4:8", "5:9", "6:10"}, delimiter = ':')
    @DisplayName("당첨번호와 일치하는 갯수만큼 당청됨 로또 개수 확인")
    void get_count(int matchingNumber, int count) {
        // given
        Map<Integer, Integer> statistics = new HashMap<>();
        statistics.put(3, 7);
        statistics.put(4, 8);
        statistics.put(5, 9);
        statistics.put(6, 10);

        // when
        LottoStatistics lottoStatistics = new LottoStatistics(statistics);

        // then
        assertThat(lottoStatistics.getCountOfLottoWithMatchingNumber(matchingNumber)).isEqualTo(count);
    }

    @Test
    @DisplayName("통계 객체 생성")
    void create() {
        // given
        Map<Integer, Integer> statistics = new HashMap<>();
        statistics.put(3, 10);
        statistics.put(4, 10);
        statistics.put(5, 10);
        statistics.put(6, 10);

        // when
        LottoStatistics lottoStatistics = new LottoStatistics(statistics);

        // then
        assertThat(lottoStatistics.isEmpty()).isFalse();
    }
}
