package com.monds.nextstep.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @ParameterizedTest
    @CsvSource(value = {
            "10, FOURTH, 0.5",
            "10, THIRD, 5"
    })
    @DisplayName("로또 수익률")
    void testGetYield(int lottoCount, String ranking, double yield) {
        // given
        Map<LottoRanking, Integer> countByRanking = new HashMap<>();
        countByRanking.put(LottoRanking.valueOf(ranking), 1);
        // when
        LottoResult result = new LottoResult(lottoCount, countByRanking);
        // then
        assertThat(result.calculateYield()).isEqualTo(yield);
    }
}
