package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

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

    @Test
    void 순위대로_정렬() {
        MyRank myRank = new MyRank();
        assertThat(myRank.all()).containsAll(Arrays.stream(Rank.values()).filter(Rank::isNotNone).collect(Collectors.toList()));
    }
}
