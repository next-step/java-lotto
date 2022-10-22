import constant.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    private Rank noRankCase;
    private Rank firstRankCase;

    @BeforeEach
    public void init() {
        noRankCase = new Rank(0);
        firstRankCase = new Rank(6);
    }

    @Test
    public void 순위찾기_1등() {
        assertThat(firstRankCase.findRank()).isEqualTo("FIRST");
    }

    @Test
    public void 순위찾기_순위없음() {
        assertThat(noRankCase.findRank()).isEqualTo("UNKNOWN");
    }
}
