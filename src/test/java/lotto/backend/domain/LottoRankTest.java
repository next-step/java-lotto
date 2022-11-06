package lotto.backend.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {

        @DisplayName("1등")
        @ParameterizedTest(name = "[{index}] 맞은갯수: {0} && 보너스 {1} = 1등")
        @CsvSource({"6,true", "6,false"})
        void rank_1st(int countOfMatch, boolean hasBonusNum) {
                assertThat(LottoRank.valueOf(new Matching(countOfMatch, hasBonusNum)))
                        .isEqualTo(LottoRank.FIRST);
        }

        @Test
        @DisplayName("2등 당첨")
        void rank_2nd() {
                assertThat(LottoRank.valueOf(new Matching(5, true)))
                        .isEqualTo(LottoRank.SECOND);
        }

        @Test
        @DisplayName("3등 당첨")
        void rank_3rd() {
                assertThat(LottoRank.valueOf(new Matching(5, false)))
                        .isEqualTo(LottoRank.THIRD);
        }

        @DisplayName("4등 당첨")
        @ParameterizedTest(name = "[{index}] 맞은갯수: {0} && 보너스 {1} = 4등")
        @CsvSource({"4,true", "4,false"})
        void rank_4th(int countOfMatch, boolean hasBonusNum) {
                assertThat(LottoRank.valueOf(new Matching(countOfMatch, hasBonusNum)))
                        .isEqualTo(LottoRank.FOURTH);
        }

        @DisplayName("5등 당첨")
        @ParameterizedTest(name = "[{index}] 맞은갯수: {0} && 보너스 {1} = 5등")
        @CsvSource({"3,true", "3,false"})
        void rank_5th(int countOfMatch, boolean hasBonusNum) {
                assertThat(LottoRank.valueOf(new Matching(countOfMatch, hasBonusNum)))
                        .isEqualTo(LottoRank.FIFTH);
        }

        @DisplayName("꽝")
        @ParameterizedTest(name = "[{index}] 맞은갯수: {0} && 보너스 {1} = 꽝")
        @CsvSource({"2,true", "2,false", "1,true", "1,false", "0,true", "0,false"})
        void rank_nothing(int countOfMatch, boolean hasBonusNum) {
                assertThat(LottoRank.valueOf(new Matching(countOfMatch, hasBonusNum)))
                        .isEqualTo(LottoRank.NOTHING);
        }
}
