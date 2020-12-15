package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTierTest {
    @Test
    @DisplayName("일치한 숫자 개수에 따라 적절한 Tier를 반환한다.")
    void getTier() {
        assertThat(LottoTier.getTier(6)).isEqualTo(LottoTier.FIRST);
        assertThat(LottoTier.getTier(5)).isEqualTo(LottoTier.SECOND);
        assertThat(LottoTier.getTier(4)).isEqualTo(LottoTier.THIRD);
        assertThat(LottoTier.getTier(3)).isEqualTo(LottoTier.FOURTH);
        assertThat(LottoTier.getTier(2)).isEqualTo(LottoTier.NONE);
        assertThat(LottoTier.getTier(1)).isEqualTo(LottoTier.NONE);
        assertThat(LottoTier.getTier(0)).isEqualTo(LottoTier.NONE);
    }
}
