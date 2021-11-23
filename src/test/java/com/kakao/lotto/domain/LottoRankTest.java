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
    void findByCorrectRank(int correctNumber, boolean isBonus, LottoRank lottoRank) {
        assertThat(LottoRank.findByMatchRank(correctNumber, isBonus)).isEqualTo(lottoRank);
    }

    private static Stream<Arguments> lottoRanks() {
        return Stream.of(
                Arguments.arguments(6, true, LottoRank.FIRST),
                Arguments.arguments(6, false, LottoRank.FIRST),
                Arguments.arguments(5, true, LottoRank.SECOND),
                Arguments.arguments(5, false, LottoRank.THIRD),
                Arguments.arguments(4, true, LottoRank.FOURTH),
                Arguments.arguments(4, false, LottoRank.FOURTH),
                Arguments.arguments(3, true, LottoRank.FIFTH),
                Arguments.arguments(3, false, LottoRank.FIFTH),
                Arguments.arguments(2, true, LottoRank.OUT),
                Arguments.arguments(2, false, LottoRank.OUT),
                Arguments.arguments(1, true, LottoRank.OUT),
                Arguments.arguments(1, false, LottoRank.OUT),
                Arguments.arguments(0, true, LottoRank.OUT),
                Arguments.arguments(0, false, LottoRank.OUT)
        );
    }

}
