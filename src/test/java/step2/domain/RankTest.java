package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {
    @DisplayName("보너스 넘버가 있는경우 랭킹 변환한다")
    @ParameterizedTest
    @CsvSource({"6,FIRST", "5,SECOND", "4,FORTH", "3,FIFTH"})
    void valueWithBonusNumber(int matchCount, String rankName) {
        assertThat(Rank.valueWithBonusNumberFrom(matchCount)).isEqualTo(Rank.valueOf(rankName));
    }

    @DisplayName("보너스 넘버가 없는경우 랭킹 변환한다")
    @ParameterizedTest
    @CsvSource({"6,FIRST", "5,THIRD", "4,FORTH", "3,FIFTH"})
    void valueWithoutBonusNumber(int matchCount, String rankName) {
        assertThat(Rank.valueFrom(matchCount)).isEqualTo(Rank.valueOf(rankName));
    }
}
