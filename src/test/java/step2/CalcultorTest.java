package step2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static step2.domian.Calculator.*;

public class CalcultorTest {

    @Test
    void calculate_수익률_로또만원사고_1000원당첨() {
        Assertions.assertThat(calculatePercentage(10000, 1000)).isEqualTo(0.1f);
    }

    @Test
    void calculate_수익금_3개가_3개맞았을_때() {
        Assertions.assertThat(calculateRevenue(List.of(0, 0, 0, 3, 0, 0, 0))).isEqualTo(15000);
    }
}
