package step2;

import org.junit.jupiter.api.Test;
import step2.domain.Rate;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class RateTest {

    @Test
    void 수익률_계산() {

        // given
        int price = 14000;

        Map<Integer, Integer> numberOfMatches = new HashMap<>();

        numberOfMatches.put(3, 1);
        numberOfMatches.put(4, 0);
        numberOfMatches.put(5, 0);
        numberOfMatches.put(6, 0);

        // when
        float result = Rate.calculateRate(numberOfMatches, price);

        // then
        assertThat(result).isEqualTo(0.35f);
    }
}
