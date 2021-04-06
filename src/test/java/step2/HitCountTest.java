package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.Domain.HitCount;
import step2.Domain.LottoPrize;

import static org.assertj.core.api.Assertions.assertThat;

public class HitCountTest {
    @Test
    @DisplayName("로또 맞힌 개수에 따른 상금 매칭 테스트")
    void hitcount_test() {
        HitCount hitCount = new HitCount(3);
        assertThat(LottoPrize.valueOf(hitCount,false)).isEqualTo(LottoPrize.FIFTH);
    }

    @Test
    @DisplayName("로또 맞힌 개수에 따른 상금 매칭 테스트 - 5개 일치 했을 시 2등, 3등 동시 포함되는지 테스트")
    void hitcount_test_second_third() {
        HitCount hitCount = new HitCount(5);
        assertThat(LottoPrize.valueOf(hitCount,true).prize()).isEqualTo(10_000_000);
        assertThat(LottoPrize.valueOf(hitCount,false).prize()).isEqualTo(1_500_000);
    }
}
