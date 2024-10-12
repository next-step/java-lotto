package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.domain.LottoRank.*;
import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {
    @Test
    @DisplayName("6개의 번호가 일치하다면, 1등이 반환된다.")
    void shouldReturnFirstRankWhenMatchedCountIsSix() {
        final int matchedCount = 6;

        final LottoRank lottoRankByMatchedCount = LottoRank.findLottoRankByMatchedNumber(matchedCount);

        assertThat(lottoRankByMatchedCount).isEqualTo(FIRST);
    }

    @Test
    @DisplayName("5개의 번호가 일치하다면, 3등이 반환된다.")
    void shouldReturnThirdRankWhenMatchedCountIsFive() {
        final int matchedCount = 5;

        final LottoRank lottoRankByMatchedCount = LottoRank.findLottoRankByMatchedNumber(matchedCount);

        assertThat(lottoRankByMatchedCount).isEqualTo(THIRD);
    }

    @Test
    @DisplayName("5개의 번호가 일치하고, 보너스번호가 일치하다면 2등이 반환된다.")
    void shouldReturnSecondRankWhenMatchedCountIsFiveAndBonusNumber() {
        final int matchedCount = 5;

        final LottoRank lottoRankByMatchedCount = LottoRank.findLottoRankByMatchedNumber(matchedCount, true);

        assertThat(lottoRankByMatchedCount).isEqualTo(SECOND);
    }

    @Test
    @DisplayName("4개의 번호가 일치하다면, 4등이 반환된다.")
    void shouldReturnFourthRankWhenMatchedCountIsFour() {
        final int matchedCount = 4;

        final LottoRank lottoRankByMatchedCount = LottoRank.findLottoRankByMatchedNumber(matchedCount);

        assertThat(lottoRankByMatchedCount).isEqualTo(FOURTH);
    }

    @Test
    @DisplayName("3개의 번호가 일치하다면, 5등이 반환된다.")
    void shouldReturnFifthRankWhenMatchedCountIsThree() {
        final int matchedCount = 3;

        final LottoRank lottoRankByMatchedCount = LottoRank.findLottoRankByMatchedNumber(matchedCount);

        assertThat(lottoRankByMatchedCount).isEqualTo(FIFTH);
    }

    @Test
    @DisplayName("2개 이하의 번호가 일치하면, NONE 가 반환된다.")
    void shouldReturnSixthRankWhenMatchedCountIsTwo() {
        final int matchedCount = 2;

        final LottoRank lottoRankByMatchedCount = LottoRank.findLottoRankByMatchedNumber(matchedCount);

        assertThat(lottoRankByMatchedCount).isEqualTo(NONE);
    }
}