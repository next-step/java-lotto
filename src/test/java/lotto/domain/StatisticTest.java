package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class StatisticTest {

    private Lotto toLotto(List<Integer> numbers) {
        List<LottoNum> lottoNums = numbers.stream()
            .map(LottoNum::new)
            .collect(Collectors.toList());
        return new Lotto(lottoNums);
    }

    @Test
    void 통계_테스트() {
        Lotto winLotto = toLotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNum bonus = new LottoNum(7); // 보너스 번호 설정

        WinLottoNumber winLottoNumber = new WinLottoNumber(winLotto, bonus);

        Lottos lottos = new Lottos(List.of(
            toLotto(List.of(1, 2, 3, 7, 8, 9)),    // 3개 일치 → 5,000
            toLotto(List.of(1, 2, 3, 4, 8, 9)),    // 4개 일치 → 50,000
            toLotto(List.of(1, 2, 3, 4, 5, 9)),    // 5개 일치 (보너스 X) → 1,500,000
            toLotto(List.of(1, 2, 3, 4, 5, 6)),    // 6개 일치 → 2,000,000,000
            toLotto(List.of(10, 11, 12, 13, 14, 15)) // 0개 일치 → MISS
        ));

        Statistic statistic = new Statistic(lottos, winLottoNumber);

        // then (검증)
        assertThat(statistic.result().getOrDefault(Rank.FIFTH, 0)).isEqualTo(1);   // 3개
        assertThat(statistic.result().getOrDefault(Rank.FOURTH, 0)).isEqualTo(1);  // 4개
        assertThat(statistic.result().getOrDefault(Rank.THIRD, 0)).isEqualTo(1);   // 5개
        assertThat(statistic.result().getOrDefault(Rank.FIRST, 0)).isEqualTo(1);   // 6개
        assertThat(statistic.result().getOrDefault(Rank.MISS, 0)).isEqualTo(1);    // 나머지

        // 총 당첨금 계산
        long expectedTotal = 5_000 + 50_000 + 1_500_000 + 2_000_000_000L;
        assertThat(statistic.getTotalPrize()).isEqualTo(expectedTotal);
    }
}
