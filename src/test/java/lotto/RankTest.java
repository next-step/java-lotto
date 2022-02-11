package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Rank;
import org.junit.jupiter.api.Test;

class RankTest {
    
    @Test
    void 일등_확인() {
        Rank rank = Rank.getRank(6, true);
        assertThat(rank).isEqualTo(Rank.FIRST);
    }
    
    @Test
    void 이등_확인() {
        Rank rank = Rank.getRank(5, true);
        assertThat(rank).isEqualTo(Rank.SECOND);
    }
    
    @Test
    void 삼등_확인() {
        Rank rank = Rank.getRank(5, false);
        assertThat(rank).isEqualTo(Rank.THIRD);
    }
    
    @Test
    void 사등_확인() {
        Rank rank = Rank.getRank(4, true);
        assertThat(rank).isEqualTo(Rank.FOURTH);
    }
    
    @Test
    void 오등_확인() {
        Rank rank = Rank.getRank(3, true);
        assertThat(rank).isEqualTo(Rank.FIFTH);
    }
    
    @Test
    void 탈락_확인() {
        Rank rank = Rank.getRank(2, true);
        assertThat(rank).isEqualTo(Rank.MISS);
    }
    
}