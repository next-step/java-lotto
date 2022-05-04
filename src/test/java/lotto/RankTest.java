package lotto;

import lotto.model.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Rank enum 테스트")
public class RankTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 7})
    @DisplayName("matchCount로 해당하는 Rank를 찾을 수 없을 경우 OHTER로 대체한다.")
    void ofTest(int matchCount) {
        Rank rank = Rank.of(matchCount, false);

        assertThat(rank).isEqualTo(Rank.OTHER);
    }

    @ParameterizedTest
    @CsvSource(value = {"6:FIRST", "5:THIRD", "4:FOURTH", "3:FIFTH"}, delimiter = ':')
    @DisplayName("1~4등까지 matchCount에 맞는 Rank를 반환한다.")
    void ofTest(int matchCount, Rank rank) {
        Rank ofRank = Rank.of(matchCount, false);

        assertThat(ofRank).isEqualTo(rank);
    }
    @Test
    @DisplayName("matchCount가 5이고 보너스 번호가 맞으면 2등 Rank를 반환한다.")
    void ofTest() {
        Rank ofRank = Rank.of(5, true);

        assertThat(ofRank).isEqualTo(Rank.SECOND);
    }
}
