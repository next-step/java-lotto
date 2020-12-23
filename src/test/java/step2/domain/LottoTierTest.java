package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTierTest {
    @Test
    @DisplayName("일치한 숫자 개수에 따라 적절한 Tier를 반환한다.")
    void getTier() {
        assertThat(LottoTier.getTier(6, true)).isEqualTo(LottoTier.FIRST);
        assertThat(LottoTier.getTier(6, false)).isEqualTo(LottoTier.FIRST);

        assertThat(LottoTier.getTier(5, true)).isEqualTo(LottoTier.SECOND);
        assertThat(LottoTier.getTier(5, false)).isEqualTo(LottoTier.THIRD);

        assertThat(LottoTier.getTier(4, true)).isEqualTo(LottoTier.FOURTH);
        assertThat(LottoTier.getTier(4, false)).isEqualTo(LottoTier.FOURTH);

        assertThat(LottoTier.getTier(3, true)).isEqualTo(LottoTier.FIFTH);
        assertThat(LottoTier.getTier(3, false)).isEqualTo(LottoTier.FIFTH);

        assertThat(LottoTier.getTier(2, true)).isEqualTo(LottoTier.NONE);
        assertThat(LottoTier.getTier(2, false)).isEqualTo(LottoTier.NONE);

        assertThat(LottoTier.getTier(1, true)).isEqualTo(LottoTier.NONE);
        assertThat(LottoTier.getTier(1, false)).isEqualTo(LottoTier.NONE);

        assertThat(LottoTier.getTier(0, true)).isEqualTo(LottoTier.NONE);
        assertThat(LottoTier.getTier(0, false)).isEqualTo(LottoTier.NONE);
    }
}
