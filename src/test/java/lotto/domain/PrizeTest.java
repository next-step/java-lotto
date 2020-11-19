package lotto.domain;

import lotto.domain.enums.Rank;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeTest {
    @Test
    void testGetRank(){
        Prize prize = new Prize(Rank.FIRST, 10000L);
        assertThat(prize.getRank()).isEqualTo(Rank.FIRST);
    }

    @Test
    void testSameHashCode(){
        Prize prize1 = new Prize(Rank.FIRST, 10000L);
        Prize prize2 = new Prize(Rank.FIRST, 10000L);

        assertThat(prize1.hashCode()).isEqualTo(prize2.hashCode());
    }
}
