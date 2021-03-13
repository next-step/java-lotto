package step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {

    private LottoStatistics lottoStatistics;

    @BeforeEach
    void init() {
        lottoStatistics = new LottoStatistics();
    }

    @DisplayName("통계를 낸다.")
    @Test
    void statistics() {
        //given
        Lottos lottos = createLottos();
        List<Integer> winNumber = List.of(1, 2, 3, 4, 5, 6);
        List<Rank> matchResult = lottos.staticsOfMatch(winNumber);

        //when
        Map<Integer, List<Rank>> statistics = lottoStatistics.getLottoRank(lottos, winNumber);

        //then
        assertThat(statistics.get(6).size()).isEqualTo(1);
        assertThat(statistics.get(5).size()).isEqualTo(1);
        assertThat(statistics.get(4).size()).isEqualTo(1);
        assertThat(statistics.get(0).size()).isEqualTo(1);
    }

    Lottos createLottos() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottoList.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        lottoList.add(new Lotto(List.of(7, 8, 9, 10, 11, 12)));
        lottoList.add(new Lotto(List.of(2, 3, 4, 5, 11, 24)));
        return new Lottos(lottoList);
    }
}