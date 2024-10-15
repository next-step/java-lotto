package lotto.entity;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoAnalyzerTest {

    @Test
    void 각_등수별_몇개_맞추었는지_검증() {
        LottoResultAnalyzer lottoResultAnalyzer = new LottoResultAnalyzer();

        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 3, 6, 7, 9, 11)),
                new Lotto(Arrays.asList(1, 2, 3, 8, 10, 12)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 12)),
                new Lotto(Arrays.asList(1, 5, 10, 16, 18, 19))
        );
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<WinningResult> analyzer = lottoResultAnalyzer.analyzer(lottos, winningNumbers);

        Map<PrizeMoney, Integer> collect = analyzer.stream().collect(Collectors.toMap(WinningResult::getPrizeMoney, WinningResult::getCount));

        assertAll(
                () -> assertThat(collect.get(PrizeMoney.THREE)).isEqualTo(2),
                () -> assertThat(collect.get(PrizeMoney.FOUR)).isEqualTo(0),
                () -> assertThat(collect.get(PrizeMoney.FIVE)).isEqualTo(1),
                () -> assertThat(collect.get(PrizeMoney.SIX)).isEqualTo(3)
        );
    }
}
