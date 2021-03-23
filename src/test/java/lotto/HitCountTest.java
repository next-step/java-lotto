package lotto;

import lotto.domain.HitCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class HitCountTest {
    @DisplayName("당첨갯수를 생성한다")
    @Test
    public void hitCount() {
        HitCount hitCount = new HitCount(5);
        assertThat(hitCount.toString()).isEqualTo("5");
    }
}
