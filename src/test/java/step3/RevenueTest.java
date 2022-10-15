package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import step2.domian.Revenue;

import java.util.List;

public class RevenueTest {

    @Test
    void calculate_수익률_로또만원사고_1000원당첨() {
        Assertions.assertThat(new Revenue(1000).calculatePercentage(10000)).isEqualTo(0.1f);
    }

    @Test
    void calculate_수익금_3개가_3개맞았을_때() {
        Assertions.assertThat(new Revenue(List.of(0, 0, 0, 3, 0, 0, 0))).isEqualTo(new Revenue(15000));
    }
}
