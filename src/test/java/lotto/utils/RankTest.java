package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    @Test
    @DisplayName("rank값으로 Enum객체를 가져온다.")
    public void valueOf() {
        assertThat(Rank.find(3, false)).isEqualTo(Rank.FIFTH);
    }
}
