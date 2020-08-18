package kr.heesu.lotto.domain;

import kr.heesu.lotto.enums.LottoPolicy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MatchResultTest {
    private MatchResult result;

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

        result = lottos.matches(win);
    }

    @Test
    void creation_test() {

        for (LottoPolicy policy : LottoPolicy.values()) {
            Long match = policy.getCount();
            Long frequency = result.getMatchFrequency(match);

            assertThat(frequency).isGreaterThanOrEqualTo(0L);
        }
    }

    @Test
    void total_price_test() {
        Long totalWinningPrice = result.getTotalWinningPrice();

        assertThat(totalWinningPrice).isEqualTo(10000L);
    }
}