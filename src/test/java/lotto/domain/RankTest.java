package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RankTest {

    @Test
    @DisplayName("일치하는 번호 갯수와 rank 객체의 matchingcount 일치하면 true 반환")
    void isMatching_test(){
        Rank rank1 = new Rank(Reward.THREE.getMatchingCount());
        assertTrue(rank1.isMatching(3));
        assertFalse(rank1.isMatching(2));

        Rank rank2 = new Rank(Reward.FOUR.getMatchingCount());
        assertTrue(rank2.isMatching(4));
        assertFalse(rank2.isMatching(3));

        Rank rank3 = new Rank(Reward.SIX.getMatchingCount());
        assertTrue(rank3.isMatching(6));
        assertFalse(rank3.isMatching(5));
    }
}
