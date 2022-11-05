package lotto.domain;

import lotto.constant.LottoRanking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {
    EnumMap<LottoRanking, Integer> lottoRankings = new EnumMap<>(LottoRanking.class);
    LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        lottoRankings.put(LottoRanking.FOURTH, 1);
        lottoRankings.put(LottoRanking.FIFTH, 2);
        lottoResult = new LottoResult(lottoRankings);
    }

    @Test
    @DisplayName("4개 맞은 사람이 1명, 3개맞은 사람이 2명인지 확인")
    void 로또_결과_테스트() {
        Map<LottoRanking, Integer> lottoRankings = lottoResult.getLottoRankings();
        assertThat(lottoRankings.get(LottoRanking.FOURTH)).isEqualTo(1);
        assertThat(lottoRankings.get(LottoRanking.FIFTH)).isEqualTo(2);
    }

    @Test
    @DisplayName("복권 수익/구입금액 확인")
    void 로또_수익률_테스트() {
        assertThat(lottoResult.calculatePercentage(3000)).isEqualTo(20.0);
    }
}