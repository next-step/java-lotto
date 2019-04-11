import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class RankTest {

    @Test
    public void 등수_가져오기() {
        assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD);
    }
}