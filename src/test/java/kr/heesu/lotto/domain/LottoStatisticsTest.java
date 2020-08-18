package kr.heesu.lotto.domain;

import kr.heesu.lotto.enums.LottoPolicy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {

    private LottoStatistics statistics;

    @BeforeEach
    void setUp() {
        List<Lotto> lottoList = new ArrayList<>();

        lottoList.add(Lotto.of(Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::of)
                .collect(Collectors.toList())));

        lottoList.add(Lotto.of(Stream.of(1, 2, 3, 7, 8, 9)
                .map(LottoNumber::of)
                .collect(Collectors.toList())));

        lottoList.add(Lotto.of(Stream.of(32, 31, 45, 10, 11, 15)
                .map(LottoNumber::of)
                .collect(Collectors.toList())));

        Lottos lottos = Lottos.of(lottoList);

        WinningNumbers win = WinningNumbers.of(Stream.of(1, 2, 3, 45, 44, 43)
                .map(LottoNumber::of)
                .collect(Collectors.toList()));

        MatchResult result = lottos.matches(win);
        PurchaseAmount amount = PurchaseAmount.of(3000);

        statistics = LottoStatistics.of(result, amount);
    }

    @Test
    void matches_test() {
        for (LottoPolicy policy : LottoPolicy.values()) {
            Long match = policy.getCount();
            Long frequency = statistics.getMatchFrequency(match);

            assertThat(frequency).isGreaterThanOrEqualTo(0L);
        }
    }
}