package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HitCountTest {
    @Test
    @DisplayName("로또 맞힌 개수에 따른 상금 매칭 테스트")
    void hitcount_test(){
        HitCount hitCount = new HitCount(5);
        assertThat(LottoPrize.getPrizeInfoByHitCount(hitCount)).isEqualTo(LottoPrize.THIRD);
    }
}
