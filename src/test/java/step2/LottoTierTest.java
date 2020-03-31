package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.LottoTier;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTierTest {
    @Test
    @DisplayName("당첨된 숫자에 따라 등 수가 잘 매칭되는지 확인")
    void matchTierTest() {
        assertThat(LottoTier.getTier(6, false)).isEqualTo(LottoTier.FIRST);
        assertThat(LottoTier.getTier(5, false)).isEqualTo(LottoTier.THIRD);
        assertThat(LottoTier.getTier(4, false)).isEqualTo(LottoTier.FOURTH);
        assertThat(LottoTier.getTier(3, false)).isEqualTo(LottoTier.FIFTH);
        assertThat(LottoTier.getTier(2, false)).isEqualTo(LottoTier.NONE);
        assertThat(LottoTier.getTier(1, false)).isEqualTo(LottoTier.NONE);
        assertThat(LottoTier.getTier(0, false)).isEqualTo(LottoTier.NONE);

        assertThat(LottoTier.getTier(6, true)).isEqualTo(LottoTier.FIRST);
        assertThat(LottoTier.getTier(5, true)).isEqualTo(LottoTier.SECOND);
        assertThat(LottoTier.getTier(4, true)).isEqualTo(LottoTier.FOURTH);
        assertThat(LottoTier.getTier(3, true)).isEqualTo(LottoTier.FIFTH);
        assertThat(LottoTier.getTier(2, true)).isEqualTo(LottoTier.NONE);
        assertThat(LottoTier.getTier(1, true)).isEqualTo(LottoTier.NONE);
        assertThat(LottoTier.getTier(0, true)).isEqualTo(LottoTier.NONE);
    }
}
