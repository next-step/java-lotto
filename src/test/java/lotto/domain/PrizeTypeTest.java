package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class PrizeTypeTest {
    @DisplayName("of 함수는 일치하는 수에 해당하는 PrizeType을 반환한다.")
    @Test
    public void prizeTypeOf() {
        assertAll(
                () -> assertThat(PrizeType.of(6, false)).isEqualTo(PrizeType.FIRST),
                () -> assertThat(PrizeType.of(5, true)).isEqualTo(PrizeType.SECOND),
                () -> assertThat(PrizeType.of(5, false)).isEqualTo(PrizeType.THIRD),
                () -> assertThat(PrizeType.of(4, false)).isEqualTo(PrizeType.FOURTH),
                () -> assertThat(PrizeType.of(3, false)).isEqualTo(PrizeType.FIFTH),
                () -> assertThat(PrizeType.of(2, false)).isEqualTo(PrizeType.MISS),
                () -> assertThat(PrizeType.of(1, false)).isEqualTo(PrizeType.MISS),
                () -> assertThat(PrizeType.of(0, false)).isEqualTo(PrizeType.MISS)
        );
    }
}
