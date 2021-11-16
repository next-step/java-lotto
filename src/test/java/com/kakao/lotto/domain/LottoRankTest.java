package com.kakao.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {

    @ParameterizedTest
    @DisplayName("맞춘 개수를 넣으면 로또 결과를 반환한다.")
    @MethodSource("lottoRanks")
    void findByCorrectRank(int correctNumber, LottoRank lottoRank) {
        assertThat(LottoRank.findByMatchRank(correctNumber)).isEqualTo(lottoRank);
    }

    private static Stream<Arguments> lottoRanks() {
        return Stream.of(
                Arguments.arguments(6, LottoRank.FIRST),
                Arguments.arguments(5, LottoRank.SECOND),
                Arguments.arguments(4, LottoRank.THIRD),
                Arguments.arguments(3, LottoRank.FOURTH),
                Arguments.arguments(2, LottoRank.OUT),
                Arguments.arguments(1, LottoRank.OUT),
                Arguments.arguments(0, LottoRank.OUT)
        );
    }

}
