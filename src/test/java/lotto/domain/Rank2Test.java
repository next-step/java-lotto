package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Rank2Test {
    @Test
    public void 당첨_from_1등_to_5등() {
        assertThat(Rank2.from(6, false)).isEqualTo(Rank2.FIRST);
        assertThat(Rank2.from(5, true)).isEqualTo(Rank2.SECOND);
        assertThat(Rank2.from(5, false)).isEqualTo(Rank2.THIRD);
        assertThat(Rank2.from(4, false)).isEqualTo(Rank2.FOURTH);
        assertThat(Rank2.from(3, false)).isEqualTo(Rank2.FIFTH);
    }

    @Test
    public void 없는_상금_검증() {
        assertThat(Rank2.from(2, false)).isEqualTo(Rank2.NO_MATCH);
    }

    @Test
    public void 당첨금_합계_검증() {
        assertThat(Rank2.FIFTH.addMoney(50_000)).isEqualTo(new Money(55_000));
        assertThat(Rank2.FIFTH.addMoney(new Money(50_000))).isEqualTo(new Money(55_000));
    }
}
