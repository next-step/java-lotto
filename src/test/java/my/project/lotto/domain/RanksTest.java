package my.project.lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RanksTest {
    @Test
    void givenFifth_thenListHasSize() {
        List<Rank> list = new ArrayList<>();
        list.add(Rank.FIFTH);
        Ranks ranks = new Ranks(list);
        assertThat(ranks.getFifthRanks()).isEqualTo(1);
    }

    @Test
    void givenFifthTwice_thenListHasSize() {
        List<Rank> list = new ArrayList<>();
        list.add(Rank.FIFTH);
        list.add(Rank.FIFTH);
        Ranks ranks = new Ranks(list);
        assertThat(ranks.getFifthRanks()).isEqualTo(2);
    }

    @Test
    void givenFourthTwice_thenListHasSize() {
        List<Rank> list = new ArrayList<>();
        list.add(Rank.FOURTH);
        list.add(Rank.FOURTH);
        Ranks ranks = new Ranks(list);
        assertThat(ranks.getFourthRanks()).isEqualTo(2);
    }

    @Test
    void getProfit() {
        List<Rank> list = new ArrayList<>();
        list.add(Rank.FIFTH);
        list.add(Rank.FIFTH);
        Ranks ranks = new Ranks(list);
        assertThat(ranks.getProfit()).isEqualTo("5");
    }
}