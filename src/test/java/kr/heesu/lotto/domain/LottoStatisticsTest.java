package kr.heesu.lotto.domain;

import kr.heesu.lotto.enums.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {

    private LottoStatistics statistics;

    @BeforeEach
    void setUp() {
        Set<Lotto> lottoList = new HashSet<>();

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

        RankResult result = lottos.matches(win, LottoNumber.of(7));
        PurchaseAmount amount = PurchaseAmount.of(3000);

        statistics = LottoStatistics.of(result, amount);
    }

    @Test
    void matches_test() {
        for (Rank rank : Rank.values()) {
            Long frequency = statistics.getRankFrequency(rank);
            assertThat(frequency).isGreaterThanOrEqualTo(0L);
        }
    }
}