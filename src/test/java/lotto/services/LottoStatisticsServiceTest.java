package lotto.services;

import lotto.models.Lotto;
import lotto.models.LottoStatistics;
import lotto.models.enums.Rank;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsServiceTest {

    private final static LottoStatisticsService lottoStatisticsService = new LottoStatisticsService();
    private final static List<Lotto> lottos = new ArrayList<>();
    private final static String WINNING_NUMBER = "1,2,3,4,5,6";

    @BeforeAll
    static void setLotto() {
        lottos.add(Lotto.of(List.of(1,2,3,4,5,6)));
        lottos.add(Lotto.of(List.of(1,2,3,7,8,9)));
        lottos.add(Lotto.of(List.of(11,12,13,14,15,16)));
    }

    @ParameterizedTest
    @DisplayName("당첨번호와 로또값을 주면 동일한 숫자 개수를 리턴한다.")
    @CsvSource({"0, 6", "1, 3", "2, 0"})
    void getEqualCount(int index, int equalCount) {
        assertThat(lottoStatisticsService.getEqualCount(lottos.get(index), WINNING_NUMBER)).isEqualTo(equalCount);
    }

    @Test
    @DisplayName("당첨번호와 로또번호 리스트를 받으면 각 Rank가 몇 개씩 당첨됐는지 가져온다.")
    void createStatistics() {
        List<LottoStatistics> lottoStatistics = lottoStatisticsService.getLottoStatistics(lottos, WINNING_NUMBER);

        lottoStatistics.forEach(statistics -> {
            if (statistics.getRank().equals(Rank.FIRST)) {
                assertThat(statistics.getCount()).isEqualTo(1);
            } else if (statistics.getRank().equals(Rank.FOURTH)) {
                assertThat(statistics.getCount()).isEqualTo(1);
            } else if (statistics.getRank().equals(Rank.OTHER)) {
                assertThat(statistics.getCount()).isEqualTo(1);
            }
        });
    }

}
