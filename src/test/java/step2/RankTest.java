package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class RankTest {

    @Test
    void create() {
        Rank first = Rank.valueOf("FIRST");
        assertThat(first).isEqualTo(Rank.FIRST);
    }

    @Test
    void get_rank() {
        Rank rank = Rank.matches(6);
        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @Test
    void count() {
        Rank rank = Rank.FIRST;
        rank.count();
        assertThat(rank.getCount()).isEqualTo(1);
    }

    @Test
    void total_reward() {
        Rank first = Rank.FIRST;
        first.count();
        int total = first.getTotal();
        assertThat(total).isEqualTo(2000000000);
    }
}
