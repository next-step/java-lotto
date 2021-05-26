package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import lotto.utils.LottoNumbersUtil;
import lotto.constant.LottoRank;

/**
 * 통계를 처리하는 LottoRankStatistics 클래스 기능 테스트
 */
public class LottoRankStatisticsTest {

    @ParameterizedTest
    @CsvSource(value = {"20:1,2,3,40,41,42:0.65", "30:4,5,3,40,41,42:0.30", "10:5,2,3,4,41,42:8.07", "20:1,2,3,4,5,6:87023.91"}, delimiter = ':')
    @DisplayName("총 수일륙을 확인")
    void total_winningMoney(int size, String winningNumber, String rateOfReturn) {
        // given
        List<LottoNumbers> lottos = new ArrayList<>();
        lottos.add(LottoNumbersUtil.toLottoNumbers("1,2,3,4,5,6"));
        lottos.add(LottoNumbersUtil.toLottoNumbers("1,2,3,4,5,7"));
        lottos.add(LottoNumbersUtil.toLottoNumbers("1,2,3,4,7,8"));
        for (int i = 0; i < size; i++) {
            lottos.add(LottoNumbersUtil.toLottoNumbers("11,12,13,14,17,18"));
        }
        LottoRankStatistics statistics = new LottoRankStatistics(new Lottos(lottos), LottoNumbersUtil.toLottoNumbers(winningNumber));

        // when
        statistics.initStatistics();
        String resultRateOfReturn = statistics.calculateRateOfReturn();

        // then
        assertThat(resultRateOfReturn).isEqualTo(rateOfReturn);
    }

    @Test
    @DisplayName("등수별 당첨 개수를 확인")
    void lottoCount_by_rank() {
        // given
        List<LottoNumbers> lottos = new ArrayList<>();
        lottos.add(LottoNumbersUtil.toLottoNumbers("1,2,3,4,5,6"));
        lottos.add(LottoNumbersUtil.toLottoNumbers("1,2,3,4,5,6"));
        lottos.add(LottoNumbersUtil.toLottoNumbers("1,2,3,4,5,6"));

        LottoRankStatistics statistics = new LottoRankStatistics(new Lottos(lottos), LottoNumbersUtil.toLottoNumbers("1,2,3,4,5,6"));

        // when
        statistics.initStatistics();
        int lottoCount = statistics.getLottoCountByRank(LottoRank.FIRST);

        // then
        assertThat(lottoCount).isEqualTo(3);
    }
}
