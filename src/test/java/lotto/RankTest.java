package lotto;

import lotto.model.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    @DisplayName("당첨번호와 일치하는 번호 갯수 및 보너스번호 포함여부를 제공하면, Rank를 알려준다.")
    @Test
    void matchTestWhenFirst() {
        Rank matchResult = Rank.getMatchResult(6, false);

        assertThat(matchResult).isEqualTo(Rank.FIRST);
    }
}
