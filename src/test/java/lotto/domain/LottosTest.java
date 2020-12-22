package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @Test
    @DisplayName("당첨 통계 계산하기")
    void makeStatistic() {
        LottoNumbers numbers = new LottoNumbers(new Integer[]{1, 2, 3, 4, 5, 6});
        List<Lotto> lottoList = Arrays.asList(
                new Lotto(numbers, 0), new Lotto(numbers, 1), new Lotto(numbers, 2),
                new Lotto(numbers, 3), new Lotto(numbers, 3),
                new Lotto(numbers, 4), new Lotto(numbers, 4), new Lotto(numbers, 4),
                new Lotto(numbers, 5), new Lotto(numbers, 5),
                new Lotto(numbers, 6)
        );
        Lottos lottos = new Lottos(lottoList);
        LottoStatistic actual = lottos.makeStatistic();
        Map<LottoRank, Integer> lottoStatisticMap = new HashMap<>();
        lottoStatisticMap.put(LottoRank.FIRST, 1);
        lottoStatisticMap.put(LottoRank.SECOND, 2);
        lottoStatisticMap.put(LottoRank.THIRD, 3);
        lottoStatisticMap.put(LottoRank.FOURTH, 2);
        lottoStatisticMap.put(LottoRank.MISS, 3);
        LottoStatistic expected = new LottoStatistic(lottoStatisticMap);
        assertThat(actual).isEqualTo(expected);
    }
}
