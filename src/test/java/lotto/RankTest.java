package lotto;

import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {


    @DisplayName("일등 테스트")
    @Test
    public void 일등() {
        assertThat(Rank.valueOf(6)).isEqualTo(Rank.FIRST);
    }

}
