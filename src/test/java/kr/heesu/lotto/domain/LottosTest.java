package kr.heesu.lotto.domain;

import kr.heesu.lotto.enums.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottosTest {
    private Set<Lotto> lottoList;

    @BeforeEach
    void setUp() {
        this.lottoList = new HashSet<>();

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

        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 45, 44, 43)
                .map(LottoNumber::of)
                .collect(Collectors.toList());

        WinningLotto win = WinningLotto.of(Lotto.of(lottoNumbers), LottoNumber.of(7));

        RankResult matches = lottos.matches(win);

        assertThat(matches.getRankFrequency(Rank.FIFTH)).isEqualTo(2);
    }

    @Test
    void lotto_duplication_test() {
        Lottos lottos = Lottos.of(lottoList);

        Lotto lotto = Lotto.of(Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::of)
                .collect(Collectors.toList()));

        assertThat(lottos.contains(lotto)).isTrue();
    }
}