package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RankTest {

    @Test
    @DisplayName("5개의 번호 일치와 보너스 번호 불일치를 통해 3등 구하기")
    void findThirdRank() {
        int matchCount = 5;
        boolean bonusMatched = false;

        Rank thirdRank = Rank.findRank(matchCount, bonusMatched);
        assertThat(thirdRank).isEqualTo(Rank.THIRD);
    }

    @Test
    @DisplayName("5개의 번호 일치와 보너스 번호 일치를 통해 2등 구하기")
    void findSecondRank() {
        int matchCount = 5;
        boolean bonusMatched = true;

        Rank secondRank = Rank.findRank(matchCount, bonusMatched);

        assertThat(secondRank).isEqualTo(Rank.SECOND);
    }

}