package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StatisticsWinnerResultTest {

    private StatisticsWinnerResult statisticsWinnerResult;

    public void createTest(Map<RankLotto, Integer> result) {
        statisticsWinnerResult = new StatisticsWinnerResult(result);
    }

    @DisplayName("당첨 총액 수익률")
    @Test
    void 당첨_수익률() {
        //given
        createTest(Map.of(RankLotto.FIRST, 0, RankLotto.SECOND, 0, RankLotto.THIRD, 0, RankLotto.FOURTH, 0, RankLotto.FIFTH, 1));
        //when
        double result = statisticsWinnerResult.rateOfReturn(10000);
        //then
        assertThat(result).isEqualTo(0.5);
    }

    @DisplayName("당첨 결과 출력 문구")
    @Test
    void 당첨_결과_출력문구() {
        //given
        createTest(Map.of(RankLotto.FIFTH, 3));
        //when
        String result = statisticsWinnerResult.toString();
        //then
        assertThat(result).isEqualTo("당첨 통계\n" +
                "---------\n" +
                "3개 일치 (5000원) - 3개");
    }

    @DisplayName("당첨 갯수 체크 후 생성")
    @Test
    void 당첨_갯수_체크() {
        //given
        createTest(Map.of(RankLotto.FIRST, 0, RankLotto.SECOND, 0, RankLotto.THIRD, 0, RankLotto.FOURTH, 0, RankLotto.FIFTH, 2));
        //when
        //then
        assertThat(statisticsWinnerResult.result().get(RankLotto.FIFTH)).isEqualTo(2);
    }
}
