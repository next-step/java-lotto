import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @DisplayName("일치하는 갯수에 대한 랭킹을 구한다.")
    @Test
    void test01() {
        // given
        int size = 6;

        // when
        Rank rank = Rank.of(size);

        // then
        assertThat(rank).isEqualTo(Rank.FIRST);
    }
}
