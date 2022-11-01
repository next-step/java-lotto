package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MyRankTest {
    @Test
    public void Rank_추가() {
        MyRank myRank = new MyRank();
        myRank.add(Rank.FIRST);
        assertThat(myRank.getCount(Rank.FIRST)).isEqualTo(1);
    }

    @Test
    void 수익률_계산하기() {
        MyRank myRank = new MyRank();
        myRank.add(Rank.FOURTH);
        assertThat(myRank.profit(140000.0)).isEqualTo(5000.0 / 140000.0);
    }
}
