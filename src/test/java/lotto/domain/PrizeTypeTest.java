package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeTypeTest {
    @DisplayName("of 함수는 일치하는 수에 해당하는 PrizeType을 반환한다.")
    @Test
    public void prizeTypeOf() {
        assertThat(PrizeType.of(6)).isEqualTo(PrizeType.FIRST);
        assertThat(PrizeType.of(5)).isEqualTo(PrizeType.SECOND);
        assertThat(PrizeType.of(4)).isEqualTo(PrizeType.THIRD);
        assertThat(PrizeType.of(3)).isEqualTo(PrizeType.FOURTH);
        assertThat(PrizeType.of(2)).isEqualTo(PrizeType.MISS);
        assertThat(PrizeType.of(1)).isEqualTo(PrizeType.MISS);
        assertThat(PrizeType.of(0)).isEqualTo(PrizeType.MISS);
    }
}
