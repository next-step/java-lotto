package lotto.domain.model.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @DisplayName("당첨 등수 결정 테스트")
    @ParameterizedTest
    @CsvSource({
            "6, false, FIRST",
            "5, true, SECOND",
            "5, false, THIRD",
            "4, false, FOURTH",
            "3, false, FIFTH",
            "2, false, MISS",
            "1, false, MISS",
            "0, false, MISS"
    })
    void determineRank(final int matchCountValue, final boolean bonusMatchValue, final Rank expectedRank) {
        MatchCount matchCount = new MatchCount(matchCountValue);
        BonusMatch bonusMatch = BonusMatch.from(bonusMatchValue);
        
        Rank rank = Rank.of(matchCount, bonusMatch);

        assertThat(rank).isEqualTo(expectedRank);
    }

    @DisplayName("등수 결정 테스트 - 보너스 번호 미일치")
    @ParameterizedTest
    @CsvSource({
            "6, false, FIRST",
            "5, false, THIRD",
            "4, false, FOURTH",
            "3, false, FIFTH",
            "2, false, MISS",
            "1, false, MISS",
            "0, false, MISS"
    })
    void determineRankWithoutBonusMatch(int matchCountValue, boolean bonusMatchValue, Rank expectedRank) {
        MatchCount matchCount = new MatchCount(matchCountValue);
        BonusMatch bonusMatch = BonusMatch.from(bonusMatchValue);
        
        Rank rank = Rank.of(matchCount, bonusMatch);

        assertThat(rank).isEqualTo(expectedRank);
    }

    @DisplayName("등수 결정 테스트 - 보너스 번호 일치")
    @ParameterizedTest
    @CsvSource({
            "6, true, FIRST",
            "5, true, SECOND",
            "4, true, FOURTH",
            "3, true, FIFTH",
            "2, true, MISS",
            "1, true, MISS",
            "0, true, MISS"
    })
    void determineRankWithBonusMatch(int matchCountValue, boolean bonusMatchValue, Rank expectedRank) {
        MatchCount matchCount = new MatchCount(matchCountValue);
        BonusMatch bonusMatch = BonusMatch.from(bonusMatchValue);
        
        Rank rank = Rank.of(matchCount, bonusMatch);

        assertThat(rank).isEqualTo(expectedRank);
    }
} 
