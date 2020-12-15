package com.nextstep.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @DisplayName("Lotto 갯수 확인")
    @Test
    void count() {
        List<Lotto> list = Arrays.asList(toLotto(1,2,3,4,5,6),toLotto(1,2,3,4,5,6));
        Lottos lottos = new Lottos(list);
        assertThat(lottos.count()).isEqualTo(2);
    }

    @DisplayName("Statistic 정상 반환 확인")
    @ParameterizedTest
    @MethodSource
    void getStatistics(Lotto lotto, LottoRank expected) {
        Lottos lottos = new Lottos(Collections.singletonList(lotto));
        WinningLotto winningLotto = new WinningLotto(toLotto(1,2,3,4,5,6),7);
        LottoStatistics statistics = lottos.summarizingLotto(winningLotto);

        assertThat(statistics.getCount(expected)).isEqualTo(1);
    }

    private static Stream<Arguments> getStatistics() {
        return Stream.of(
                Arguments.of(toLotto(1, 2, 3, 4, 5, 6), LottoRank.WIN_1ST),
                Arguments.of(toLotto(1, 2, 3, 4, 5, 7), LottoRank.WIN_2ND),
                Arguments.of(toLotto(1, 2, 3, 4, 5, 16), LottoRank.WIN_3RD),
                Arguments.of(toLotto(1, 2, 3, 4, 15, 16), LottoRank.WIN_4TH),
                Arguments.of(toLotto(1, 2, 3, 14, 15, 16), LottoRank.WIN_5TH),
                Arguments.of(toLotto(1, 2, 13, 14, 15, 16), LottoRank.RETIRE)
        );
    }

    private static Lotto toLotto(int ... numbers) {
        return IntStream.of(numbers)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::new));
    }
}
