import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RanksTest {

    @DisplayName("랭킹별 갯수를 구한다.")
    @Test
    void test01() {
        // given
        Ranks ranks = new Ranks(List.of(Rank.FIRST, Rank.FOURTH));

        // when
        int result = ranks.count(Rank.FIRST);

        // then
        assertThat(result).isEqualTo(1);
    }
}
