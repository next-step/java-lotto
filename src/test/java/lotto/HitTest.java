package lotto;

import lotto.model.Hit;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HitTest {
    @Test
    public void 맞은_개수_정상_리턴() {
        assertThat(Hit.findByHitCount(3)).isEqualTo(Hit.HIT_3);
        assertThat(Hit.findByHitCount(4)).isEqualTo(Hit.HIT_4);
        assertThat(Hit.findByHitCount(5)).isEqualTo(Hit.HIT_5);
        assertThat(Hit.findByHitCount(6)).isEqualTo(Hit.HIT_6);
        assertThat(Hit.findByHitCount(-1)).isEqualTo(Hit.HIT_NONE);
    }
}
