package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.domain.LottoRank.*;
import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {
    @Test
    @DisplayName("당첨 된 번호 개수를 넘기면 그에 맞는 랭크가 반환된다.")
    void shouldReturnCorrectRank() {
        final LottoRank lottoRankByMatchedCount = LottoRank.findLottoRankByMatchedCount(FIRST_RANK_MATCH_NUMBER);

        assertThat(lottoRankByMatchedCount).isEqualTo(first());
    }

    @Test
    @DisplayName("6개의 번호가 일치하다면, 1등이 반환된다.")
    void shouldReturnFirstRankWhenMatchedCountIsSix() {
        final int matchedCount = 6;

        final LottoRank lottoRankByMatchedCount = LottoRank.findLottoRankByMatchedCount(matchedCount);

        assertThat(lottoRankByMatchedCount).isEqualTo(first());
    }

    @Test
    @DisplayName("5개의 번호가 일치하다면, 3등이 반환된다.")
    void shouldReturnThirdRankWhenMatchedCountIsFive() {
        final int matchedCount = 5;

        final LottoRank lottoRankByMatchedCount = LottoRank.findLottoRankByMatchedCount(matchedCount);

        assertThat(lottoRankByMatchedCount).isEqualTo(third());
    }

    @Test
    @DisplayName("4개의 번호가 일치하다면, 4등이 반환된다.")
    void shouldReturnFourthRankWhenMatchedCountIsFour() {
        final int matchedCount = 4;

        final LottoRank lottoRankByMatchedCount = LottoRank.findLottoRankByMatchedCount(matchedCount);

        assertThat(lottoRankByMatchedCount).isEqualTo(fourth());
    }

    @Test
    @DisplayName("3개의 번호가 일치하다면, 5등이 반환된다.")
    void shouldReturnFifthRankWhenMatchedCountIsThree() {
        final int matchedCount = 3;

        final LottoRank lottoRankByMatchedCount = LottoRank.findLottoRankByMatchedCount(matchedCount);

        assertThat(lottoRankByMatchedCount).isEqualTo(fifth());
    }
}