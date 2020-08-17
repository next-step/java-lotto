package kr.heesu.lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
    private List<Lotto> lottoList;

    @BeforeEach
    void setUp() {
        this.lottoList = new ArrayList<>();

        lottoList.add(Lotto.of(Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::of)
                .collect(Collectors.toList())));

        lottoList.add(Lotto.of(Stream.of(1, 2, 3, 7, 8, 9)
                .map(LottoNumber::of)
                .collect(Collectors.toList())));

        lottoList.add(Lotto.of(Stream.of(32, 31, 45, 10, 11, 15)
                .map(LottoNumber::of)
                .collect(Collectors.toList())));
    }

    @Test
    void match_test() {
        Lottos lottos = Lottos.of(lottoList);

        WinningNumbers win = WinningNumbers.of(Stream.of(1, 2, 3, 45, 44, 43)
                .map(LottoNumber::of)
                .collect(Collectors.toList()));

        Long target = 3L;
        MatchResult matches = lottos.matches(win);

        assertThat(matches.getMatchFrequency(target)).isEqualTo(2);
    }
}