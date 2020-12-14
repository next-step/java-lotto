package com.nextstep.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @DisplayName("Lotto 갯수 확인")
    @Test
    void count() {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        List<Lotto> list = Arrays.asList(new Lotto(numbers),new Lotto(numbers));
        Lottos lottos = new Lottos(list);
        assertThat(lottos.count()).isEqualTo(2);
    }

    @DisplayName("Statistic 정상 반환 확인")
    @ParameterizedTest
    @MethodSource
    void getStatistics(List<Integer> numbers, LottoRank expected) {
        Lottos lottos = new Lottos(Arrays.asList(new Lotto(numbers)));
        LottoStatistics statistics = lottos.getStatistics(Arrays.asList(1,2,3,4,5,6), 7);

        assertThat(statistics.getCount(expected)).isEqualTo(1);
    }

    private static Stream<Arguments> getStatistics() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), LottoRank.WIN_1ST),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 7), LottoRank.WIN_2ND),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 16), LottoRank.WIN_3RD),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 15, 16), LottoRank.WIN_4TH),
                Arguments.of(Arrays.asList(1, 2, 3, 14, 15, 16), LottoRank.WIN_5TH),
                Arguments.of(Arrays.asList(1, 2, 13, 14, 15, 16), LottoRank.RETIRE)
        );
    }

}
