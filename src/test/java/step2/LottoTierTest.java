package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.LottoTier;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTierTest {
    @Test
    @DisplayName("당첨된 숫자에 따라 등 수가 잘 매칭되는지 확인")
    void matchTierTest() {
        assertThat(LottoTier.getResult(6)).isEqualTo(LottoTier.FIRST);
        assertThat(LottoTier.getResult(5)).isEqualTo(LottoTier.SECOND);
        assertThat(LottoTier.getResult(4)).isEqualTo(LottoTier.THIRD);
        assertThat(LottoTier.getResult(3)).isEqualTo(LottoTier.FOURTH);
        assertThat(LottoTier.getResult(2)).isEqualTo(LottoTier.NONE);
        assertThat(LottoTier.getResult(1)).isEqualTo(LottoTier.NONE);
        assertThat(LottoTier.getResult(0)).isEqualTo(LottoTier.NONE);
    }
}
