package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MyRankTest {
    @Test
    public void Rank_추가() {
        MyRank myRank = new MyRank();
        myRank.add(Rank.FIRST);
        assertThat(myRank.getCount(Rank.FIRST)).isEqualTo(1);
    }
}
