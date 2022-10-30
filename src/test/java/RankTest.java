import constant.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    private Rank noRankCase;
    private Rank firstRankCase;
    private Rank secondRankWithBonusNumberCase;
    private Rank secondRankCase;

    @BeforeEach
    public void init() {
        noRankCase = new Rank(0, false);
        firstRankCase = new Rank(6, true);
        secondRankCase = new Rank(5, false);
        secondRankWithBonusNumberCase = new Rank(5, true);
    }

    @Test
    @Order(1)
    public void 순위찾기_1등() {
        assertThat(firstRankCase.findRank()).isEqualTo("FIRST");
    }

    @Test
    @Order(2)
    public void 순위찾기_2등() {
        assertThat(secondRankCase.findRank()).isEqualTo("SECOND");
    }

    @Test
    @Order(3)
    public void 순위찾기_2등_보너스번호() {
        assertThat(secondRankWithBonusNumberCase.findRank()).isEqualTo("SECOND_WITH_BONUS");
    }

    @Test
    @Order(4)
    public void 순위찾기_순위없음() {
        assertThat(noRankCase.findRank()).isEqualTo("UNKNOWN");
    }
}
