package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @Test
    public void 구매한_전체_로또의_당첨_통계를_반환한다() {
        List<LottoNumber> winningNumbers = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        Lotto firstRankLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto thirdRankLotto = new Lotto(List.of(1, 2, 3, 4, 10, 20));
        Lotto noPrizeRankLotto = new Lotto(List.of(1, 2, 11, 23, 33, 38));

        Lottos lottos = new Lottos(List.of(firstRankLotto, thirdRankLotto, noPrizeRankLotto));

        lottos.determineAllLottoResult(winningNumbers);
        Map<Rank, Integer> result = LottoResultAnalyzer.analyzeLottosStatistics(lottos);

        assertThat(result.get(Rank.FIRST)).isEqualTo(1);
        assertThat(result.get(Rank.SECOND)).isEqualTo(0);
        assertThat(result.get(Rank.THIRD)).isEqualTo(1);
        assertThat(result.get(Rank.FOURTH)).isEqualTo(0);
        assertThat(result.get(Rank.NO_PRIZE)).isEqualTo(1);
    }

}
