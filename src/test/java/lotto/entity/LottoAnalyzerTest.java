package lotto.entity;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoAnalyzerTest {

    @Test
    void 각_등수별_몇개_맞추었는지_검증() {
        LottoAnalyzer lottoAnalyzer = new LottoAnalyzer();

        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), // 1등
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)), // 2등
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), // 1등
                new Lotto(Arrays.asList(1, 3, 6, 7, 9, 11)), // 5등
                new Lotto(Arrays.asList(1, 2, 3, 8, 10, 12)), // 5등
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 12)), // 3등
                new Lotto(Arrays.asList(1, 5, 6, 16, 18, 19)) // 5등
        );
        Set<Integer> winningNumbers = Set.of(1, 2, 3, 4, 5, 6);
        Winning winning = new Winning(winningNumbers, 7);

        List<WinningResult> analyzer = lottoAnalyzer.analyzer(lottos, winning);

        Map<Rank, Integer> collect = analyzer.stream().collect(Collectors.toMap(WinningResult::getRank, WinningResult::getCount));

        assertAll(
                () -> assertThat(collect.get(Rank.FIRST)).isEqualTo(2),
                () -> assertThat(collect.get(Rank.SECOND)).isEqualTo(1),
                () -> assertThat(collect.get(Rank.THIRD)).isEqualTo(1),
                () -> assertThat(collect.get(Rank.FOURTH)).isEqualTo(0),
                () -> assertThat(collect.get(Rank.FIFTH)).isEqualTo(3)
        );
    }
}
