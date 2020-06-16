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
}
