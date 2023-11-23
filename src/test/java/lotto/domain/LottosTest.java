package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {

    @Test
    @DisplayName("로또 뭉치를 생성한다.")
    void create_lottos() {
        // given
        List<List<Integer>> givenLottos = createGivenLottos();

        // when
        Lottos lottos = new Lottos(givenLottos);

        // then
        assertThat(lottos).isEqualTo(createExpectedLottos());
    }

    private List<List<Integer>> createGivenLottos() {
        List<List<Integer>> given = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            given.add(new ArrayList<>());
        }
        for (List<Integer> lotto : given) {
            lotto.addAll(List.of(1, 2, 3, 4, 5, 6));
        }
        return given;
    }

    private Lottos createExpectedLottos() {
        return new Lottos(
                createExpectedLotto(),
                createExpectedLotto(),
                createExpectedLotto(),
                createExpectedLotto(),
                createExpectedLotto(),
                createExpectedLotto()
        );
    }

    private Lotto createExpectedLotto() {
        return new Lotto(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("로또 뭉치와 당첨 로또를 비교해 당첨 통계를 만든다.")
    void create_rank_statistics() {
        // given
        Lottos lottos = createLottoBundle();

        // when
        Map<Rank, Long> result = lottos.seekRankStatistics(new Lotto(1, 2, 3, 4, 5, 6));

        // then
        assertThat(result).isEqualTo(createExpectedRankStatistics());
    }

    private Lottos createLottoBundle() {
        return new Lottos(
                new Lotto(1, 2, 3, 4, 5, 6),
                new Lotto(7, 8, 9, 10, 11, 12),
                new Lotto(13, 14, 15, 16, 17, 18),
                new Lotto(1, 3, 5, 6, 9, 11),
                new Lotto(38, 39, 40, 41, 42, 43)
        );
    }

    private Map<Rank, Long> createExpectedRankStatistics() {
        Map<Rank, Long> rankStatistics = new LinkedHashMap<>();
        rankStatistics.put(Rank.NOTHING, 3L);
        rankStatistics.put(Rank.FOURTH, 0L);
        rankStatistics.put(Rank.THIRD, 1L);
        rankStatistics.put(Rank.SECOND, 0L);
        rankStatistics.put(Rank.FIRST, 1L);

        return rankStatistics;
    }
}
